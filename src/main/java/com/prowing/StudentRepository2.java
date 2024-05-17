package com.prowing;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowing.entity.Department;
import com.prowing.entity.Employee;

public class StudentRepository2 {
	public static void main(String[] args) {

//		Student s1=new Student("Ram", "Pune", 85);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = null;
		Transaction txn = null;

		try {

			session = sessionFactory.openSession();
			
			String hql = "INSERT INTO studentrecords(id, name, address, marks)" + "SELECT id, name, address, marks FROM student";
			
			Query query = session.createQuery(hql);
			
			int res = query.executeUpdate();
			
			System.out.println("Rows affected "+ res);

			txn = session.beginTransaction();
			txn.commit();
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();
		}
		session.close();

		System.out.println("Student saved successfully");

	}

}
