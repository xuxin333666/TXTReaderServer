package cn.kgc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.kgc.model.DataTransmission;
import cn.kgc.service.intf.Service;

public class ServiceFactory {
	private static Map<String, String> commandMap = new HashMap<>();	//协议命令容器
	
	
	/**
	 * 第一次执行时，读取协议命令配置文件，将key，value构成hashMap
	 */
	static {
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream("config/service.properties");
			properties.load(input);
			Set<Object> keySet = properties.keySet();
			Iterator<Object> i = keySet.iterator();
			while(i.hasNext()) {
				String command = (String)i.next();
				commandMap.put(command, properties.getProperty(command));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 根据给定的数据，解析出协议命令，再在配置文件中获取相应的service实现类，实例化对象返回
	 * @param data
	 * @return
	 */
	public static Service Parse(DataTransmission data) {
		String command = data.getCommand();
		String serviceStr = commandMap.get(command);
		Service service = null;
		try {
			Class<?> clazz = Class.forName(serviceStr);
			service = (Service)clazz.newInstance();
			return service;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
