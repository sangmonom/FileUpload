package com.mmit.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mmit.model.entity.Users;
import com.mmit.model.service.UserService;
@WebServlet(urlPatterns = {"/users","/user-create"},loadOnStartup=1)
@MultipartConfig
public class UserController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	UserService service;
	@Override
	public void init() throws ServletException {
		
		super.init();
		EntityManagerFactory emf=null;
		Object obj=getServletContext().getAttribute("emf");
		if(obj==null)
		{
			emf=Persistence.createEntityManagerFactory("FileUpload");
			getServletContext().setAttribute("emf",emf );
		}
		else {
			emf=(EntityManagerFactory) obj;
		}
		service=new UserService(emf.createEntityManager());
		
	}
	@Override
	public void destroy() {
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
    	if(emf!=null && emf.isOpen())
    	emf.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> list=service.findAll();
		req.setAttribute("users",list);
		getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get data from req
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		
		Part imgPart=req.getPart("photo");
		String imgfilename=imgPart.getSubmittedFileName();
		
		String rootPath=getServletContext().getRealPath("");
		String dirPath=rootPath+File.separator+"imgUploads";
		File rootDir=new File(dirPath);
		if(!rootDir.exists())
			rootDir.mkdir();
		imgPart.write(rootDir+File.separator+imgfilename);
		System.out.println("path:"+rootPath);
		
		//create entity
		Users u=new Users();
		u.setEmail(email);
		u.setName(name);
		u.setPhone(phone);
		u.setPhoto(imgfilename);
		
		//insert to db
		service.save(u);
		
		//redirect
		resp.sendRedirect(req.getContextPath().concat("/users"));
	}
}
