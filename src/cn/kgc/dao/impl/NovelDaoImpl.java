package cn.kgc.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.Novel;
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

}
