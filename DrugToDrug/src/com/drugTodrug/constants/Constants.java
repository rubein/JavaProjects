package com.drugTodrug.constants;

public interface Constants {
	public static String insertNewPassword ="INSERT INTO public.Admin (	'UserName', 'Password') ";
	public static String filePath="C:\\Users\\Rubein\\Desktop\\Books\\sem 3\\ADBMS\\excel\\test";
	public static String checkTableExistQuery = "SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_schema = 'public' AND table_name ='drugsList');";
	public static String adminPasswordQuery = "Select \"Password\" from admin where \"UserName\"='";
	public static String createDrugTableQuery = "Create table drugsList (Drug text,Enzyme text,Relationship text, DataResource text);";
	public static String insertDataQuery = "insert into drugsList values (?,?,?,?)";
	public static int batchSize = 500;
	public static String mailTo = "rubeinspam@gmail.com";
	public static String password = "pass@123";
	public static String mailFrom = "noreply@mail.usf.edu";
	public static String mailHost = "localhost";// when deployed on server add ip address.
	public static String mailPort = "465";
	public static String authPort = "465";
	public static String host = "smtp.gmail.com";
	public static String evaluateQuery1 = "SELECT DISTINCT * " + 
			"FROM ( " +
			"SELECT DISTINCT ON (de1.drug, de1.relationship, de2.drug, de2.relationship) de1.drug, de1.relationship, de2.drug, de2.relationship, de1.enzyme " +
			"FROM drugsList de1, drugsList de2 " +
			"WHERE de1.enzyme = de2.enzyme AND " +
			    "TRIM(lower(de1.drug)) = '" ;
	
	public static String evaluateQueryPart2 = "' AND " + "TRIM(lower(de2.drug)) = '";  // add drugb
	public static String evaluateQueryPart3 = "' AND " +
		    "TRIM(lower(de1.drug)) != TRIM(lower(de2.drug)) AND " +
		    "de1.relationship like '%substrate%' AND " +
		    "(de2.relationship like '%inducer%' OR " +
		    "de2.relationship like '%inhibitor%') " +
		"UNION ALL " +
		"SELECT DISTINCT ON (de1.drug, de1.relationship, de2.drug, de2.relationship) de1.drug, de1.relationship, de2.drug, de2.relationship, de1.enzyme " +
		"FROM drugsList de1, drugsList de2 " +
		"WHERE de1.enzyme = de2.enzyme AND " +
		    "TRIM(lower(de1.drug)) = '";
	
	// part 2 firsele
	public static String evaluateQueryPart4 = "' AND " +
		    "TRIM(lower(de1.drug)) != TRIM(lower(de2.drug)) AND " +
		    "de2.relationship like '%substrate%' AND " +
		    "(de1.relationship like '%inducer%' OR " +
		    "de1.relationship like '%inhibitor%')" +
		") AS T1"; 
	
	
	public static String calculateDDIPart1 = "SELECT COUNT(*) FROM ( SELECT DISTINCT ON (drug, enzyme, relationship, dataResource) drug, enzyme, relationship, dataResource FROM drugsList " +
			"WHERE TRIM(lower(drug)) = '";
	
	//drug
	public static String calculateDDIPart2 = "' AND enzyme like '%";
	//enzyme
	public static String calculateDDIPart3 = "%' AND relationship like '%";
	
	//relationship
	public static String calculateDDIPart4 = "%') AS T1";
	
}


