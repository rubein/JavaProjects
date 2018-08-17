package com.myrnaMethod.constants;

public interface Constants {
	public static String insertNewPassword ="INSERT INTO Admin ('UserName', 'Password') ";
	public static String filePath="C:\\Users\\Rubein\\Desktop\\myrna project";
	
	// tables in database
	public static String table1Name = "members";
	public static String table2Name = "fooddatabase";
	public static String table3Name = "memberfoodintake";
	
	public static String checkMemberTableExistQuery = "SELECT * FROM information_schema.tables WHERE table_name ='members' LIMIT 1";
	public static String checkFoodTableExistQuery = "SELECT * FROM information_schema.tables WHERE table_name ='fooddatabase' LIMIT 1";
	public static String checkFoodIntakeTableExistQuery = "SELECT * FROM information_schema.tables WHERE table_name ='memberfoodintake' LIMIT 1";
	
	public static String adminPasswordQuery = "Select password from sys.members where email='";

	//To create tables in database when the application loads for the first time.
	public static String createMemberTableQuery = "CREATE TABLE `sys`.`members`(`memberId` INT NOT NULL, `firstName` VARCHAR(45) NULL, `lastName` VARCHAR(45) NULL, `memberActive` VARCHAR(45) NULL, `startDate` VARCHAR(45) NULL,  `memberFor` INT NULL,  `email` VARCHAR(45) NOT NULL,  `password` VARCHAR(45) NULL,  PRIMARY KEY (`memberId`, `email`));";
	public static String createFoodTableQuery = "CREATE TABLE `sys`.`fooddatabase` (`foodId` INT NOT NULL, `name` VARCHAR(45) NULL, `amount` FLOAT NULL, `calories` FLOAT NULL, `protein` FLOAT NULL, `fiber` FLOAT NULL, `carbs` FLOAT NULL, `fats` FLOAT NULL, `verified` INT NULL, `category` VARCHAR(45) NULL, PRIMARY KEY (`foodId`));";
	public static String createFoodIntakeTableQuery = "CREATE TABLE `sys`.`memberfoodintake`(`intakeId` INT NOT NULL, `memberId` INT NULL, `foodId` INT NULL,`time` VARCHAR(45) NULL, `date` VARCHAR(45) NULL,`mealType` INT NULL, PRIMARY KEY (`intakeId`));";
	
	public static String lastRowQueryForFoodDB = "SELECT COUNT(*) FROM ";
	
	public static String insertDataQuery = "insert into fooddatabase values (?,?,?,?,?,?,?,?,?,?)";
	public static String insertNewMember = "INSERT INTO `sys`.`members` (`memberId`, `firstName`, `lastName`, `memberActive`, `startDate`, `memberFor`, `email`, `password`) VALUES (?,?,?,?,?,?,?,?);";
	
	public static String getLastColumnNumber = "select Max(memberId) from sys.members;";
	
	
	public static String mailTo = "rubeinspam@gmail.com";
	public static String password = "pass@123";
	public static String mailFrom = "noreply@mail.usf.edu";
	public static String mailHost = "localhost";// when deployed on server add ip address.
	public static String mailPort = "465";
	public static String authPort = "465";
	public static String host = "smtp.gmail.com";
	
	
	
}


