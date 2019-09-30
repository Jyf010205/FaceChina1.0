package com.fc.main.service.realm;

import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.main.dao.ZhuCeDao;
import com.fc.main.entity.ZhuCeUser;
@Service
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private ZhuCeDao zhuCeDao;
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
				//构建凭证匹配对象
				HashedCredentialsMatcher cMatcher=
				new HashedCredentialsMatcher();
				//设置加密算法
				cMatcher.setHashAlgorithmName("MD5");
				//设置加密次数
				cMatcher.setHashIterations(1);
				super.setCredentialsMatcher(cMatcher);
	}
	
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		//1.获取用户名(用户页面输入)
				UsernamePasswordToken upToken=
				(UsernamePasswordToken)token;
				String userEmail = upToken.getUsername();
				System.out.println("userEmail="+userEmail);
				//2.基于邮箱查询用户信息
				ZhuCeUser user = zhuCeDao.findUserByUserEmail(userEmail);
				//3.判定用户是否存在
				if(user==null)
				throw new UnknownAccountException();
				//4.封装用户信息
				ByteSource credentialsSalt=
				ByteSource.Util.bytes(user.getUser_salt());
				//记住：构建什么对象要看方法的返回值
				SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
						user,//principal (身份)
						user.getUser_password(),//hashedCredentials(已加密的密码)
						credentialsSalt, //credentialsSalt（凭证盐值）
						this.getName());//realm的名字 父类（AuthorizingRealm）的方法
				//6.返回封装结果
				return info;//返回值会传递给认证管理器(后续
				//认证管理器会通过此信息完成认证操作)
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}
}
