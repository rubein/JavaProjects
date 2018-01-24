package com.zycus.library.services;

import java.io.IOException;


import com.zycus.library.aggregates.MemberList;
import com.zycus.library.aggregates.TitleList;
import com.zycus.library.entities.Book;
import com.zycus.library.entities.Member;
import com.zycus.library.entities.Title;
import com.zycus.library.exceptions.ContactAdministratorException;
import com.zycus.library.exceptions.DuplicateMemberException;
import com.zycus.library.interfaces.*;

public class LibraryServices implements ILibraryServices, ILibraryServicesStudent
{
	private TitleList titleList;
	private MemberList memberList;
	private static LibraryServices libServices;

	private LibraryServices() throws ContactAdministratorException
	{
		titleList=TitleList.getInstance();
		try{
		memberList=MemberList.getInstance();
		}catch(IOException e){
			throw new ContactAdministratorException("problem in admin file plz contact administrator");
	}
	}
	
	public static LibraryServices getInstance() throws ContactAdministratorException{
		if(libServices==null)
		{
			libServices=new LibraryServices();
		}
		return libServices;
	}
	
	public void issueBook(int memberId, String titleName)
	{
		Member member=memberList.searchMember(memberId);
		Title title1=titleList.searchTitleByName(titleName);
		if(member==null)//throw wrong member id exception
		{
			//System.out.println("Not a member cannot issue book");
			return;
		}
		if(member.getBookIssuedCount()>=3)
		{
			//throw maxBookCount exception
			//System.out.println("Max no of books issued");
			return;
		}
		/*if(title1.getAvailableBook()==null)
		{
			
			System.out.println("no books available");
			return;
		}*/
		Title title=titleList.searchTitleByName(titleName);
		if(title==null)
		{
			return;
			//throw wrongTitleNameException
		}
		Book book=title1.getAvailableBook();
		if(book==null)
		{return;
			//throw BookNotAvailableException
		}
		System.out.println(book);
		book.setStatus("issued");
		member.issueBook(book);
		System.out.println(member);
		book.setMember(member);
		System.out.println("issued to :"+member);
		
	}
	
	
	public void addNewTitle(Title title)
	{
		titleList.addNewTitle(title);
	}
	
	public boolean isBookAvailable(String titleName)
	{
		return titleList.isBookAvailable(titleName);
	}
	
	
	public void addNewBook(String titleName,Book book)
	{
		Title title=titleList.searchTitleByName(titleName);
		if(title==null)
		{
			//throw exception for wrong titleName
		}else
		title.addNewBook(book);
	}
	public void addNewMember(Member member) throws DuplicateMemberException 
	{
		memberList.addNewMember(member);
	}
	public void getTotalBookCount() 
	{
		titleList.getTotalBookCount();
	}
	
	public void getTotalBookPrice() 
	{
		titleList.getTotalBookPrice();
		
	}

	public void submitNewMembers() throws ContactAdministratorException {
		try{
		memberList.submitMembers();
		}catch(IOException e){
			throw new ContactAdministratorException("data file missing. Contact Admin.");
		}
	}
}
