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
	 * ����С˵���Ͳ���ȫ��С˵�б�
	 * @param type
	 * @return �����б�
	 */
	@Override
	public List<Novel> getAllByType(String type) {
		return novelMap.get(type);
	}

}
