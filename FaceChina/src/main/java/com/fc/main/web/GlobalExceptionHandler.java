package com.fc.main.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fc.main.vo.JsonResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(RuntimeException e){
		e.printStackTrace();
		return new JsonResult(e);
	}
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e){
		//给运维人员看异常
		e.printStackTrace();
		JsonResult r = new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException){
			r.setMessage("账户不存在");
		}else if(e instanceof LockedAccountException){
			r.setMessage("账户已经被锁定，请联系管理员");
		}else if(e instanceof CredentialsException){
			r.setMessage("密码不正确");
		}else if(e instanceof AuthorizationException){
			r.setMessage("没有权限");
		}else{
			r.setMessage("认证或授权失败");
		}
		return r;
	}
}
