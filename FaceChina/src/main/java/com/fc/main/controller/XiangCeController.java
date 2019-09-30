package com.fc.main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fc.main.dao.XiangCeDao;
import com.fc.main.entity.Image;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.XiangCeSerivce;
import com.fc.main.vo.JsonResult;
@Controller
public class XiangCeController {
	@Autowired 
	XiangCeSerivce xiangCeSerivce;
	@Autowired
	XiangCeDao xiangCeDao;
	
	@RequestMapping("doFindSrc")
	@ResponseBody
	public JsonResult doFindSrc() {
		List<String> list = xiangCeSerivce.findSrc();
		return new JsonResult(list);
	}
	
	//头像
	@RequestMapping("finduserpictureurl")
	@ResponseBody
	public JsonResult finduserpictureurl() {
		ZhuCeUser zhuCeUser = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		int user_id = zhuCeUser.getUser_id();
		String picturesrc = xiangCeDao.finduserprctureurl(user_id);
		return new JsonResult(picturesrc);
	}
	
	
	
	@RequestMapping("upload")
	@ResponseBody
	//http://localhost/FaceChina/index.fc#
	protected String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取图片存储路径
		String folderPath = "D:/CGB1811WORKSP/FaceChina/src/main/webapp/assets/images/inserts";
		//判断文件是否存在
		File foder = new File(folderPath);
		if (!foder.exists()) {
			foder.mkdirs();
		}
		//使用文件上传组件
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		
		try {
			//解析请求信息
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item: list) {
				//处理上传文件保存的名称
				
				System.out.println(item.toString());
				String imgName = item.getName();
				imgName = UUID.randomUUID()+imgName.substring(imgName.lastIndexOf("\\")+1);
				
				/*String imgName = UUID.randomUUID()+".jpg";*/
				//输入和输出流
				InputStream is = item.getInputStream();
				FileOutputStream fos = new FileOutputStream(new File(folderPath+"/"+imgName));
				//写入数据
				byte[] buffer = new byte[1024];
				int len=0;
				while ((len=(is.read(buffer)))>-1) {
					fos.write(buffer, 0, len);
				}
				xiangCeDao.insert(new Image(imgName, "assets/images/inserts/"+imgName));
				//关闭输入输出流
				fos.close();
				is.close();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return "首页";
	}
	
	
}