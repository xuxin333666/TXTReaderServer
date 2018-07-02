package cn.kgc.util;

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

import cn.kgc.model.Novel;

public class XMLUtils implements Prompt {
	private static Map<String, List<Novel>> novelMap = new HashMap<>();
	
	
	static {
		try {
			InputStream is = new FileInputStream("config/novel.properties");
			Properties p = new Properties();
			SAXReader reader = new SAXReader();
			p.load(is);
			Set<Object> set = p.keySet();
			for (Object str : set) {
				Document document = reader.read(new FileReader((String)p.get(str)));
				Element root = document.getRootElement();
				List<Element> novelList = root.elements();
				for (Element element : novelList) {
					Novel novel = new Novel();
					novel.setName(element.element(NOVEL_NAME).getText());
					novel.setAuthor(element.element(NOVEL_AUTHOR).getText());
					novel.setDescribe(element.element(NOVEL_DESCRIPTION).getText());
					novel.setFileName(element.element(NOVEL_FILENAME).getText());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
