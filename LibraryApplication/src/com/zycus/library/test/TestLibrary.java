package com.zycus.library.test;

import com.zycus.library.entities.Book;
import com.zycus.library.entities.Member;
import com.zycus.library.entities.Title;
import com.zycus.library.exceptions.ContactAdministratorException;
import com.zycus.library.exceptions.DuplicateMemberException;
import com.zycus.library.exceptions.WrongTitleException;
import com.zycus.library.factories.LibraryFactory;
import com.zycus.library.interfaces.ILibraryServices;

public class TestLibrary {

	public static void main(String[] args) throws DuplicateMemberException, WrongTitleException 
	{
		LibraryFactory factory=null;
		try{
			factory=LibraryFactory.getInstance();
		}catch(ContactAdministratorException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		ILibraryServices libServices=factory.getLibraryServices();
		
		Title title=new Title(1000, "Servlet Jsp", "princeton");
		title.setIsbn("isbn");
		libServices.addNewTitle(title);
		
		Book book1=new Book(1006, title);
		Book book2=new Book(1007, title);
		Book book3=new Book(1008, title);
		book1.setPrice(300);
		book2.setPrice(300);
		book3.setPrice(300);
		
		libServices.addNewBook("Servlet Jsp", book1);
		libServices.addNewBook("Servlet Jsp", book2);
		libServices.addNewBook("Servlet Jsp", book3);
		Member member1=new Member(104, "Sidharth1"); 
		Member member2=new Member(105, "Sidharth2"); 
		Member member3=new Member(106, "Sidharth3"); 
		System.out.println(title);
		
		//Member member=new Member(10, "Sidharth"); 
		Member member=new Member(10, "Sidharth"); 
	try {
			libServices.addNewMember(member1);
			libServices.addNewMember(member2);
			libServices.addNewMember(member3);
			
			libServices.submitNewMembers();
			
		} catch (DuplicateMemberException e) {
			e.printStackTrace();
			//System.out.println("e.getMessage");
		} catch (ContactAdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Issue book to member
		libServices.issueBook(100, "Servlet Jsp");
		System.out.println("total book count");
//		System.out.println(titleList.getTotalBookCount());
		System.out.println("total book price");
//		System.out.println(titleList.getTotalBookPrice());
	}
}
