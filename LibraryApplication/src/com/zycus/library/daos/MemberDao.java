package com.zycus.library.daos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.zycus.library.entities.Member;

public class MemberDao {
	private static MemberDao memberDao;
	private BufferedReader br;
	
	private MemberDao() throws FileNotFoundException{
		String filePath="D:\\Rubein\\LibraryApplication\\data";
		String fileName="Member.txt";
		
		File inputFile=new File(filePath+File.separator+fileName);
		
		if(!inputFile.isFile())
			throw new FileNotFoundException("Member.txt is missing.");
		//file exists
			FileReader fis=new FileReader(inputFile);
		br=new BufferedReader(fis);
	}
	
	public static MemberDao getInstance() throws IOException{
		if (memberDao==null){
			memberDao=new MemberDao();
		}
		return memberDao;
	}
	
	public void persistAllMembers(ArrayList<Member> members) throws IOException{
		String filePath="D:\\Rubein\\LibraryApplication\\data";
		String fileName="Member.txt";
		
		File outputFile=new File(filePath+File.separator+fileName);
		FileWriter fileWriter=null;
		try{
		fileWriter=new FileWriter(outputFile);
		
		for(int index=0;index<members.size()-1;index++){
			String strMember=convertMemberToString(members.get(index))+"\n";
			fileWriter.write(strMember);
		}
		String strMember=convertMemberToString(members.get(members.size()-1));
		fileWriter.write(strMember);
	}finally{
		fileWriter.close();
	}
	}
	
	public ArrayList<Member> getAllMembers() throws IOException{
		ArrayList<Member> members=new ArrayList<Member>();
		String record=br.readLine();
		while(record!=null){
			members.add(convertStringToMember(record));
			record=br.readLine();
		}
		return members;
	}
	
	private Member convertStringToMember(String record){
		StringTokenizer tokens=new StringTokenizer(record,",");
		int memberId=Integer.parseInt(tokens.nextToken());
		String memberNm=tokens.nextToken();
		return new Member(memberId,memberNm);
	}

	private String convertMemberToString(Member member){
		return member.getMemberId()+","+member.getMemberNm();
		
	}

	public void close() throws IOException{
		if(br!=null){
			br.close();
			br=null;
		}
	}
	
	@Override
	protected void finalize()throws Throwable{
		close();
	}
	
	public static void main(String[] args) {
		MemberDao dao=null;
		try {
			dao=MemberDao.getInstance();
			ArrayList<Member>members=dao.getAllMembers();
			for(Member member:members)
				System.out.println(member);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				dao.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
 