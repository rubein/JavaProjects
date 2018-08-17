import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Rubein
 *
 */

public class ReadExcel {
	
	public static final String XLSX_FILE_PATH_1 = "C:\\Users\\Rubein\\Desktop\\Sarang\\1.xlsx";
	public static final String XLSX_FILE_PATH_2 = "C:\\Users\\Rubein\\Desktop\\Sarang\\2.xlsx";
	public static final String XLSX_FILE_PATH_3 = "C:\\Users\\Rubein\\Desktop\\Sarang\\3.xlsx";

	public static void main(String[] args) {

		String fullName = "";
		String rowTrackingId = null;

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook1 = null;
		Workbook workbook2 = null;
		Workbook workbook3 = null;

		FileInputStream file1 = null;
		FileInputStream file2 = null;
		FileInputStream file3 = null;
		
		try {
			file1 = new FileInputStream(XLSX_FILE_PATH_1);
			file2 = new FileInputStream(XLSX_FILE_PATH_2);
			file3 = new FileInputStream(XLSX_FILE_PATH_3);

			workbook1 = WorkbookFactory.create(file1);
			workbook2 = WorkbookFactory.create(file2);
			workbook3 = WorkbookFactory.create(file3);
			
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Getting the Sheets
		Sheet sheet1 = workbook1.getSheet("Sheet2");
		Sheet sheet2 = workbook2.getSheet("Completed");
		Sheet sheet3 = workbook3.getSheet("Sheet1");

		System.out.println("books loaded");
		Iterator<Row> rowIterator1 = sheet1.rowIterator();
		DataFormatter dataFormatter = new DataFormatter();

		while (rowIterator1.hasNext()) {

			Row rowSheet1 = rowIterator1.next();
			Iterator<Cell> cellIterator1 = rowSheet1.cellIterator();
			int count1 = 0;
			/**
			 * Gives you the tracking id and full name from sheet 1
			 */
			while (cellIterator1.hasNext()) {
				Cell cell = cellIterator1.next();

				if (count1 == 0) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					rowTrackingId = cell.getStringCellValue();
				}

				if (count1 == 13) {
					fullName = dataFormatter.formatCellValue(cell);
				//	System.out.println(fullName);
					break;
				}
				count1 = count1 + 1;
			}

			// get last name from sheet 1
		//	String lastName = separateLastName(fullName);

			// step 3: search for last name in sheet 2.
			Iterator<Row> rowIterator2 = sheet2.rowIterator();
			Row rowSheet2 = rowIterator2.next();
			Iterator<Cell> cellIterator2 = rowSheet2.cellIterator();
			String lastNameInSheet2 = null;
			String firstNameInSheet2 = null;
			
			while (rowIterator2.hasNext()) {

				rowSheet2 = rowIterator2.next();
				cellIterator2 = rowSheet2.cellIterator();

				int count2 = 0;
				while (count2 < 11) {

					Cell cell = cellIterator2.next();
					if (count2 == 9) {
						lastNameInSheet2 = dataFormatter.formatCellValue(cell);
					}
					if (count2 == 10) {
						firstNameInSheet2 = dataFormatter.formatCellValue(cell);
					}
					count2 = count2 + 1;
				}

				/**
				 * if name matches in both the files then check in 3rd sheet for name/id and if
				 * not paste
				 */
				if (fullName.equalsIgnoreCase(firstNameInSheet2 + " " + lastNameInSheet2) || fullName.equalsIgnoreCase(lastNameInSheet2 + " " + firstNameInSheet2)) {
					System.out.println("Comparing");
					boolean isIdPresent = false;
				//	System.out.println(firstNameInSheet2 + " " + lastNameInSheet2 + "matches in both the sheet");
					Iterator<Row> rowIterator3 = sheet3.rowIterator();
					Row rowSheet3 = rowIterator3.next();
					Iterator<Cell> cellIterator3 = rowSheet3.cellIterator();
					
					// This will iterate sheet 3 to check if the id exists
					while (rowIterator3.hasNext()) {
						rowSheet3 = rowIterator3.next();
						Cell firstCell = rowSheet3.getCell(0);
						String cellValue = ""+ getCellValue(firstCell);
						
						if(rowTrackingId.equals(cellValue)) {
			//				System.out.println("we are comparing "+ rowTrackingId + " with cell value " + cellValue);
							isIdPresent = true;
							break;
						}
					}
					if (isIdPresent == false) {
			//			System.err.println("Need to copy data from sheet 2 for " + fullName);
						// copy row from 2 rowSheet2 and paste in 3 with id from 1
						int newRowCount = sheet3.getLastRowNum()+1;
			//			System.out.println("record will be added to row number : " + (newRowCount));
						Row newRow = sheet3.createRow((newRowCount));
						copyRow(newRow, rowSheet2, rowTrackingId);
			//			System.out.println("record copied!!! ");
					}
				}
			}
		}

		System.err.println("Closing all books");
		FileOutputStream op3;
		try {
			file1.close();
			file2.close();
			file3.close();
			
			op3 = new FileOutputStream(XLSX_FILE_PATH_3);
			workbook3.write(op3);
			op3.close();
			workbook1.close();
			workbook2.close();
			workbook3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static String getCellValue(Cell cell) {
		String value = null;
		
		if (cell!=null) {
		    switch (cell.getCellType()) {
		        case Cell.CELL_TYPE_BOOLEAN:
		        	value = ""+ cell.getBooleanCellValue();
		            break;
		        case Cell.CELL_TYPE_NUMERIC:
		        	value = ""+ cell.getNumericCellValue();
		            break;
		        case Cell.CELL_TYPE_STRING:
		        	value = ""+ cell.getStringCellValue();
		            break;
		        case Cell.CELL_TYPE_BLANK:
		            break;
		        case Cell.CELL_TYPE_ERROR:
		        	value = ""+cell.getErrorCellValue();
		            break;

		        // CELL_TYPE_FORMULA will never occur
		        case Cell.CELL_TYPE_FORMULA: 
		            break;
		    }
		}
		return value;
	}
	
	
	private static void copyRow(Row newRow, Row rowSheet2, String trackingId) {
		System.out.println("copying");
	//	System.err.println("start copying");
		for (int i = 0; i < rowSheet2.getLastCellNum(); i++) {

			Cell oldCell = rowSheet2.getCell(i);
			Cell newCell = newRow.createCell(i);

			if (oldCell == null) {
				newCell = null;
				continue;
			}

			if (i == 0) {
				newCell.setCellValue(trackingId);
			//	System.out.println(trackingId);
			} else {
				switch (oldCell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					newCell.setCellValue(oldCell.getStringCellValue());
					// System.out.println(oldCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					newCell.setCellValue(oldCell.getBooleanCellValue());
					// System.out.println(oldCell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_ERROR:
					newCell.setCellErrorValue(oldCell.getErrorCellValue());
					// System.out.println(oldCell.getErrorCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					newCell.setCellFormula(oldCell.getCellFormula());
					// System.out.println(oldCell.getCellFormula());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					newCell.setCellValue(oldCell.getNumericCellValue());
					// System.out.println(oldCell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					newCell.setCellValue(oldCell.getRichStringCellValue());
					// System.out.println(oldCell.getRichStringCellValue());
					break;
				}
			}
		}
	//	System.err.println("copying ends");
	}

	private static String separateLastName(String fullName) {
		String lastName = "";
		fullName = fullName.trim();
		String firstName = "";
		if (!fullName.equals("")) {
			StringTokenizer token = new StringTokenizer(fullName.trim(), " ");
			fullName = fullName.replace(".", "");
			fullName = fullName.replace(",", "");
			fullName = fullName.replace("-", "");
			firstName = token.nextToken();
			
			while (token.hasMoreTokens()) {
				lastName = lastName + token.nextToken() + " ";
			}
		}
		return lastName;
	}

}
