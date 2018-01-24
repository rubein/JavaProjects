package com.zycus.empAttendance.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {
	public static void main(String[] args) {
		String filePath="D:\\RubeinEmpAttandance\\EmployeeAttendance\\Data";
		String fileName="Configuration.properties" ;

		File file =new File(filePath+"\\"+fileName);
		
		FileInputStream fisConfig=null;
		FileInputStream fis=null;
		
		try {
			fisConfig=new FileInputStream(file);
			Properties props=new Properties();
			props.load(fisConfig);
			
			fis=new FileInputStream(props.getProperty("filePath")+"\\"+ props.getProperty("fileName"));//opens a file in input mode
			
			int fileChar=fis.read();
			while (fileChar !=-1)
			{
				System.out.print((char)fileChar);
				fileChar=fis.read();
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{ 
				if(fisConfig!=null)
					fisConfig.close();
				if(fis!=null)
					fis.close();
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}