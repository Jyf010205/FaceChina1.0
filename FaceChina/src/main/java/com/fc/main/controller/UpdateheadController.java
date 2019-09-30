package com.fc.main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fc.main.dao.XiangCeDao;
import com.fc.main.entity.Image;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.vo.JsonResult;
import com.google.gson.Gson;


@WebServlet("/UpdateheadController")
@MultipartConfig	
public class UpdateheadController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-configs.xml");
		XiangCeDao xiangCeDao = ctx.getBean(XiangCeDao.class);
		System.out.println("---这里是上传图片的servlet----");
		String picflag = request.getParameter("picture");
		System.out.println(request);
		String picPath = null;
		if("uploadpic".equals(picflag)){
			System.out.println("----上传----");
			Part part = request.getPart("pic");//前台的文件标签的name,若ajax直接提交表单，这里无法获取
			String file = part.getHeader("Content-Disposition");
			//获取文件名
			String fileName = file.substring(file.lastIndexOf("=")+2, file.length()-1);
			fileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("\\")+1);
			System.out.println(fileName);
			//获取项目的部署路劲
			String basePath = getServletContext().getRealPath("/");
			System.out.println(basePath);
			picPath = basePath+fileName;
			picPath = "D:/CGB1811WORKSP/FaceChina/src/main/webapp/assets/images/inserts/"+fileName;
			System.out.println(picPath);
			//上传文件到部署路劲
			try {
				writeTo(picPath, part);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			part.write(basePath+fileName);
			//将路径存在session中方便下面显示是用
			request.getSession().setAttribute("PIC", picPath);
			//以下代码是使用了	AJax异步请求时使用的
			xiangCeDao.insert(new Image(fileName, "assets/images/inserts/"+fileName));
			int pictureid = xiangCeDao.findpictureidBypicturename(fileName);
			
			ZhuCeUser  zhuCeUser = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
			int user_picture_userid = zhuCeUser.getUser_id();
			xiangCeDao.insertSrc(user_picture_userid, pictureid);
			xiangCeDao.updatehead(pictureid, zhuCeUser.getUser_id());
			Gson gson = new Gson();//创建gson对象
			response.setContentType("text/json;charset=utf-8");//设置响应的方式为json
			response.getWriter().print(gson.toJson(pictureid));
//			response.getWriter().write("<script>window.location.href='MyOffice/addPic.jsp';</script>");
		}else if("showpic".equals(picflag)){
			System.out.println("这里是上传图片里面显示图片的servlet");
			//从前台获取图片的路劲（部署项目的根路径）此路劲必须包含到图片，
			//如D:\My\SOFTWORE\apache-tomcat-7.0.52\wtpwebapps\imas\111.gif
//			String picPath = request.getParameter("picpath");
			Object obj = request.getSession().getAttribute("PIC");
			String picpath = null;
			if(obj != null && obj instanceof String){
				picpath = (String) obj;
			}
			System.out.println(picpath);
			//以该路劲创建一个新文件，只需要找到图片的路劲就可以
			File file = new File(picpath);
			response.setCharacterEncoding("gb2312");
			response.setContentType("doc");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("gb2312"),"iso8859-1"));
 
			System.out.println(new String(file.getName().getBytes("gb2312"),"gb2312"));
 
			OutputStream output = null;
			FileInputStream fis = null;
			try{
				output = response.getOutputStream();
				fis = new FileInputStream(file);
		
				byte[] b = new byte[1024];
				int i = 0;
		
				while((i = fis.read(b))!=-1){
					output.write(b, 0, i);
				}
				output.write(b, 0, b.length);
		
				output.flush();
				response.flushBuffer();
			}
			catch(Exception e){
				System.out.println("Error!");
				e.printStackTrace();
			}
			finally{
				if(fis != null){
					fis.close();
					fis = null;
				}if(output != null){
					output.close();
					output = null;
				}
			}
 
		}
		
		
	}

	private void writeTo(String picPath, Part part) throws Exception {
		InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream(picPath);
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
	}
 
}