package com.app.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.User;
import com.app.pojos.UserRole;

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
	@Override
	public List<User> listFaculty() {
		String jpql="select u from User u where u.role=:r1";
		return manager.createQuery(jpql, User.class).setParameter("r1",UserRole.FACULTY).getResultList();
	}
	@Override
	public List<Student> listStudent() {
		String jpql="select u from Student u";
		return manager.createQuery(jpql, Student.class).getResultList();
	
	}
	@Override
	public User getFacultyDetails(int id) {
		// TODO Auto-generated method stub
		return manager.find(User.class, id);
	}
	@Override
	public String updateFacultyDetails(User u) {
		User user=manager.merge(u);
		return user.getName()+" Details Updated";
	}
	@Override
	public String deleteFacultyDetails(User user) {
		manager.remove(user);
		return "User "+user.getName()+" is deleted";
	}
	@Override
	public List<FacultyNotice> listnotice() {
		// TODO Auto-generated method stub
		String jpql="select u from FacultyNotice u";
		return manager.createQuery(jpql, FacultyNotice.class).getResultList();
		
	}
	@Override
	public List<Schedule> listschedule() {
		String jpql="select u from Schedule u";
		return manager.createQuery(jpql, Schedule.class).getResultList();
		
	}
	
	

}
