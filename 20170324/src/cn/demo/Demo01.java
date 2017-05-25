package cn.demo;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Demo01 {
	@Test
	public void test1() throws Exception {
		// 创建Sax解析器
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		// 解析xml文件
		parser.parse(new File("./files/studs.xml"), new DefaultHandler() {
			private String qName;

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if (qName.equals("stud")) {// 遇到了stud元素的开始
					// 读取属性
					String id = attributes.getValue("id");
					System.err.println("id:" + id);
				} else if (qName.equals("name") || qName.equals("age")) {
					this.qName = qName;
				}
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if (qName != null) {
					String str = new String(ch, start, length);
					System.err.println(qName + " :" + str);
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
				if (qName.equals("name") || qName.equals("age")) {
					this.qName = null;
				}else if(qName.equals("stud")){
					System.err.println("---------------------");
				}
			}
		});

	}
}
