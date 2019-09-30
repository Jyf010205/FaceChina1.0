package com.fc.main.service;

import com.fc.main.entity.ZhuCeUser;

public interface ZhaoHuiPwdService {

	int updatePassword(ZhuCeUser zhuCeUser,String newPwd,String SecondPwd);
}
