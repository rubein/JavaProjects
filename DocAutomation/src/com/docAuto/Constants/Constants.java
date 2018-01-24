package com.docAuto.Constants;

import com.docAuto.service.ResultsetToExcel;

public interface Constants {

	static final String EXCELFILENAME = "VR4VR_Data UserFriendly-2";
	static final String FILEPATH = "C:\\Users\\rubein\\Desktop\\VR4VR Testing Reports";
	static final String WORDDOCNAME = "VR4VR Individual Customer Report";
	static final String WORDDOCPATH = "C:\\Users\\rubein\\Desktop";
	static final String DATABASEUSERNAME = "root";
	static final String DATABASEPASS = "vrvr";
	static final String DATABASENAME = "jdbc:mysql://localhost:3306/vr4vr";
	static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	static final int RAWDATACOLUMNCOUNT = 20;
//	static final String propertyFilePath = "C:\\Users\\RRT\\Desktop\\VR4VR Testing Reports\\config.properties";
	static final String propertyFilePath = "C:\\Users\\rubein\\Desktop\\VR4VR Testing Reports\\config.properties";
	
	static final String SHEETNAME = "RawData";
	
	
	/*static final ResultsetToExcel.FormatType SESSIONIDTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType JOBCOACHIDTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType USERIDTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType SKILLNUMBERTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType SUBTASKNUMBERTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType LEVELNUMBERTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType LEVELSCORETYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType COMPLETIONTIMETYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType RESULTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType INSTANCECOUNTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType SUCCESSCOUNTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType SUCCESSTIMESTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType FAILCOUNTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType FAILTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType PROMPTCOUNTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType PROMPTTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType DISTRACTORCOUNTTYPE = ResultsetToExcel.FormatType.INTEGER;
	static final ResultsetToExcel.FormatType DISTRACTERORDERTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType DISTRACTERTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SESSIONTIMETYPE = ResultsetToExcel.FormatType.TEXT;
	*/
	static final ResultsetToExcel.FormatType SESSIONIDTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType JOBCOACHIDTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType USERIDTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SKILLNUMBERTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SUBTASKNUMBERTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType LEVELNUMBERTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType LEVELSCORETYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType COMPLETIONTIMETYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType RESULTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType INSTANCECOUNTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SUCCESSCOUNTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SUCCESSTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType FAILCOUNTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType FAILTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType PROMPTCOUNTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType PROMPTTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType DISTRACTORCOUNTTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType DISTRACTERORDERTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType DISTRACTERTIMESTYPE = ResultsetToExcel.FormatType.TEXT;
	static final ResultsetToExcel.FormatType SESSIONTIMETYPE = ResultsetToExcel.FormatType.TEXT;
	
	
}
