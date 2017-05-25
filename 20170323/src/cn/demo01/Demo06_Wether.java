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

public class Demo06_Wether {
	@Test
	public void test() throws Exception{
		String CityCode = "高邮";
		//获取地址
		String address = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx"+CityCode+"&theUserID=";
		//声明URL
		URL url = new URL(address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setConnectTimeout(3000);
		con.setRequestMethod("POST");
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
		NodeList list = dom.getElementsByTagName("ArrayOfString");
		for(int i=0;i<list.getLength();i++){
			Element ele = (Element) list.item(i);
			String content = ele.getElementsByTagName("String").item(0).getTextContent();
			System.out.println(content);
		}
		}
	}

	


