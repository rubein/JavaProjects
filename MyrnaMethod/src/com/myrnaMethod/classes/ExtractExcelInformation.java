package com.myrnaMethod.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.myrnaMethod.Mail.MailShooter;
import com.myrnaMethod.constants.Constants;
import com.myrnaMethod.dao.BaseDao;
import com.myrnaMethod.servlets.UploadExcelFile;

public class ExtractExcelInformation {

	String absolutePath = Constants.filePath + File.separator + UploadExcelFile.filename;
	MailShooter mail = new MailShooter();
	public int totalRows = 0;

	static {
		BaseDao dao = new BaseDao();
		if (!dao.checkTableEntry(Constants.table1Name)) {
			dao.createFoodTable(Constants.table1Name);
		}
		if (!dao.checkTableEntry(Constants.table2Name)) {
			dao.createFoodTable(Constants.table2Name);
		}
		if (!dao.checkTableEntry(Constants.table3Name)) {
			dao.createFoodTable(Constants.table3Name);
		}
	}

	/**
	 * This method updates the row number from where the data needs to be entered in the database.
	 */
	private void updateLastRowNumber(){
		BaseDao dao = new BaseDao();
		dao.lastRow = dao.getLastRowNumberForFoodDB(Constants.table2Name);
		System.out.println("Last row # in foodDatabase table is: " + dao.lastRow);
	}
	
	public String loadSheetInDatabase(String inputFile) {
		
		BaseDao dao = new BaseDao();
		System.out.println("Absolute path of the file is " + absolutePath);
		
		updateLastRowNumber();
		
		try {
			
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
			XSSFSheet sheet = wb.getSheet("Data Sheet");
			System.out.println("Sheet name is :: "+ sheet.getSheetName());
			Row row;
			Cell cell;
			int rowNumber = 1;
			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			totalRows = sheet.getPhysicalNumberOfRows();
			
		//	totalRows = totalRows-1;
			for(int i = 0; i < totalRows-1; i++){
		//	while (rowIterator.hasNext()) {
				row = sheet.getRow(rowNumber);
				Iterator<Cell> cellIterator = row.cellIterator();
				String foodName = null, valid = null, unit; 
				float amount = 0, calories = 0, protein = 0, fiber = 0, carbs = 0, fats = 0;
				
				while(cellIterator.hasNext()){
					foodName = getData(cellIterator.next());
					amount = Float.valueOf(getData(cellIterator.next()));
					unit = getData(cellIterator.next());
					calories = Float.valueOf(getData(cellIterator.next()));
					protein = Float.valueOf(getData(cellIterator.next())); 
					fats = Float.valueOf(getData(cellIterator.next()));
					carbs = Float.valueOf(getData(cellIterator.next()));
					fiber = Float.valueOf(getData(cellIterator.next()));
					valid = "verified";
				}
				// find database ka last entry and then add with id
				dao.addDataToDatabase(foodName, amount, calories, protein, fiber, carbs, fats, valid, "");
				rowNumber = rowNumber + 1;
			}
		}catch(
	FileNotFoundException e)
	{
	//	mail.sendMail(e.getMessage(), e);
		e.printStackTrace();
	}catch(
	IOException e)
	{
    //        mail.sendMail(e.getMessage(), e);
			e.printStackTrace();
		}return"success";
	}
	
	
	private static String getData(Cell newCell) {
		String value = null;
				switch ( newCell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					value = newCell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					value = "" +newCell.getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_ERROR:
					value = "" +newCell.getErrorCellValue();
					break;
				case Cell.CELL_TYPE_FORMULA:
					value = "" +newCell.getCellFormula();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					value = "" +newCell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_STRING:
					value = "" +newCell.getRichStringCellValue();
					break;
		}
		return value;
	}


	/*
	 * private static void copyRow(XSSFWorkbook workbook, XSSFSheet worksheet,
	 * int sourceRowNum) { // Get the source / new row Row newRow =
	 * worksheet.getRow(worksheet.getLastRowNum()+1); Row sourceRow =
	 * worksheet.getRow(sourceRowNum);
	 * 
	 * // If the row exist in destination,create a new row newRow =
	 * worksheet.createRow(worksheet.getLastRowNum()+1);
	 * 
	 * 
	 * // Loop through source columns to add to new row for (int i = 0; i < 4;
	 * i++) { // Grab a copy of the old/new cell
	 * 
	 * Cell newCell = newRow.createCell(i);
	 * 
	 * // If the old cell is null jump to next cell
	 * 
	 * 
	 * // Copy style from old cell and apply to new cell // XSSFCellStyle
	 * newCellStyle = workbook.createCellStyle(); //
	 * newCellStyle.cloneStyleFrom(oldCell.getCellStyle()); ; //
	 * newCell.setCellStyle(newCellStyle);
	 * 
	 * // If there is a cell comment, copy if (oldCell.getCellComment() != null)
	 * { newCell.setCellComment(oldCell.getCellComment()); }
	 * 
	 * // If there is a cell hyperlink, copy if (oldCell.getHyperlink() != null)
	 * { newCell.setHyperlink(oldCell.getHyperlink()); }
	 * 
	 * // Set the cell data type newCell.setCellType(oldCell.getCellType());
	 * 
	 * // Set the cell data value switch (oldCell.getCellType()) { case
	 * Cell.CELL_TYPE_BLANK: newCell.setCellValue(oldCell.getStringCellValue());
	 * break; case Cell.CELL_TYPE_BOOLEAN:
	 * newCell.setCellValue(oldCell.getBooleanCellValue()); break; case
	 * Cell.CELL_TYPE_ERROR:
	 * newCell.setCellErrorValue(oldCell.getErrorCellValue()); break; case
	 * Cell.CELL_TYPE_FORMULA: newCell.setCellFormula(oldCell.getCellFormula());
	 * break; case Cell.CELL_TYPE_NUMERIC:
	 * newCell.setCellValue(oldCell.getNumericCellValue()); break; case
	 * Cell.CELL_TYPE_STRING:
	 * newCell.setCellValue(oldCell.getRichStringCellValue()); break; } } }
	 */
	/*
	 * public void InsertRowInDB(List<String> headers, List<String> values)
	 * throws SQLException, ClassNotFoundException {
	 * 
	 * Class.forName("org.postgresql.Driver"); System.out.println("connected");
	 * Connection conn = DriverManager.getConnection("jdbc:postgresql:postgres",
	 * "postgres", "sridevi");
	 * 
	 * String insertColumns = ""; String preparedStatementClause = ""; for (int
	 * i = 0; i < headers.size(); i++) { String fieldValue = headers[i];
	 * insertColumns += fieldValue; preparedStatementClause += "?"; if (i <=
	 * (headers.size() - 1)) { insertColumns += ", "; preparedStatementClause +=
	 * ", "; } }
	 * 
	 * String query = String.format("Insert into excel(%s) values(%s)",
	 * insertColumns, preparedStatementClause); PreparedStatement ps =
	 * conn.prepareStatement(query); for (int i = 0; i < values.size(); i++) {
	 * ps.setString(i, values[i]); } ps.executeUpdate();
	 * System.out.println("Values Inserted Successfully"); }
	 */
	public static void main(String[] args) {
		new ExtractExcelInformation().loadSheetInDatabase("C:\\Users\\Rubein\\Desktop\\Books\\sem 3\\ADBMS\\excel\\test\\db11-10.xlsx");
	}

}
