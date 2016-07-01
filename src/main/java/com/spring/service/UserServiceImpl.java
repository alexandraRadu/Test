package com.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.exception.UserNotFound;
import com.spring.model.User;
import com.spring.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserRepository userRepository;

	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}
	
	
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	
	@Transactional(rollbackFor=UserNotFound.class)
	public User delete(int id) throws UserNotFound {
		User deletedUser = userRepository.findOne(id);
		
		if (deletedUser == null)
			throw new UserNotFound();
		
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional(rollbackFor=UserNotFound.class)
	public User update(User user) throws UserNotFound {
		User updatedUser = userRepository.findOne(user.getId());
		
		if (updatedUser == null)
			throw new UserNotFound();
		
		updatedUser.setName(user.getName());
		updatedUser.setId(user.getId());
		return updatedUser;
	}

}

