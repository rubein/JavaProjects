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
import com.zycus.library.entities.Title;

public class TitleDao {
	private static TitleDao titleDao;
	private BufferedReader br;
	
	private TitleDao() throws FileNotFoundException{
		String filePath="D:\\Rubein\\LibraryApplication\\data";
		String fileName="Title.txt";
		
		File inputFile=new File(filePath+File.separator+fileName);
		
		if(!inputFile.isFile())
			throw new FileNotFoundException("Title.txt is missing.");
		//file exists
			FileReader fis=new FileReader(inputFile);
		br=new BufferedReader(fis);
	}
	
	public static TitleDao getInstance() throws IOException{
		if (titleDao==null){
			titleDao=new TitleDao();
		}
		return titleDao;
	}
	
	public void persistAllMembers(ArrayList<Title> titles) throws IOException{
		String filePath="D:\\Rubein\\LibraryApplication\\data";
		String fileName="Title.txt";
		
		File outputFile=new File(filePath+File.separator+fileName);
		FileWriter fileWriter=null;
		try{
		fileWriter=new FileWriter(outputFile);
		
		for(int index=0;index<titles.size()-1;index++){
			String strTitle=convertTitleToString(titles.get(index))+"\n";
			fileWriter.write(strTitle);
		}
		String strTitle=convertTitleToString(titles.get(titles.size()-1));
		fileWriter.write(strTitle);
	}finally{
		fileWriter.close();
	}
	}
	
	private String convertTitleToString(Title title) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Title> getAllTitles() throws IOException{
		ArrayList<Title> titles=new ArrayList<Title>();
		String record=br.readLine();
		while(record!=null){
			titles.add(convertStringToTitle(record));
			record=br.readLine();
		}
		return titles;
	}
	
	private Title convertStringToTitle(String record){
		StringTokenizer tokens=new StringTokenizer(record,",");
		int titleId=Integer.parseInt(tokens.nextToken());
		String titleName=tokens.nextToken();
		String publication = tokens.nextToken();
		return new Title(titleId,titleName,publication);
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
