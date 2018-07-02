package cn.kgc.service.impl;

import java.util.List;

import cn.kgc.dao.impl.NovelDaoImpl;
import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.DataTransmission;
import cn.kgc.model.Novel;
import cn.kgc.service.intf.Service;
import cn.kgc.util.Prompt;

public class NovelServiceImpl implements Service,Prompt{
	NovelDao novelDao = new NovelDaoImpl();

	@Override
	public DataTransmission start(DataTransmission data) {
		List<Novel> novelLiset = novelDao.getAllByType(data.getCommand());
		System.out.println(novelLiset);
		if(novelLiset != null) {
			data.setObject(novelLiset);
			data.setStatus(SUCCUSS);
		} else {
			data.setStatus(ERORR);			
		}
		return data;
	}
}
