package cn.kgc.dao.intf;

import java.io.IOException;

import org.dom4j.DocumentException;

import cn.kgc.model.User;

public interface UserDao {

	/**
	 * 根据账号密码注册
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	User register(String username, String password) throws DocumentException, IOException;
	/**
	 * 根据参数查找是否存在该用户
	 * @param username
	 * @param password
	 * @return
	 */
	User queryByPwd(String username,String password);
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User queryByName(String username);
}
