package com.app.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // to tell SC : following class is a spring bean that contains data access logic + enables exc
			// translation mechanism
public class UserDaoImpl implements IUserDao {
	// dependency : D.I
	
	@Autowired // byType
	private EntityManager manager;//equivalent to org.hibernate.Session , associated with L1 cache n 
	//represents pooled out DB connection : from connection pool managed by Hikari 
	
	@Override
	public User validateUser(String email, String pass) {
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		
		return manager.
				createQuery(jpql, User.class).
				setParameter("em", email).
				setParameter("pass",pass).getSingleResult();
	}
	@Override
	public User registerUser(User user) {
		//User mesg = "User reg failed....";
																													// t
		try {
			// org.hibernate.Session API : public Serializable save(Object transientObjRef)
			// throws HibernateExc
			
			EntityTransaction tx= manager.getTransaction();
			tx.begin();
			manager.persist(user);
			tx.commit();// Upon commit : Hibernate performs "auto dirty checking" :by comparing state of
						// L1 cache with that of DB : DML will be fired (insert)
			
			//mesg = "user registered successfully with ID=";
																														// t
			// user : PERSISTENT
		} catch (RuntimeException e) {
			
			throw e;
		} finally {
			if (manager != null)
				manager.close();// pooled out DB cn rets to the pool n L1 cache is destroyed
			
		}
		// user : DETACHED
		//System.out.println("session is open " + session.isOpen() + " is connected to db cn " + session.isConnected());// f
																														// f

		return user;
	}
	
//	@Override
//	public int registerUser(User u) {
//		String sql="insert into users (age, email, experience,gender,name,password,role,sme) values('"+u.getAge()+"',"+u.getEmail()+",'"+u.getExperience()+",'"+u.getGender()+","+u.getName()+",'"+u.getPassword()+",'"+u.getRole()+",'"+u.getSme()+",)";
//				 manager.createNativeQuery("INSERT INTO users (age, email, experience,gender,name,password,role,sme,contactno) VALUES (?,?,?,?,?,?,?,?,?)")
//	      .setParameter(1, u.getAge())
//	      .setParameter(2, u.getEmail())
//	      .setParameter(3, u.getExperience())
//	      .setParameter(4, u.getGender())
//	      .setParameter(5, u.getName())
//	      .setParameter(6, u.getPassword())
//	      .setParameter(7, u.getRole())
//	      .setParameter(8, u.getSme())
//	      .setParameter(9, u.getContactno())
//	      .executeUpdate();
//				int statusCode = (Integer) mgr.getCurrentSession().save(u);
//		if (statusCode > 0)
//			return "User registered";
//		return "User registered ";
//	

}
