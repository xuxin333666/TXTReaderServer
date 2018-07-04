package cn.kgc.dao.impl;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;

import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.Novel;
import cn.kgc.util.NovelUtils;
import cn.kgc.util.XMLUtils;

public class NovelDaoImpl implements NovelDao{
	private static Map<String, List<Novel>> novelMap = new HashMap<>();
	
	static {
		novelMap = XMLUtils.getMap();
	}
	/**
	 * ����С˵���Ͳ���ȫ��С˵�б�
	 * @param type
	 * @return �����б�
	 */
	@Override
	public List<Novel> getAllByType(String type) {
		return novelMap.get(type);
	}
	
	/**
	 * ���ݸ��������ֲ���ͬ�������Ƿ���ͬ����
	 * @param name
	 * @param type
	 * @return
	 */
	public boolean isContains(String name,String type) {
		List<Novel> list = getAllByType(type);
		Novel novel = new Novel();
		novel.setName(name);	
		return list.contains(novel);
	}
	/**
	 * �ϴ�С˵��dao����С˵����д��XML�ļ�
	 * @param novel
	 * @param type
	 */
	@Override
	public void uploadNovel(Novel novel, String type) {
		List<Novel> list = getAllByType(type);
		list.add(novel);
		try {
			XMLUtils.upload(novel,type);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �����ļ���ַ��ȡС˵����
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	@Override
	public String getNovelContent(String fileName,String type,boolean flag) throws IOException {
		return NovelUtils.getNovelContent(fileName,type,flag);
	}

}
