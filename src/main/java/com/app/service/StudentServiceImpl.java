package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojos.CourseTable;
import com.app.pojos.Student;
import com.app.repositories.userrepositories;

@Service // => spring bean class containing B.L
@Transactional // => automatic Tx management (done by spring supplied hibernate tx mgr
				// configured in hibernate-persistece.xml file
public class StudentServiceImpl implements IStudentService {
	// dependency
	@Autowired // autowire=byType =>SC searches for any spring bean that has imple. IUserDao n
				// supplies it's instance
	private IStudentDao studentDao;
	private userrepositories userRepository;

    @Autowired
    public void setProductRepository(userrepositories userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public Student validateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return studentDao.validateUser(email, pass);
	}

	 @Override
	    public void saveFaculty(Student u) {
	       this.userRepository.save(u);
	    }

	@Override
	public List<CourseTable> listAll() {
		// TODO Auto-generated method stub
		return studentDao.list();
	}
}
