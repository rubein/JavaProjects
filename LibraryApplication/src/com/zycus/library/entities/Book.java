package com.zycus.library.entities;


public class Book 
{
	private int serialId;
	private float price;
	private int edition;
	private String status;
	
	private Title title;
	private Member member;

	public Book(int serialId, Title title) 
	{
		super();
		this.serialId = serialId;
		this.title = title;
		this.status="Available";
	}

	public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}

	public int getEdition() 
	{
		return edition;
	}

	public void setEdition(int edition) 
	{
		this.edition = edition;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public int getSerialId() 
	{
		return serialId;
	}

	public Title getTitle() 
	{
		return title;
	}

	public void changeStatusAvailable()
	{
		if (!(status.equals("Available")))
		{
			status="Available";
		}
	}
	
	public void changeStatusIssued()
	{
		if (!(status.equals("Issued")))
		{
			status="Issued";
		}
	}
	
		
	public Member getMember() 
	{
		return member;
	}

	public void setMember(Member member) 
	{
		this.member = member;
	}
	
	
	
	public String toString() 
	{
		return "Book [serialId=" + serialId + ", price=" + price + ", edition="
				+ edition + ", status=" + status + "]";
	}
}
