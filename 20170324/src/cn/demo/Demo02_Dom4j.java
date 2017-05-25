package cn.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo02_Dom4j {
	@Test
	public void test1() throws Exception{
		//读取XML文件，返回一个dom对象
		SAXReader reader = new SAXReader();
		Document dom =  reader.read(new File("./files/studs.xml"));
		//必须要先获取根元素
		Element root =  dom.getRootElement();
		//获取根下的所有子元素 
		List<Element> eles =  root.elements();
		//遍历
		for(Element stud:eles){
			String id = stud.attributeValue("id");
			String name = stud.elementText("name");
			String age = stud.element("age").getText();
			System.err.println(id+","+name+","+age);
		}
	}
	
	@Test
	public void testAdd() throws Exception{
		SAXReader reader = new SAXReader();
		Document dom =  reader.read(new File("./files/studs.xml"));
		//添加新的元素
		Element root = dom.getRootElement();
		//获取根元素并且在根上添加stud 元素
		Element ele = root.addElement("stud");
		ele.addAttribute("id", "S001");
		ele.addElement("name").setText("郭晶晶");
		ele.addElement("age").setText("21");
		
		//保存
		XMLWriter w = new XMLWriter(new FileOutputStream(new File("./files/studs.xml")));
		w.write(dom);
		w.close();
		
	}
	@Test
	public void testdelete() throws Exception{
		//读取XML文件
		SAXReader reader = new SAXReader();
		Document dom = reader.read(new File("./files/studs.xml"));
		//通过xpath找到id='S001'这个学生对象的元素
		String xpath = "//stud[@id='S001']";
		Element ele = (Element) dom.selectSingleNode(xpath);
		//通过获取这个元素的父亲来删除对象
		ele.getParent().remove(ele);
		XMLWriter w = new XMLWriter(new FileOutputStream(new File("./files/studs.xml")));
		w.write(dom);
		w.close();
	}
	@Test
	public void testupdate() throws Exception{
		//读取XML文件
		SAXReader reader = new SAXReader();
		Document dom = reader.read(new File("./files/studs.xml"));
		//通过xpath来找到id=S002的stud对象
		String xpath = "//stud[@id='S002']";
		Element ele = (Element) dom.selectSingleNode(xpath);
		ele.element("name").setText("绪鑫");
		ele.element("age").setText("22");
		XMLWriter w = new XMLWriter(new FileOutputStream(new File("./files/studs.xml")));
		w.write(dom);
		w.close();
				
		
		
		
	}
	@Test
	public void login() throws Exception{
		String name = "Mary";
		String pwd = "4321";
		SAXReader reader = new SAXReader();
		Document dom =  reader.read(new File("./files/users.xml"));
		Element root =  dom.getRootElement();
		List<Element> eles =  root.elements();
		for(Element e:eles){
			String n = e.elementText("name");
			String p = e.elementText("pwd");
			if(name.equals(n) &&pwd.equals(p)){
				System.err.println("OK");
				return;
			}
		}
		
		System.err.println("登录不成功");
	}
	
	@Test
	public void login2() throws Exception{
		String name = "Mary";
		String pwd = "432";
		SAXReader reader = new SAXReader();
		Document dom =  reader.read(new File("./files/users.xml"));
		String xpath = "//user[@id='U002']";
		System.err.println("xpath :"+xpath);
		Element ele =  (Element) dom.selectSingleNode(xpath);
		if(ele!=null){
			System.err.println(ele.asXML());
			System.err.println("登录成功");
		}else{
			System.err.println("登录失败");
		}
		
	}
	
}
