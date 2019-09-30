package com.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fc.main.dao.GeRenDongTaiDao;
import com.fc.main.service.impl.GeRenDongTaiServiceImpl;
import com.fc.main.vo.GeRenPingLunVO;
import com.fc.main.vo.GeRenShuoVO;
import com.fc.main.vo.PageObject;

public class TestGeRenDongTaiImpl extends TestBase{
	
	@Test
	public void testFindData(){

		GeRenDongTaiServiceImpl impl = ctx
				.getBean("geRenDongTaiServiceImpl",GeRenDongTaiServiceImpl.class);
		
		//测试获取呈现到个人动态的文字内容、更新时间和图片数据
	//	PageObject<GeRenShuoVO> po = impl.findGeRenShuo(22);
	//	System.out.println(po.getRecodes()+","+po.getRowCount());
		
		//测试获取呈现到个人动态的每个说说当中的评论者id、评论文字内容、评论更新时间
		PageObject<GeRenPingLunVO> po = impl.findGeRenPingLun(7);
		System.out.println(po.getRecodes()+","+po.getRowCount());
		
		
		/*
		//测试个人动态左上角个人所有的说说总篇数
		System.out.print("请输入个人动态用户id：");
		int shuoCount = dao.getShuoCount(new Scanner(System.in).nextInt());
		System.out.println(shuoCount);
		
		GeRenDongTaiServiceImpl bean = ctx.getBean("geRenDongTaiServiceImpl",GeRenDongTaiServiceImpl.class);
		PageObject<GeRenShuoVO> po = bean.findGeRenShuo(1, 1);
		System.out.println(po.getRowCount());
		System.out.println(po.getRecodes());
		*/
	}
	
	@Test
	public void testDeleteData(){
		GeRenDongTaiDao dao = ctx
				.getBean("geRenDongTaiDao",GeRenDongTaiDao.class);
		//测试个人动态删除
		//2号用户张三发表了4号说说(user_shuo、shuo)，
		//4号说说由1号用户发表了5号评论，由3号用户发表了6号评论(shuo_ping、ping),
		//4号说说对应4号图片(shuo_picture、picture)
		System.out.print("请输入个人动态中要删除的说说的说说Id：");
		int shuoId=new Scanner(System.in).nextInt();
		dao.deleteUserShuoByShuoId(shuoId);
		dao.deleteShuoByShuoId(shuoId);
		List<Integer> pingIds = dao.findPingIdsByShuoId(shuoId);
		dao.deleteShuoPingByShuoId(shuoId);
		dao.deletePingByPingIds(pingIds);
		int picture_id = dao.findPictureIdByShuoId(shuoId);
		dao.deleteShuoPictureByShuoId(shuoId);
		dao.deletePictureByPictureId(picture_id);
	}
	
}
