package cn.kgc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import cn.kgc.model.Novel;

public class NovelUtils {
	public static Map<String, String> commandMap = new HashMap<>();	//协议命令容器
	/**
	 * 初始化界面工具类，读取菜单列表,协议命令列表
	 */
	static {
		Properties p1 = new Properties();
		try {
			Reader fr = new FileReader("config/upload.properties");
			p1.load(fr);
			Set<Object> keySet = p1.keySet();
			Iterator<Object> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String command = (String)iterator.next();
				commandMap.put(command, p1.getProperty(command));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static String getUploadCommandByCommand(String string) {	
		return commandMap.get(string);
	}

	
	public static void writeFile(Novel novel) throws IOException {
		Writer writer = new FileWriter("novel/" + novel.getType() + "/" + novel.getName() + ".txt");
		writer.write(novel.getContent());
		writer.close();
	}
	
	/**
	 * 根据文件地址获取小说内容
	 * @param fileName
	 * @param type 
	 * @return
	 * @throws IOException 
	 */
	public static String getNovelContent(String fileName, String type, boolean flag,int index) throws IOException  {
		Reader reader = new FileReader("novel/" + type + "/" + fileName);
		BufferedReader br = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		if(flag) {
			String str;
			while((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
		} else {
			for(int i=0;i<10;i++) {
				sb.append(br.readLine());							
			}
		}
		br.close();
		return sb.toString();
	}

}
