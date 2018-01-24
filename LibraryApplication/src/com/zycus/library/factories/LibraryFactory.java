package com.zycus.library.factories;

import com.zycus.library.aggregates.MemberList;
import com.zycus.library.aggregates.TitleList;
import com.zycus.library.exceptions.ContactAdministratorException;
import com.zycus.library.interfaces.ILibraryServices;
import com.zycus.library.interfaces.ILibraryServicesStudent;
import com.zycus.library.services.LibraryServices;

public class LibraryFactory {
	private LibraryServices libraryServices;
	private static LibraryFactory libraryFactory;
	private LibraryFactory() throws ContactAdministratorException
	{
		libraryServices=LibraryServices.getInstance();
	}
	
	public static LibraryFactory getInstance() throws ContactAdministratorException{
		if(libraryFactory==null){
			libraryFactory=new LibraryFactory();
		}return libraryFactory;
	}
	
	public ILibraryServices getLibraryServices() 
	{
		return libraryServices;
	}
	public ILibraryServicesStudent getLibraryServicesStudent() 
	{
		return libraryServices;
	}
}