package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojos.CourseTable;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;
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

	@Override
	public Student getStudentDetails(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentDetails(id);
	}

	@Override
	public String updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudentDetails(student);
	}

	@Override
	public String deleteStudentDetails(int id) {
		Student user=studentDao.getStudentDetails(id);
		if(user!=null)
			return studentDao.deleteStudentDetails(user);
		return "User Details Deletion Failed : invalid User";
	}

	@Override
	public List<CourseTable> listDAC() {
		// TODO Auto-generated method stub
		return studentDao.listDAC();
	}

	@Override
	public List<CourseTable> listDBDA() {
		// TODO Auto-generated method stub
		return studentDao.listDBDA();
	}

	@Override
	public List<CourseTable> listDTISS() {
		// TODO Auto-generated method stub
		return studentDao.listDTISS();
	}


	@Override
	public String updateCourseDetails(CourseTable user) {
		// TODO Auto-generated method stub
		return studentDao.updateCourseDetails(user);
	}

	@Override
	public CourseTable getCourseDetails(int vid) {
		// TODO Auto-generated method stub
		return studentDao.getCourseDetails(vid);
	}

	@Override
	public String deleteCourseDetails(int vid) {
		CourseTable user=studentDao.getCourseDetails(vid);
		if(user!=null)
			return studentDao.deleteCourseDetails(user);
		return "User Details Deletion Failed : invalid User";
	
	}

	@Override
	public List<StudentNotice> listnotice() {
		// TODO Auto-generated method stub
		return studentDao.listnotice();
	}
}
