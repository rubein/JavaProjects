package collections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GenericEntityList<T> {

	private ArrayList<T> entities;
	
	public GenericEntityList(){
		entities=new ArrayList<T>();
	}
	
	
	
	public void addNewEntity(T object){
		entities.add(object);
	}
	
	public T getEntity(int entityId){
		for(T object:entities){
			if(entityId==object.hashCode()){
				return object;
			}
		}return null;
	}
	
	public void showAllEntities(){
		for(T object:entities)
			System.out.println(object);
	}
//		
//	public void showType(){
//		if(entities instanceOf Serializable){
//			System.out.println("Instance of serializable created");
//		}
//	}
	
	public void store(String filePath,String fileName){
		File file=new File(filePath+File.separator+fileName);
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;//serialization use
		try{
		fos=new FileOutputStream(file);//for interacting with disk
		oos=new ObjectOutputStream(fos);//for serialization
		oos.writeObject(entities);
		}catch(FileNotFoundException e){
		e.printStackTrace();
		}catch(IOException e){
		e.printStackTrace();
		} finally{
			try{
				if(oos!=null){
					oos.close();
					oos=null;
					fos=null;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public void load(String filePath,String fileName) {
		File file=new File(filePath+File.separator+fileName);
		FileInputStream fos=null;
		ObjectInputStream oos=null;//serialization use
		try{
		fos=new FileInputStream(file);//for interacting with disk
		oos=new ObjectInputStream(fos);//for serialization
		entities=(ArrayList<T>)oos.readObject();//write complete graph
		//oos.writeObject(entities);
		}catch(FileNotFoundException e){
		e.printStackTrace();
		}catch(IOException e){
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(oos!=null){
					oos.close();
					oos=null;
					fos=null;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		GenericEntityList<Member> memberList=new GenericEntityList<Member>();
		
		Member member1=new Member(100,"aaaa");
		Member member2=new Member(101,"bbbb");
		
		memberList.addNewEntity(member1);
		memberList.addNewEntity(member2);
		
		memberList.showAllEntities();
		
		String filePath="D:\\Rubein\\LibraryApplication\\src\\collections\\data";
		String fileName="Members.ser";
		memberList.store(filePath, fileName);
		//memberList.showType();
		memberList.load(filePath, fileName);
		memberList.showAllEntities();
		
		/*GenericEntityList<Integer> intList=new GenericEntityList<Integer>();
		
		intList.addNewEntity(15);
		intList.addNewEntity(20);
		
		intList.showAllEntities();*/
		
	}
}
