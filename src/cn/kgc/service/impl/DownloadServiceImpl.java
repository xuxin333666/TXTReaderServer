package cn.kgc.service.impl;

import java.io.IOException;

import cn.kgc.dao.impl.NovelDaoImpl;
import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class DownloadServiceImpl implements Service,Prompt {
	NovelDao novelDao = new NovelDaoImpl();
	
	@Override
	public DataTransmission start(DataTransmission data) {
		Novel novel = (Novel)data.getObject();
		String content;
		try {
			content = novelDao.getNovelContent(novel.getFileName(), novel.getType(),true);
			data.setResult(content);
			data.setStatus(SUCCUSS);
		} catch (IOException e) {
			data.setStatus(ERORR);
		}
		return data;
	}

}
