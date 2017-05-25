package cn.demo01;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Demo01_practice {
	@Test
	public void testParseXML() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("./files/studs.xml");
		//获取里面的所有<stud>元素
		NodeList list = dom.getElementsByTagName("stud");
		for(int i =0;i<list.getLength();i++){
			Element ele = (Element) list.item(i);
			String id = ele.getAttribute("id");
			System.out.println("id is:"+id);
			//解析学生姓名与年龄
			String name = ele.getElementsByTagName("name").item(0).getTextContent();
			String age = ele.getElementsByTagName("age").item(0).getTextContent();
			System.out.println("name:"+name);
			System.out.println("age:"+age);
			
		}
	}
	@Test
	public void testupdate() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("./files/studs.xml");
		NodeList list = dom.getElementsByTagName("age");
		list.item(1).setTextContent("48");
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(dom), new StreamResult(new File("./files/studs.xml")));
		
  }
	@Test
	public void testadd() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("./files/studs.xml");
		Element newStud = dom.createElement("stud");
		newStud.setAttribute("id", "s002");
		Element name=dom.createElement("name");
		name.setTextContent("绪鑫");
		Element age = dom.createElement("age");
		age.setTextContent("22");
		newStud.appendChild(name);
		newStud.appendChild(age);
		dom.getFirstChild().appendChild(newStud);
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(dom), new StreamResult(new File("./files/studs.xml")));
}
	@Test
	public void testremove() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse("./files/studs.xml");
		Element root = (Element) dom.getFirstChild();
		NodeList list = root.getElementsByTagName("stud");
		Node node = list.item(0);
		root.removeChild(node);
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(dom), new StreamResult(new File("./files/studs.xml")));
}
}