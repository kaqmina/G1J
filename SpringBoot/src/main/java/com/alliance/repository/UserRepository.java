package com.alliance.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.entity.Collection;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<Collection, Integer>{
	
	public Collection save(Collection collection);

	
}
