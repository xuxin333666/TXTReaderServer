package cn.kgc.dao.intf;

import java.io.IOException;
import java.util.List;

import cn.kgc.model.Novel;

public interface NovelDao {
	/**
	 * 根据小说类型查找全部小说列表
	 * @param type
	 * @return 返回列表字符串
	 */
	List<Novel> getAllByType(String type); 
	/**
	 * 根据给定的名字查找同类型中是否有同名的
	 * @param name
	 * @param type
	 * @return
	 */
	boolean isContains(String name,String type);
	/**
	 * 上传小说，dao保存小说，并写入XML文件
	 * @param novel
	 * @param type
	 */
	void uploadNovel(Novel novel, String type);
	/**
	 * 根据文件地址获取小说内容
	 * @param fileName
	 * @return
	 * @throws IOException 
	 */
	String getNovelContent(String fileName) throws IOException;
}
