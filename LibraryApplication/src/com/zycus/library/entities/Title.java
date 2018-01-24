package com.zycus.library.entities;

import java.util.ArrayList;

public class Title
{
private int titleId;
private String titleName;
private String publication;
private String isbn;

private ArrayList<Book> books;

public Title(int titleId, String titleName, String publication) 
{
	super();
	books=new ArrayList<Book>();
	this.titleId = titleId;
	this.titleName = titleName;
	this.publication = publication;
}

public void addNewBook(Book book)
{
	books.add(book);
	System.out.println(book);
}

public String getIsbn() 
{
	return isbn;
}

public void setIsbn(String isbn) 
{
	this.isbn = isbn;
}

public int getTitleId() 
{
	return titleId;
}

public String getTitleName() 
{
	return titleName;
}

public String getPublication() 
{
	return publication;
}

public Book getAvailableBook()
{
	for(Book book : books )
	{
		if (book.getStatus().equals("Available"))
		{
			return book;
		}
	}
	return null;
}

public int countBooks()
{
	return books.size();
}

public float getTotalBookPrice()
{

	float price=0;
	
	for(Book book:books)
	{
		price+=book.getPrice();
	}
	return price;
}

public String toString() {
	return "Title [titleId=" + titleId + ", titleName=" + titleName
			+ ", publication=" + publication + ", isbn=" + isbn + ", books="
			+ books + "]";
}




}
