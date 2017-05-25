package cn.demo01;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.domain.Stud;
import cn.utils.DataSourceUtils;

public class Demo01 {
	@Test
	public void test1() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		Object[] objs = run.query("select * from cars where id=?", new ArrayHandler(),
				"C001");
		System.err.println(Arrays.toString(objs));
	}

	@Test
	public void test2() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from stud";
		List<Object[]> list = run.query(sql, new ArrayListHandler());
		for (Object[] objs : list) {
			System.err.println(Arrays.toString(objs));
		}
	}

	@Test
	public void test3() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from stud";
		Stud stud = run.query(sql, new BeanHandler<Stud>(Stud.class));
		System.err.println(stud);
	}

	@Test
	public void test4() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from stud";
		Map<String, Stud> map = run.query(sql, new BeanMapHandler<String, Stud>(Stud.class, "id"));
		System.err.println(map);

	}

	@Test
	public void test5() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select name from stud";
		List<String> list = run.query(sql, new ColumnListHandler<>());
		System.err.println(list);

	}

	@Test
	public void test() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from stud";
		Map<String, Map<String, Object>> map = run.query(sql, new KeyedHandler<>());
		System.err.println(map);

	}

	@Test
	public void test7() throws Exception {
		// 传递dataSource
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from stud";
		Map<String, Object> map = run.query(sql, new MapHandler());
		System.err.println(map);
	}

	@Test
	public void test8() throws Exception {
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(1) from stud";
		Integer count = run.query(sql, new ScalarHandler<BigDecimal>()).intValue();
		System.err.println(count);
	}

	@Test
	public void test9() throws Exception {
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select id,name,age,(case when sex='1' then '男' else '女' end) as sex from stud";
		List<Stud> list = run.query(sql, new BeanListHandler<Stud>(Stud.class));
		System.err.println("list is:" + list);
	}

	@Test
	public void testTx() throws Exception {
		QueryRunner run = new QueryRunner(DataSourceUtils.getDataSource());
		Connection con = DataSourceUtils.getConnection();
		try {
			con.setAutoCommit(false);
			String sql = "insert into stud(id,name) values(sys_guid(),'张三')";
			run.update(con,sql);
			sql = "insert into stud(id,name) values(sys_guid(),'李四')";
			run.update(con,sql);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			con.setAutoCommit(true);
			con.close();
		}

	}

}
