package cn.kgc.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import cn.kgc.dao.intf.UserDao;
import cn.kgc.model.User;
import cn.kgc.util.XMLUtils;

public class UserDaoImpl implements UserDao{
	private static List<User> userList = new ArrayList<>();	//�û����ݿ�
	
	/**
	 * ��ʼ��һЩ�˺�
	 */
	static {
		userList = XMLUtils.getUserList();
	}
	/**
	 * �����˺�����ע��
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
