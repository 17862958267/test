package cn.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import cn.utils.ConnUtils;

public class Demo04_Pst {
	@Test
	public void test4() throws Exception {
		Connection con = ConnUtils.getCon();
		String sql = "{call p1(?,?,?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setString(1, "张三'");
		cs.setInt(2, 90);
		// 注册返回值
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.registerOutParameter(4, Types.INTEGER);
		// 执行
		cs.execute();
		// 获取返回值
		String id = cs.getString(3);
		System.err.println("id:" + id);
		int ccc = cs.getInt(4);
		System.err.println("行数：" + ccc);
		cs.close();
		con.close();
	}

	@Test
	public void test3() throws Exception {
		Connection con = ConnUtils.getCon();
		String sql = "insert into stud(id,name) values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		for (int i = 0; i < 10; i++) {
			pst.setString(1, UUID.randomUUID().toString().replace("-", ""));
			pst.setString(2, "Jack" + i);
			pst.addBatch();

		}
		int[] rows = pst.executeBatch();
		System.err.println(Arrays.toString(rows));// [1,1,1,1,1,1,...]
		pst.close();
		con.close();
	}

	@Test
	public void test1() throws Exception {
		Connection con = ConnUtils.getCon();
		String sql = "insert into images values(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 1);
		pst.setBinaryStream(2, new FileInputStream("d:/a.jpg"));

		int a = pst.executeUpdate();
		System.err.println("影响几行:" + a);
		pst.close();
		con.close();
	}

	@Test
	public void test2() throws Exception {
		Connection con = ConnUtils.getCon();
		String str = "select * from images where id=1";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
		if (rs.next()) {
			InputStream in = rs.getBinaryStream("content");
			Files.copy(in, new File("d:/b.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);

		}
		rs.close();
		st.close();
		con.close();

	}
}
