package com.bestGame.constants;

public interface Constants {

	// Hours to stall user to vote.
	public static int hoursToStall = 24;

	// -----------------Database Table and Schema Names------------------//
	public static String table1Name = "voters";
	public static String table2Name = "systemConfig";
	public static String databaseName = "votedatabase";
	// -----------------Database Table and Schema Names------------------//

	// -----------------Database Config------------------//
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String databaseConnAddr = "jdbc:mysql://localhost:3306/sys";
	public static String databaseUserName = "root";
	public static String databasePassword = "Pass@123";
	// -----------------Database Config------------------//

	// -----------------Create Tables and Schema Query------------------//
	public static String createDatabase = "CREATE DATABASE IF NOT EXISTS ";
	public static String createVoterTableQuery = "CREATE TABLE IF NOT EXISTS `votedatabase`.`voters` (`voterId` VARCHAR(100) NOT NULL, `time` VARCHAR(100) NOT NULL, PRIMARY KEY (`voterId`));";
	public static String createSysConfigTableQuery = "CREATE TABLE IF NOT EXISTS `votedatabase`.`systemconfig` (`ip` VARCHAR(45) NOT NULL,`time` VARCHAR(100) NOT NULL,`host` VARCHAR(80) NOT NULL,PRIMARY KEY (`ip`));";
	// -----------------Create Tables and Schema Query------------------//

	// -----------------Game Names------------------//
	public static String game1 = "Overwatch";
	public static String game2 = "Warcraft";
	public static String game3 = "PUBG";
	public static String game4 = "Legends";
	// ------------------Game Names-----------------//

	// -----------------Retrieve voterid and host used.------------------//
	public static String checkIfIdIsPresent = "Select time from votedatabase.voters where voterId='";
	public static String checkForHostAndIPQuery = "Select time from votedatabase.systemConfig where host = '";
	// -----------------Retrieve voterid and host used.------------------//

	// -----------------Check for tables------------------//
	public static String checkVoterTableExistQuery = "SELECT * FROM information_schema.tables WHERE table_schema = 'votedatabase' AND table_name ='votedatabase.voters'";
	public static String checkSystemConfigTableExistQuery = "SELECT * FROM information_schema.tables WHERE table_schema = 'votedatabase' AND table_name ='systemConfig'";
	// -----------------Check for tables------------------//

	// -----------------Add/Update voter date and time ------------------//
	public static String addVoterToDatabaseQuery = "INSERT INTO `votedatabase`.`voters` VALUES (?,?)";
	public static String updateAccessTime = "UPDATE `votedatabase`.`voters` SET `time`='";
	// -----------------Add/Update voter date and time ------------------//

	// -----------------Add/Update host to database------------------//
	public static String addHostToDatabaseQuery = "INSERT INTO `votedatabase`.`systemConfig` VALUES (?,?,?)";
	public static String updateHostAccessTime = "UPDATE `votedatabase`.`systemConfig` SET `time`='";
	// -----------------Add/Update host to database------------------//
}