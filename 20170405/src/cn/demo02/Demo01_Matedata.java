package cn.demo02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Types;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo01_Matedata {
	@Test
	public void test1() throws Exception {
		Connection con = ConnUtils.getCon();
		// 获取数据库的元信息
		DatabaseMetaData dbmd = con.getMetaData();
		// 获取当前用户的所有表
		ResultSet rs = dbmd.getTables("jack", "jack", null, new String[] { "TABLE" });
		while(rs.next()){
			String tname = rs.getString("TABLE_NAME");
			System.err.println(tname);
		}
		rs.close();
		con.close();
	}
	
	@Test
	public void test2() throws Exception {
		Connection con = ConnUtils.getCon();
		Statement st = con.createStatement();
		String sql = "select * from images";
		ResultSet rs = st.executeQuery(sql);
		//获取结果集的元信息
		ResultSetMetaData rsmd = rs.getMetaData();
		//获取列的个数
		int cols = rsmd.getColumnCount();
		for(int i=1;i<=cols;i++){//获取列的名称
			String colname = rsmd.getColumnName(i);
			String type = rsmd.getColumnTypeName(i);
			int size = rsmd.getColumnDisplaySize(i);
			System.err.print(colname+" "+type+"("+size+")\t\t");
			
		}
		System.err.println();
		while(rs.next()){
			for(int i=1;i<=cols;i++){
				if(rsmd.getColumnType(i)==Types.BLOB || rsmd.getColumnType(i)==Types.CLOB){
					continue;
				}
				String val = rs.getString(i);
				
				System.err.print(val+"\t\t");
			}
			System.err.println();
		}
		
		
		rs.close();
		st.close();
		con.close();
	}
}
