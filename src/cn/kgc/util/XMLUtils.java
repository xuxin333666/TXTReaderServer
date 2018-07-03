package cn.kgc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.kgc.model.Novel;

public class XMLUtils implements Prompt {
	private static Map<String, List<Novel>> novelMap = new HashMap<>();
	private static Properties p;
	private static Set<Object> set;
	private static SAXReader reader;
	private static InputStream is;
	private static Element root;
	
	
	static {
		try {
			is = new FileInputStream("config/novel.properties");
			p = new Properties();
			reader = new SAXReader();
			p.load(is);
			set = p.keySet();
			for (Object str : set) {
				List<Novel> novelList = new ArrayList<>();
				Document document = reader.read(new FileReader((String)p.get(str)));
				root = document.getRootElement();
				List<?> novelNodeList = root.elements();
				for (Object element : novelNodeList) {
					Novel novel = new Novel();
					Element elm = (Element)element;
					novel.setName(elm.element(NOVEL_NAME).getText());
					novel.setAuthor(elm.element(NOVEL_AUTHOR).getText());
					novel.setDescribe(elm.element(NOVEL_DESCRIPTION).getText());
					novel.setFileName(elm.element(NOVEL_FILENAME).getText());
					novelList.add(novel);
				}
				novelMap.put(str.toString(),novelList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (DocumentException e) {
			e.printStackTrace();
		}
	}


	public static Map<String, List<Novel>> getMap() {
		return novelMap;
	}


	public static void upload(Novel novel, String type) throws DocumentException, IOException {
		String typeFileName = p.getProperty(type);
		Document document = reader.read(new FileReader(typeFileName));
		root = document.getRootElement();
		Element elm = root.addElement(NOVEL_ELM);
		elm.addElement(NOVEL_NAME).addText(novel.getName());
		elm.addElement(NOVEL_AUTHOR).addText(novel.getAuthor());
		elm.addElement(NOVEL_DESCRIPTION).addText(novel.getDescribe());
		elm.addElement(NOVEL_FILENAME).addText(novel.getName() + ".txt");
		XMLWriter writer = new XMLWriter(new FileWriter(typeFileName));
		writer.write(document);
		writer.close();
		writeFile(novel);
	}


	private static void writeFile(Novel novel) throws IOException {
		Writer writer = new FileWriter("novel/" + novel.getName() + ".txt");
		writer.write(novel.getContent());
		writer.close();
	}
}
