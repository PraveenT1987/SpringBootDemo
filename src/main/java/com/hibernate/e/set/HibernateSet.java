package com.hibernate.e.set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.a.entities.Address;
import com.hibernate.a.utils.HibernateUtil;

public class HibernateSet {

	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(1);
		userDetails.setUserName("G RAVI KIRAN");
		userDetails.setUserAge(37);

		Address addr1 = new Address();
		addr1.setStreet("Mohannagar");
		addr1.setCity("Hyderabad");
		addr1.setState("Telangana");
		addr1.setPincode("500035");
		
		Address addr2 = new Address();
		addr2.setStreet("Habsiguda");
		addr2.setCity("Hyderabad");
		addr2.setState("Telangana");
		addr2.setPincode("500008");
		
		userDetails.getListOfAddress().add(addr1);
		userDetails.getListOfAddress().add(addr2);

		SessionFactory factory = HibernateUtil.getSessionFactoryInstance(UserDetails.class);
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		
		System.out.println("Read Data from Database");
		int id = 1;
		
		UserDetails userDetails1 = (UserDetails) session.get(UserDetails.class, id);
		
		System.out.println(userDetails1);
		
		session.close();
	}

}