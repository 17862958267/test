package cn.demo01;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//利用JAXP-DOM解析XML文件，可进行增删查改，速度比较慢
public class Demo01 {
	@Test
	public void test1() throws Exception {
		// 1:创建DBF
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2:创建db对象
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 3:读取XML文件返回一个dom对象
		Document dom = db.parse(new File("./files/studs.xml"));
		// 4:获取里面的所有<stud>元素
		NodeList list = dom.getElementsByTagName("stud");
		// 5:遍历
		for (int i = 0; i < list.getLength(); i++) {
			// 获取里面的每个<stud>
			Element ele = (Element) list.item(i);
			// 获取id
			String id = ele.getAttribute("id");
			System.err.println("id is:" + id);
			// 解析nama,age
			String name = ele.getElementsByTagName("name").item(0).getTextContent();
			String age = ele.getElementsByTagName("age").item(0).getTextContent();
			System.err.println("name:"+name);
			System.err.println("age:"+age);
			System.err.println("==============================");
		}
		
    }
	@Test
	public void testupdate() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new File("./files/studs.xml"));
		NodeList list = dom.getElementsByTagName("name");
		Node node = list.item(0);
		node.setTextContent("张三");
		//必须要再重新保存一下dom对象
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(dom),new StreamResult(new File("./files/studs.xml")));
   }
	@Test
	public void testadd() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new File("./files/studs.xml"));
		Element newStud = dom.createElement("stud");
		newStud.setAttribute("id","S003");
		
		Element name  = dom.createElement("name");
		name.setTextContent("越七");
		
		Element age = dom.createElement("age");
		age.setTextContent("26");
		
		newStud.appendChild(name);
		newStud.appendChild(age);
		
		dom.getFirstChild().appendChild(newStud);
		
		//必须要再重新保存一下dom对象
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(dom),new StreamResult(new File("./files/studs.xml")));
  }
	@Test
	public void testremove() throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new File("./files/studs.xml"));
		//获取根元素
		Element root = (Element) dom.getFirstChild();
		//获取最后一个<stud>元素
		NodeList list = root.getElementsByTagName("stud");
		Node theLast = list.item(list.getLength()-1);
		root.removeChild(theLast);
		//删除这个元素,在内存中删除了。文件中还在
		//dom.removeChild(theLast);
		//必须要再重新保存一下dom对象
		Transformer ts = TransformerFactory.newInstance().newTransformer();
		ts.transform(new DOMSource(dom),new StreamResult(new File("./files/studs.xml")));
		
	}
}
