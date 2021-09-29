package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.CourseTable;
import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;
import com.app.pojos.User;
import com.app.repositories.userrepositories;

@Service // => spring bean class containing B.L
@Transactional // => automatic Tx management (done by spring supplied hibernate tx mgr
				// configured in hibernate-persistece.xml file
public class UserServiceImpl implements IUserService {
	// dependency
	@Autowired // autowire=byType =>SC searches for any spring bean that has imple. IUserDao n
				// supplies it's instance
	private IUserDao userDao;
	private userrepositories userRepository;

    @Autowired
    public void setProductRepository(userrepositories userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public User validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userDao.validateUser(email, pass);
	}

	 @Override
	    public void saveFaculty(User u) {
	       this.userRepository.save(u);
	    }

	@Override
	public List<User> listFaculty() {
		// TODO Auto-generated method stub
		return userDao.listFaculty();
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return userDao.listStudent();
	}

	@Override
	public User getFacultyDetails(int id) {
		// TODO Auto-generated method stub
		return userDao.getFacultyDetails(id);
	}

	@Override
	public String updateFacultyDetails(User u) {
		// TODO Auto-generated method stub
		return userDao.updateFacultyDetails(u);
	}

	@Override
	public String deleteFacultyDetails(int id) {
		User user=userDao.getFacultyDetails(id);
		if(user!=null)
			return userDao.deleteFacultyDetails(user);
		return "User Details Deletion Failed : invalid User";
	}

	@Override
	public void saveCourse(CourseTable u) {
	
		 this.userRepository.save(u);
	}

	@Override
	public void saveNotice(FacultyNotice u) {
		this.userRepository.save(u);
		
	}

	@Override
	public void saveNoticestudent(StudentNotice u) {
		this.userRepository.save(u);
		
	}

	@Override
	public List<FacultyNotice> listnotice() {
		// TODO Auto-generated method stub
		return userDao.listnotice();
	}

	@Override
	public void saveSchedule(Schedule u) {
		this.userRepository.save(u);
		
	}

	@Override
	public List<Schedule> listschedule() {
		// TODO Auto-generated method stub
		return userDao.listschedule();
	}

	
}
