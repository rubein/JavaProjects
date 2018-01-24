package com.zycus.library.aggregates;

import java.util.ArrayList;

import com.zycus.library.entities.Book;
import com.zycus.library.entities.Title;

public class TitleList 
{
		private static TitleList titles;
		private ArrayList<Title> titleList;
		
		private TitleList() 
		{
			titleList=new ArrayList<Title>();
		}
		
		
		public static TitleList getInstance(){
			if(titles==null){
				titles=new TitleList();
			}return titles;
		}
		
		public void addNewTitle(Title title)
		{
			System.out.println(title);
			titleList.add(title);
		}
		
		public Title searchTitleByName(String titleName)
		{	
			for(Title title: titleList)
			{
				if(title.getTitleName()==titleName)
				{
					return title;
				}
			}return null;
		}
		
		public int getTotalBookCount()
		{
			int count=0;
			
			for(Title title:titleList)
			{
				count+=title.countBooks();
			}
			return count;
		}
		
		public int getTotalBookPrice()
		{
			int price=0;
			
			for(Title title:titleList)
			{
				price+=title.getTotalBookPrice();
			}
			return price;
		}
		
		public boolean isBookAvailable(String titleName)
		{
			for(Title title: titleList)
				if(title.getTitleName()==titleName)
				{
					Book book=title.getAvailableBook();
					if(book==null)
					return false;
					else
					return true;
				}
				return false;
		}
	}


