package com.alliance.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.alliance.entity.Collection;
import com.alliance.entity.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>{

	public User save(User user);
	
	public User findByUsernameAndPassword(String username,String password);

	public String findByUsername(String username);
	
}
