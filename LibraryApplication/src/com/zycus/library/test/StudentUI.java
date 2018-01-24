package com.zycus.library.test;

import com.zycus.library.exceptions.ContactAdministratorException;
import com.zycus.library.factories.LibraryFactory;
import com.zycus.library.interfaces.ILibraryServicesStudent;

public class StudentUI {

	public static void main(String[] args) 
	{
		
		LibraryFactory factory = null;
		try {
			factory = LibraryFactory.getInstance();
		} catch (ContactAdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		ILibraryServicesStudent libStudent= factory.getLibraryServicesStudent();
		
		libStudent.isBookAvailable("");
		
	}
}
