package com.zycus.library.entities;

import java.util.ArrayList;


public class Member 
{
	private int memberId;
	private String memberNm;
	
	private ArrayList<Book> booksIssued;
	
	public static final int MAX_BOOKS_ISSUABLE=3;
	
	public Member(int memberId, String memberNm) {
		super();
		booksIssued = new ArrayList<Book>();
		this.memberId = memberId;
		this.memberNm = memberNm;
	}
	
	public int getBookIssuedCount()
	{
		return booksIssued.size();
	}
	
	public void issueBook(Book book)
	{
		booksIssued.add(book);
	}
	public void returnBook(Book book)
	{
		booksIssued.remove(book);
	}

	public int getMemberId() 
	{
		return memberId;
	}

	public String getMemberNm() 
	{
		return memberNm;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberNm=" + memberNm
				+ ", booksIssued=" + booksIssued + "]";
	}
	
	
}
