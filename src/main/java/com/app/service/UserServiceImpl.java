package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
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
}
