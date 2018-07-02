package cn.kgc.dao.intf;

import cn.kgc.model.User;

public interface UserDao {

	/**
	 * �����˺�����ע��
	 * @param username
	 * @param password
	 * @return
	 */
	User register(String username, String password);
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
