package cn.demo01;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Demo04_Mp3 {
	@Test
	public void test1() throws Exception {
		String word = "4699.mp3";
		// 1:获取地址
		String addr = "http://fy.webxml.com.cn"//
				+ "/webservices/EnglishChinese.asmx/GetMp3?Mp3=" + word;
		// 2:声明URL
		URL url = new URL(addr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setConnectTimeout(3000);
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		con.connect();
		int code = con.getResponseCode();
		StringBuffer sb = new StringBuffer();
		if (code == 200) {
			InputStream in = con.getInputStream();
			byte[] bs = new byte[1024];
			int len = 0;
			while ((len = in.read(bs)) != -1) {
				sb.append(new String(bs, 0, len));
			}
			in.close();
		}

		con.disconnect();
		parseXml(sb.toString());
	}

	public void parseXml(String xmlString) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new ByteArrayInputStream(xmlString.getBytes()));
		// 4:获取里面的所有<stud>元素
		NodeList list = dom.getElementsByTagName("base64Binary");
		Element e = (Element) list.item(0);
		String str = e.getTextContent();
		System.err.println(str);
		
		byte[] bs =  Base64.getDecoder().decode(str);
		OutputStream out = new FileOutputStream("f:/a/aa3.mp3");
		out.write(bs);
		out.close();

	}
}
