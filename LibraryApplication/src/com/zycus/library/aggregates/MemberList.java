package com.zycus.library.aggregates;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import com.zycus.library.daos.MemberDao;
import com.zycus.library.exceptions.DuplicateMemberException;
import com.zycus.library.entities.*;

public class MemberList {
	
	
	private static MemberList members;
	private ArrayList<Member> memberList;
	
	private MemberList() throws IOException {
		MemberDao dao=null;
		try{
		dao=MemberDao.getInstance();
		memberList=dao.getAllMembers();
	}finally{
		dao.close();
	}
	}
	public static MemberList getInstance() throws IOException{
		if(members==null)
			members=new MemberList();
		return members;
	}
	
	public void addNewMember(Member member) throws DuplicateMemberException
	{
		System.out.println("in memAddNewMember()"+member);
		if(searchMember(member.getMemberId())!=null){
		throw new DuplicateMemberException("this member already exist. Addition denied.");
		}
		else{ 
			memberList.add(member);}
	}
	
	public void submitMembers() throws IOException{
		MemberDao dao=null;
		try{
			dao=MemberDao.getInstance();
			dao.persistAllMembers(memberList);
		}finally{
		dao.close();	
		}
	}
	
	public void unsubscribe(Member mem)
	{
		Member mem2=searchMember(mem.getMemberId());
		memberList.remove(mem2);
	}
	
	public Member searchMember(int memberId)
	{	
		for(Member member : memberList)
		{
			if(memberId==member.getMemberId())
			{
				return member;
			}
		
		}return null;
	}
}
