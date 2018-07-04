package cn.kgc.dao.intf;

import java.io.IOException;
import java.util.List;

import cn.kgc.model.Novel;

public interface NovelDao {
	/**
	 * ����С˵���Ͳ���ȫ��С˵�б�
	 * @param type
	 * @return �����б��ַ���
	 */
	List<Novel> getAllByType(String type); 
	/**
	 * ���ݸ��������ֲ���ͬ�������Ƿ���ͬ����
	 * @param name
	 * @param type
	 * @return
	 */
	boolean isContains(String name,String type);
	/**
	 * �ϴ�С˵��dao����С˵����д��XML�ļ�
	 * @param novel
	 * @param type
	 */
	void uploadNovel(Novel novel, String type);
	/**
	 * �����ļ���ַ��ȡС˵����
	 * @param fileName
	 * @param type 
	 * @return
	 * @throws IOException 
	 */
	String getNovelContent(String fileName, String type) throws IOException;
}
