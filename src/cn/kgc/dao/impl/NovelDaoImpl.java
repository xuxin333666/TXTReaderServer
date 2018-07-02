package cn.kgc.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.kgc.dao.intf.NovelDao;
import cn.kgc.model.Novel;

public class NovelDaoImpl implements NovelDao{
	private static Map<String, List<Novel>> novelMap = new HashMap<>();
	
	static {
		
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
