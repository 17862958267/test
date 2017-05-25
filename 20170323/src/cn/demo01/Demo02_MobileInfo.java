package cn.demo01;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Demo02_MobileInfo {
	@Test
	public void test1() throws Exception {
		String tel = "13813110271";
		// 1:获取地址
		String addr = "http://ws.webxml.com.cn/WebServices/"//
				+ "MobileCodeWS.asmx/getMobileCodeInfo?mobileCode=" + tel + "&userID=";
		// 2:声明URL
		URL url = new URL(addr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setConnectTimeout(4000);
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
		// System.err.println("获取到的数据是:"+sb.toString());
		// 以下开始解析xml文件
		parseXml(sb.toString());
	}

	public void parseXml(String xmlString) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(new ByteArrayInputStream(xmlString.getBytes()));
		NodeList list = dom.getElementsByTagName("string");
		Element ele = (Element) list.item(0);
		String text = ele.getTextContent();
		System.err.println(text);
	}
}
