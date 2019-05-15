package com.alliance.repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;
import com.alliance.entity.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<Collection, Integer>{

	/*public User getSingleUser(int userId) {
		
		String userQuery = "FROM User WHERE userId = :uid";
		//StringBuilder studentQuery = new StringBuilder("FROM Student");
		//Query query = em.createQuery(studentQuery.toString());
		Query query = (Query) em.createQuery(userQuery);
		((javax.persistence.Query) query).setParameter("uid", userId);
		User user = (User)((javax.persistence.Query) query).getSingleResult();
		return user;
	}*/

	
	

}
