package com.zycus.library.interfaces;


import com.zycus.library.entities.Book;
import com.zycus.library.entities.Member;
import com.zycus.library.entities.Title;
import com.zycus.library.exceptions.*;

public interface ILibraryServices {

	//void addNewTitlle(Title title);
	void issueBook(int memberId, String titleName);
	boolean isBookAvailable(String titleName)throws WrongTitleException;
	void addNewTitle(Title title)throws DuplicateMemberException;
	void addNewBook(String titleName,Book book)throws WrongTitleException;
	void addNewMember(Member member) throws DuplicateMemberException;
	void getTotalBookCount();
	void getTotalBookPrice();
	void submitNewMembers() throws ContactAdministratorException;
	
}
