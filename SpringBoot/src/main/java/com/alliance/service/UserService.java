package com.alliance.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;
import com.alliance.entity.Customer;
import com.alliance.entity.User;
import com.alliance.repository.CardRepository;
import com.alliance.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void saveCollection(int userId, String name) {
		Collection collection = new Collection();
		collection.setName(name);
		collection.setUserId(userId);
		userRepository.save(collection);
	}

/*	public void saveCard(String heading, String desc, int collectionId) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setHeading(heading);
		card.setDesc(desc);
		card.setCollectionId(collectionId);
		cardRepository.save(card);
	}*/
	
	
}
