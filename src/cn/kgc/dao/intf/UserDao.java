package cn.kgc.dao.intf;

import java.io.IOException;

import org.dom4j.DocumentException;

import cn.kgc.model.User;

public interface UserDao {

	/**
	 * �����˺�����ע��
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	User register(String username, String password) throws DocumentException, IOException;
	/**
	 * ���ݲ��������Ƿ���ڸ��û�
	 * @param username
	 * @param password
	 * @return
	 */
	User queryByPwd(String username,String password);
	/**
	 * �����û��������û�
	 * @param username
	 * @return
	 */
	User queryByName(String username);
}
