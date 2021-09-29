package com.app.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.CourseTable;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;

@Repository // to tell SC : following class is a spring bean that contains data access logic + enables exc
			// translation mechanism
public class StudentDaoImpl implements IStudentDao {
	// dependency : D.I
	
	@Autowired // byType
	private EntityManager manager;//equivalent to org.hibernate.Session , associated with L1 cache n 
	//represents pooled out DB connection : from connection pool managed by Hikari 
	
	@Override
	public Student validateUser(String email, String pass) {
		String jpql="select u from Student u where u.email=:em and u.password=:pass";
		
		return manager.
				createQuery(jpql, Student.class).
				setParameter("em", email).
				setParameter("pass",pass).getSingleResult();
	}
	@Override
	public Student registerUser(Student user) {
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
	public List<CourseTable> list() {
		String jpql="select c from CourseTable c";
		return manager.createQuery(jpql,CourseTable.class).getResultList();
	}
	@Override
	public Student getStudentDetails(int id) {
		// TODO Auto-generated method stub
		return manager.find(Student.class, id);
	}
	@Override
	public String updateStudentDetails(Student student) {
		Student user=manager.merge(student);
		return user.getName()+" Details Updated";
	}
	@Override
	public String deleteStudentDetails(Student user) {
		manager.remove(user);
		return "User "+user.getName()+" is deleted";
	}
	@Override
	public List<CourseTable> listDAC() {
		String jpql="select c from CourseTable c where c.course=:c1";
		return manager.createQuery(jpql,CourseTable.class).setParameter("c1",Course.DAC).getResultList();
	
	}
	@Override
	public List<CourseTable> listDBDA() {
		String jpql="select c from CourseTable c where c.course=:c1";
		return manager.createQuery(jpql,CourseTable.class).setParameter("c1",Course.DBDA).getResultList();
	
	}
	@Override
	public List<CourseTable> listDTISS() {
		String jpql="select c from CourseTable c where c.course=:c1";
		return manager.createQuery(jpql,CourseTable.class).setParameter("c1",Course.DTISS).getResultList();
	
	}
	@Override
	public String updateCourseDetails(CourseTable user) {
		CourseTable course=manager.merge(user);
		return "Details Updated "+course.getSubjectname();
	}
	@Override
	public CourseTable getCourseDetails(int uid) {
		// TODO Auto-generated method stub
		return manager.find(CourseTable.class, uid);
	}
	@Override
	public String deleteCourseDetails(CourseTable user) {
		manager.remove(user);
		return "Subject "+user.getSubjectname()+" is deleted";
	}
	@Override
	public List<StudentNotice> listnotice() {
		String jpql="select c from StudentNotice c ";
		return manager.createQuery(jpql,StudentNotice.class).getResultList();
	
	}


}
