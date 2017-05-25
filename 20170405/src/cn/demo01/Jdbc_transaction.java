package cn.demo01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.utils.ConnUtils;

/**
 * 
 * @author xuxin
 * 在JAVA中,默认没有事务，如何在用java代码操作数据库的过程中控制事务呢
 * 1.开启事务(设置自动提交的方式为false)
 * 2.开始事务
 * 3.不成功就回滚
 * 4.关闭事务
 *
 */
public class Jdbc_transaction {
	@Test
	public void testTransaction() throws SQLException{
	Connection con = ConnUtils.getCon();
    Statement st = con.createStatement();
    try{
    	con.setAutoCommit(false);
    	st.executeUpdate("insert into stud(id,name,age) values('S006','Duke','45')");
    	st.executeUpdate("insert into stud(id,name,age) values('S007','Chris','31')");
    	con.commit();
       }catch(Exception e){
    	   con.rollback();
    	   throw e;
    	}finally{
    	con.setAutoCommit(true);
    	st.close();
    	con.close();
    }
}
}
