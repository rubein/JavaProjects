package com.docAuto.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.docAuto.Constants.Constants;
import com.docAuto.aggregates.DocAutomation;

public class Service {

	public void getUserId() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			System.out.println(Constants.propertyFilePath);
			input = new FileInputStream(Constants.propertyFilePath);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			DocAutomation.userId = Integer.parseInt(prop.getProperty("userId"));
			DocAutomation.filePath = prop.getProperty("filePath");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
