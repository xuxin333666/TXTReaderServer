package cn.kgc.dao.intf;

import java.util.List;

import cn.kgc.model.Novel;

public interface NovelDao {
	/**
	 * ����С˵���Ͳ���ȫ��С˵�б�
	 * @param type
	 * @return �����б��ַ���
	 */
	List<Novel> getAllByType(String type); 
}
