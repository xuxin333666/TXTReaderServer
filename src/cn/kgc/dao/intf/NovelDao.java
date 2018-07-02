package cn.kgc.dao.intf;

import java.util.List;

import cn.kgc.model.Novel;

public interface NovelDao {
	/**
	 * 根据小说类型查找全部小说列表
	 * @param type
	 * @return 返回列表字符串
	 */
	List<Novel> getAllByType(String type); 
}
