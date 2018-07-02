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

}
