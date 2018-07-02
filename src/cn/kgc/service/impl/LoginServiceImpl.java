package cn.kgc.service.impl;

import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.dao.intf.UserDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.User;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class LoginServiceImpl implements Service,Prompt {
	private UserDao userDao = new UserDaoImpl();	//�û����ݴ���
	
	
	/**
	 * ������½���ܣ���װDataTransmission
	 */
	@Override
	public DataTransmission start(DataTransmission data) {
		String[] strArr = (String[])data.getObject();	
		try {
			User user = login(strArr[USERNAME_INDEX],strArr[PASSWORD_INDEX]);
			data.setObject(user);
			data.setStatus(SECONDARY_MENU);
		} catch (Exception e) {
			data.setResult(e.getMessage());
			data.setStatus(ERORR);
		}
		return data;
	}
	
	/**
	 * ��½������Dao
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User login(String username, String password) throws Exception {
		User user = userDao.queryByPwd(username, password);
		if(user == null) {
			throw new Exception(USER_NOT_EXIST);
		}
		return user;
	}
}
