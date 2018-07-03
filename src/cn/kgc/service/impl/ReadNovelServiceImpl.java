package cn.kgc.service.impl;

import java.io.IOException;

import cn.kgc.dao.impl.NovelDaoImpl;
import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class ReadNovelServiceImpl implements Service,Prompt {
	NovelDao novelDao = new NovelDaoImpl();

	@Override
	public DataTransmission start(DataTransmission data) {
		Novel novel = (Novel)data.getObject();
		String fileName = novel.getFileName();
		try {
			String content = novelDao.getNovelContent(fileName);
			data.setStatus(SUCCUSS);
			data.setResult(content);
		} catch (IOException e) {
			data.setStatus(ERORR);
		}
		return data;
	}

}
