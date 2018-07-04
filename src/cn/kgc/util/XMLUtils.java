package cn.kgc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
import cn.kgc.model.User;

public class XMLUtils implements Prompt {
	private static Map<String, List<Novel>> novelMap = new HashMap<>();
	private static List<User> UserList = new ArrayList<>();
	private static Properties pNovel;
	private static Properties pUser;
	private static Set<Object> set;
	private static SAXReader reader;
	private static InputStream is;
	private static Element root;
	
	
	static {
		try {
			is = new FileInputStream("config/novel.properties");
			pNovel = new Properties();
			reader = new SAXReader();
			pNovel.load(is);
			set = pNovel.keySet();
			for (Object str : set) {
				List<Novel> novelList = new ArrayList<>();
				Document document = reader.read(new FileReader((String)pNovel.get(str)));
				root = document.getRootElement();
				List<?> novelNodeList = root.elements();
				for (Object element : novelNodeList) {
					Novel novel = new Novel();
					Element elm = (Element)element;
					novel.setName(elm.element(NOVEL_NAME).getText());
					novel.setAuthor(elm.element(NOVEL_AUTHOR).getText());
					novel.setDescribe(elm.element(NOVEL_DESCRIPTION).getText());
					novel.setFileName(elm.element(NOVEL_FILENAME).getText());
					novel.setType((String)str);
					novelList.add(novel);
				}
				novelMap.put(str.toString(),novelList);
			}
			is = new FileInputStream("config/users.properties");
			pUser = new Properties();
			pUser.load(is);
			String userFileName = pUser.getProperty("用户");
			Document document = reader.read(new FileReader(userFileName));
			Element root = document.getRootElement();
			List<?> elm = root.elements();
			for (Object user : elm) {
				Element userElm = (Element)user; 
				User newUser = new User(userElm.element("username").getText(), userElm.element("password").getText());
				UserList.add(newUser);
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
	
	public static List<User> getUserList() {
		return UserList;
	}


	public static void upload(Novel novel, String type) throws DocumentException, IOException {
		String typeFileName = pNovel.getProperty(type);
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
		NovelUtils.writeFile(novel);
	}
	
	
	public static void addUserInXML(User user) throws DocumentException, IOException {
		String userFileName = pUser.getProperty("用户");
		Document document = reader.read(new FileReader(userFileName));
		root = document.getRootElement();
		Element elm = root.addElement(USER_ELM);
		elm.addElement(USER_USERNAME).addText(user.getUsername());
		elm.addElement(USER_PASSWORD).addText(user.getPassword());
		XMLWriter writer = new XMLWriter(new FileWriter(userFileName));
		writer.write(document);
		writer.close();
	}

}
