package com.BikkadIT.UserRepository;
import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.BikkadIT.model.User;

public interface UserRepo extends CrudRepository<User, Serializable> {

	public User findByUnameAndUpwd(String uname,String upwd);
}
