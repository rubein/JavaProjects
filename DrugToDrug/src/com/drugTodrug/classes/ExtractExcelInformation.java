package com.drugTodrug.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.drugTodrug.Mail.MailShooter;
import com.drugTodrug.constants.Constants;
import com.drugTodrug.dao.BaseDao;
import com.drugTodrug.servlets.UploadExcelFile;

public class ExtractExcelInformation {

//	String fileName = UploadExcelFile.filename;
//	String filePath = Constants.filePath;
	String absolutePath = Constants.filePath + File.separator + UploadExcelFile.filename;
	MailShooter mail = new MailShooter();
	public static int totalRows = 0;
	static{
		BaseDao dao= new BaseDao();
		if(!dao.checkTableEntry()){
			dao.createDrugTable();
		}
	}
	
	public String loadSheetInDatabase(String inputFile) {
		BaseDao dao = new BaseDao();
		System.out.println("Absolute path of the file is " + absolutePath);
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

			// Get first sheet from the workbook
			XSSFSheet sheet = wb.getSheetAt(0);
			System.out.println("Sheet name is :: "+ wb.getSheetName(0));
			Row row;
			Cell cell;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			totalRows = sheet.getPhysicalNumberOfRows();
			totalRows = totalRows-1;
			Boolean parsedHeaders = false;
			List<String> headers = new ArrayList<String>();
			List<String> rowValues = null;
			
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (parsedHeaders) {
					rowValues = new ArrayList<String>();
				}
				 System.out.println ("Row No.: " + row.getRowNum ());
				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int count = 0;
				while (cellIterator.hasNext() && count < 4 ) {
					cell = cellIterator.next();
					if (!parsedHeaders) {
						headers.add(cell.getStringCellValue());
					} else {
						rowValues.add(cell.getStringCellValue());
					}
					count++;
				}
				if (!parsedHeaders) {
					parsedHeaders = true;
				} else {
					String drug = null, enzyme= null, relationship = null, dataResource = null;
					int i = 0;
					for (String fieldValue : rowValues) {
						if(i == 0){
							drug = fieldValue;
						}
						if(i == 1){
							enzyme = fieldValue;
						}
						if(i == 2){
							relationship = fieldValue;
						}
						if(i == 3){
							dataResource = fieldValue;
						}
						i = i + 1;
					}
					dao.addDataToDatabase(drug, enzyme, relationship, dataResource, row.getRowNum ());
				}
			}
		} catch (FileNotFoundException e) {
            mail.sendMail(e.getMessage(), e);

			e.printStackTrace();
		} catch (IOException e) {
            mail.sendMail(e.getMessage(), e);

			e.printStackTrace();
		}
		return "success";
	}

	/*public void InsertRowInDB(List<String> headers, List<String> values) throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		System.out.println("connected");
		Connection conn = DriverManager.getConnection("jdbc:postgresql:postgres", "postgres", "sridevi");

		String insertColumns = "";
		String preparedStatementClause = "";
		for (int i = 0; i < headers.size(); i++) {
			String fieldValue = headers[i];
			insertColumns += fieldValue;
			preparedStatementClause += "?";
			if (i <= (headers.size() - 1)) {
				insertColumns += ", ";
				preparedStatementClause += ", ";
			}
		}

		String query = String.format("Insert into excel(%s) values(%s)", insertColumns, preparedStatementClause);
		PreparedStatement ps = conn.prepareStatement(query);
		for (int i = 0; i < values.size(); i++) {
			ps.setString(i, values[i]);
		}
		ps.executeUpdate();
		System.out.println("Values Inserted Successfully");
	}
*/
	public static void main(String[] args) {
		new ExtractExcelInformation().loadSheetInDatabase("C:\\Users\\Rubein\\Desktop\\Books\\sem 3\\ADBMS\\excel\\test\\db11-10.xlsx");
	}

}
