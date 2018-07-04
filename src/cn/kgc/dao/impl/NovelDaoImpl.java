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
	 * 根据小说类型查找全部小说列表
	 * @param type
	 * @return 返回列表
	 */
	@Override
	public List<Novel> getAllByType(String type) {
		return novelMap.get(type);
	}
	
	/**
	 * 根据给定的名字查找同类型中是否有同名的
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
	 * 上传小说，dao保存小说，并写入XML文件
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
	 * 根据文件地址获取小说内容
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	@Override
	public String getNovelContent(String fileName,String type,boolean flag) throws IOException {
		return NovelUtils.getNovelContent(fileName,type,flag);
	}

}
