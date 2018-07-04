package cn.kgc.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import cn.kgc.dao.intf.UserDao;
import cn.kgc.model.User;
import cn.kgc.util.XMLUtils;

public class UserDaoImpl implements UserDao{
	private static List<User> userList = new ArrayList<>();	//用户数据库
	
	/**
	 * 初始化一些账号
	 */
	static {
		userList = XMLUtils.getUserList();
	}
	/**
	 * 根据账号密码注册
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	@Override
	public User register(String username, String password) throws DocumentException, IOException {
		User user = new User(username,password);
		userList.add(user);
		XMLUtils.addUserInXML(user);
		return user;
	}
	/**
	 * 根据参数查找是否存在该用户
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User queryByPwd(String username, String password) {
		User newUser = new User(username,password);
		for (User user : userList) {
			if(newUser.equals(user)) {
				return user;
			}
		}
		return null;
	}
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	@Override
	public User queryByName(String username) {
		for (User user : userList) {
			if(username.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}
}
