--<ScriptOptions statementTerminator=";"/>

CREATE TABLE IF NOT EXISTS session (sessioinId VARCHAR(20) PRIMARY KEY,`incidentId` VARCHAR(20) NOT NULL,`sessionName` VARCHAR(45) NOT NULL,`time` VARCHAR(100) NOT NULL, `sessionStatus` VARCHAR(50) NOT NULL,`emailId` VARCHAR(100) NOT NULL,`malwareScanStatus` VARCHAR(100) NOT NULL);
CREATE TABLE IF NOT EXISTS incident (`incidentId` VARCHAR(20) PRIMARY KEY,`incidentName` VARCHAR(100) NOT NULL, `email` VARCHAR(100) NOT NULL, `time` VARCHAR(100) NOT NULL);

