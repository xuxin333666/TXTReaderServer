package cn.kgc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.kgc.dao.intf.UserDao;
import cn.kgc.model.User;

public class UserDaoImpl implements UserDao{
	private static List<User> userList = new ArrayList<>();	//�û����ݿ�
	
	/**
	 * ��ʼ��һЩ�˺�
	 */
	static {
		userList.add(new User("xuxin","123456"));
	}
	/**
	 * �����˺�����ע��
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User register(String username, String password) {
		User user = new User(username,password);
		userList.add(user);
		return user;
	}
	/**
	 * ���ݲ��������Ƿ���ڸ��û�
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
	 * �����û��������û�
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
