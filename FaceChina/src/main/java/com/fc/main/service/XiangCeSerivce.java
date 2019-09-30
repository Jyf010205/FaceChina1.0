package com.fc.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface XiangCeSerivce {
	int insertImage(MultipartFile[] pictureFile) throws Exception;
	int insertImage(MultipartFile pictureFile) throws Exception;
	List<String> findSrc();
}
