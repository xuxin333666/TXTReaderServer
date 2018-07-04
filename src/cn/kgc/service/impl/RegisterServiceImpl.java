package cn.kgc.service.impl;

import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.dao.intf.UserDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.User;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class RegisterServiceImpl implements Service,Prompt {
	private UserDao userDao = new UserDaoImpl();	//用户数据处理
	
	@Override
	public DataTransmission start(DataTransmission data) {
		String[] strArr = (String[])data.getObject();	
		try {
			User user = register(strArr[USERNAME_INDEX],strArr[PASSWORD_INDEX]);
			data.setObject(user);
			data.setStatus(SUCCUSS);
		} catch (Exception e) {
			data.setResult(e.getMessage());
			data.setStatus(ERORR);
		}
		return data;
	}
	
	private User register(String username, String password) throws Exception {
		User user = userDao.queryByName(username);
		if(!(user == null)) {
			throw new Exception(USER_EXIST);
		}
		user = userDao.register(username,password);
		return user;
	}

}
