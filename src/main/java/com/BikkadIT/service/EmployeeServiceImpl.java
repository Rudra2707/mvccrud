package com.BikkadIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.BikkadIT.UserRepository.UserRepo;
import com.BikkadIT.model.User;

@Service
public class EmployeeServiceImpl implements UserServiceI{

	@Autowired
	private UserRepo userRepo;

	@Override
	public int saveUserService(User user) {
		System.out.println("Service Layer");
		System.out.println(user);
		User user1 = userRepo.save(user);
		
		return user1.getUid();
	}

	@Override
	public List<User> getAllUsersService() {
		List<User> list = (List<User>) userRepo.findAll();
		return list;
	}

	@Override
	public User loginCheck(User user) {
		User user1 = userRepo.findByUnameAndUpwd(user.getUname(), user.getUpwd());
		return user1;
	}

	@Override
	public User editUser(int uid) {
		User user = userRepo.findById(uid).get();
		return user;
	}

	@Override
	public User update(User user) {
	User user2 = userRepo.save(user);
		return user2;
	}

	@Override
	public boolean delete(int uid) {
		
		boolean existsById = userRepo.existsById(uid);
		if(existsById) {
	         userRepo.deleteById(uid);
	         return true;
		}else {
		return false;
	}
}
}
