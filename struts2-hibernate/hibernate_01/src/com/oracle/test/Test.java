package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.oracle.entity.Student;

public class Test {

	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Student stu = new Student("绪鑫", 21, new Date());
		Transaction tx = session.beginTransaction();
		session.save(stu);
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
