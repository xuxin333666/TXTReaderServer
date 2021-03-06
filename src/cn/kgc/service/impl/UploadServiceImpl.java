package cn.kgc.service.impl;

import cn.kgc.dao.impl.NovelDaoImpl;
import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.NovelUtils;
import cn.kgc.util.Prompt;

public class UploadServiceImpl implements Service,Prompt{
	NovelDao novelDao = new NovelDaoImpl();

	@Override
	public DataTransmission start(DataTransmission data) {
		String command = data.getCommand();
		String type = NovelUtils.getUploadCommandByCommand(command);
		Novel novel = (Novel)data.getObject();
		novel.setType(type);
		String name = novel.getName();
		boolean flag = novelDao.isContains(name, type);
		if(flag) {
			data.setStatus(ERORR);
			return data;
		}
		data.setStatus(SUCCUSS);
		novelDao.uploadNovel(novel,type);
		return data;
	}

}
