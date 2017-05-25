package cn.demo01;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

import org.junit.Test;

import oracle.jdbc.driver.OracleDriver;

public class Demo02_Driver {
	@Test
	public void test1() throws Exception {
		Enumeration<Driver> en =  DriverManager.getDrivers();
		while(en.hasMoreElements()){
			Driver d = en.nextElement();
			System.err.println(d);
		}
	}
}
