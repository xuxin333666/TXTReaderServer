package cn.kgc.service.impl;

import java.util.List;

import cn.kgc.dao.impl.NovelDaoImpl;
import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class WuxiaServiceImpl implements Service,Prompt{
	NovelDao novelDao = new NovelDaoImpl();

	@Override
	public DataTransmission start(DataTransmission data) {
		List<Novel> novelLiset = novelDao.getAllByType(WUXIA_TYPE);
		if(novelLiset.size() != 0) {
			data.setObject(novelLiset);
			data.setStatus(SUCCUSS);
		}
		data.setStatus(ERORR);
		return data;
	}
}
