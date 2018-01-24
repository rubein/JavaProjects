package com.docAuto.aggregates;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

import com.docAuto.Constants.Constants;
import com.docAuto.dao.DAO;
import com.docAuto.service.ResultsetToExcel;
import com.docAuto.service.Service;

/**
 * 
 * @author rubein This is the main class which will manage the application.
 *
 */
public class DocAutomation {
	public static int userId = 0;
	public static String filePath = "";
	
	
	public static void main(String[] args) {

		String excelFileName = Constants.EXCELFILENAME;

		DAO dao = new DAO();
		/**
		 * connects to data base and gets the data.
		 */
		
		Service service = new Service();
		service.getUserId();
	//	dao.connectToDatabase();

		ResultsetToExcel rsToExcel = new ResultsetToExcel(ResultsetToExcel.rs, new ResultsetToExcel.FormatType[] {
				Constants.SESSIONIDTYPE, Constants.JOBCOACHIDTYPE, Constants.USERIDTYPE, Constants.SKILLNUMBERTYPE, Constants.SUBTASKNUMBERTYPE, 
				Constants.LEVELNUMBERTYPE, Constants.LEVELSCORETYPE, Constants.COMPLETIONTIMETYPE, Constants.RESULTTYPE, Constants.INSTANCECOUNTTYPE,
				Constants.SUCCESSCOUNTTYPE, Constants.SUCCESSTIMESTYPE, Constants.FAILCOUNTTYPE, Constants.FAILTIMESTYPE, Constants.PROMPTCOUNTTYPE,
				Constants.PROMPTTIMESTYPE, Constants.DISTRACTORCOUNTTYPE, Constants.DISTRACTERORDERTYPE, Constants.DISTRACTERTIMESTYPE, Constants.SESSIONTIMETYPE
				}, Constants.SHEETNAME);
		
		try {
			/**
			 * will create excel file with raw data on the desktop.
			 */
			System.out.println("FilePath : " + filePath);
			rsToExcel.generate(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Please enter correct file path. File is not present on the given path..");
			e.printStackTrace();
		}
		catch(FileAlreadyExistsException e) {
			System.out.println("File Already Exist exception");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception generating the file...");
			e.printStackTrace();
		}
	}
	
	
	
	
}
