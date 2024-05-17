package com.prowing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowing.entity.Department;
import com.prowing.entity.Employee;

public class StudentRepository {
	public static void main(String[] args) {

//		Student s1=new Student("Ram", "Pune", 85);

//		Car car1=new Car ("Suzuki","Hatchback",1000000);

		Employee emp1 = new Employee("Ram", "HR", 20000);

		Department dept = new Department("HR");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		System.out.println("session factory object created successfully!!");

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

//		session.save(s1);

//		session.save(car1);
//		session.save(emp1);
//		session.save(dept);

//		Car car = session.get(Car.class, 1);
//		Car car = (Car)session.get("com.prowing.Car" , 1);

		Car car = session.load(Car.class, 11);

		System.out.println("Retrived car :" + car);
		txn.commit();
		session.close();

		System.out.println("Student saved successfully");

	}

}
