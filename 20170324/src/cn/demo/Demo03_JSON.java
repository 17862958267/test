package cn.demo;

import java.io.File;
import java.nio.file.Files;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Demo03_JSON {
	@Test
	public void test() throws Exception{
		String str = new String(Files.readAllBytes(new File("./files/abc.json").toPath()));
		JSONObject obj = JSONObject.parseObject(str);
		JSONArray array = obj.getJSONArray("musics");
		for(int i=0;i<array.size();i++){
			JSONObject music = array.getJSONObject(i);
			String title = music.getString("title");
			System.err.println(title);
		}
		
		
	}
	@Test
	public void test1() throws Exception{
		String str = new String(Files.readAllBytes(new File("./files/abc.json").toPath()));
		//利用JSONObject类读取json文件中的内容
		JSONObject obj = JSONObject.parseObject(str);
		JSONArray array = obj.getJSONArray("");
	}
}
