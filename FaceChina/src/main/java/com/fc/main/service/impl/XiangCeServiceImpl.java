package com.fc.main.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fc.main.dao.XiangCeDao;
import com.fc.main.entity.Image;
import com.fc.main.entity.ZhuCeUser;
import com.fc.main.service.XiangCeSerivce;

@Service
public class XiangCeServiceImpl implements XiangCeSerivce {
	@Autowired
	XiangCeDao XiangCeDao;
	@Override
	public int insertImage(MultipartFile[] pictureFile) throws Exception {
		String FILEPATH="D:/CGB1811WORKSP/FaceChina/src/main/webapp/assets/images/inserts";
		String originalFilename="";
		String newFileName="";
		int rows = 0;
		//传多个文件
		for (int i = 0; i<pictureFile.length; i++) {
			if (pictureFile!=null&&pictureFile[i].getOriginalFilename()!=null&&pictureFile[i].getOriginalFilename().length()>0) {
				//获取图片的原名
				originalFilename = pictureFile[i].getOriginalFilename();
				//获取图片的原图
				newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				//新文件
				File name = new File(FILEPATH + newFileName);
				//将内存中的文件写入磁盘
				pictureFile[i].transferTo(name);
			}
			rows = XiangCeDao.insert(new Image(newFileName, "assets/images/inserts/" + newFileName));
		}
		return rows;
	}
	@Override
	public int insertImage(MultipartFile pictureFile) throws Exception {
		String FILEPATH="D:/CGB1811WORKSP/FaceChina/src/main/webapp/assets/images/inserts";
		String originalFilename="";
		String newFileName="";
		if (pictureFile!=null&&pictureFile.getOriginalFilename()!=null&&pictureFile.getOriginalFilename().length()>0) {
			//获取图片的原名
			originalFilename = pictureFile.getOriginalFilename();
			//获取图片的原图
			newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新文件
			File name = new File(FILEPATH + newFileName);
			//将内存中的文件写入磁盘
			pictureFile.transferTo(name);
		}
		int rows = XiangCeDao.insert(new Image(newFileName, "assets/images/inserts/" + newFileName));
		return rows;
	}
	
	@Override
	public List<String> findSrc() {
		ZhuCeUser user  = (ZhuCeUser) SecurityUtils.getSubject().getPrincipal();
		int user_id = user.getUser_id();
		System.out.println(user_id);
		List<String> list = XiangCeDao.findSrc(user_id);
		return list;
	}
}




