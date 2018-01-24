package com.zycus.library.test;

import java.io.IOException;

import com.zycus.library.aggregates.MemberList;
import com.zycus.library.aggregates.TitleList;
import com.zycus.library.exceptions.ContactAdministratorException;
import com.zycus.library.interfaces.ILibraryServices;
import com.zycus.library.services.LibraryServices;

public class ClientUI {

	public static void main(String[] args) {
		TitleList titleList=TitleList.getInstance();
		try {
			MemberList memberList=MemberList.getInstance();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ILibraryServices libServices = null;
		try {
			libServices = LibraryServices.getInstance();
		} catch (ContactAdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		libServices.issueBook(100, "Java");
		libServices.issueBook(105, "Java");
		
		
	}

}
