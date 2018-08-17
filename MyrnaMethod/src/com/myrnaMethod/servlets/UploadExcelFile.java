package com.myrnaMethod.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.myrnaMethod.Mail.MailShooter;
import com.myrnaMethod.constants.Constants;

/**
 * Servlet implementation class UploadExcelFile
 */
@WebServlet("/uploadExcelFile")
@MultipartConfig
public class UploadExcelFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String savePath = Constants.filePath;
	public static String filename = "";
	MailShooter mail = new MailShooter();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadExcelFile() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void init() throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("yaha aaya");
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("yaha aayaaaaaaa");
		processRequest(request, response);
	}

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			boolean ismultipart = ServletFileUpload.isMultipartContent(request);
			
			if(!ismultipart){
				
			}else{
				FileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				List items = null;
				try{
						items = upload.parseRequest(request);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				Iterator itr = items.iterator();
				while (itr.hasNext()){
					FileItem item = (FileItem) itr.next();
					
					if(item.isFormField()){
						
					}else{
						String itemname = item.getName();
						if((itemname == null)|| itemname.equals(""))
							continue;
						
						filename = FilenameUtils.getName(itemname);
						File f = checkExist(filename);
						item.write(f);
					}
				}
			}
			request.setAttribute("message", "success");
		}catch(Exception e){
			request.setAttribute("message", "Failed");
			mail.sendMail(e.getMessage(), e);
		}
	}
	
	
	private File checkExist(String filename) {
		File f = new File(savePath+"/"+filename);
		if(f.exists()){
			StringBuffer sb = new StringBuffer(filename);
			sb.insert(sb.lastIndexOf("."), "-"+new Date().getTime());
			f = new File(savePath+"/"+sb.toString());
		}
		return f;
	}
}