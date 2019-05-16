package com.alliance.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;
import com.alliance.entity.Customer;
import com.alliance.entity.User;
import com.alliance.repository.CardRepository;
import com.alliance.repository.CollectionRepository;
import com.alliance.repository.UserRepository;

@Service("userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired 
	private CollectionRepository collectionRepository;
	
	//helper
	public boolean validCollection (String name) {
		return name.equalsIgnoreCase(collectionRepository.findByName(name)) ? true:false;
	}
	
	public void saveCollection(int userId, String name) {
		if(validCollection(name)) {
			Collection collection = new Collection();
			collection.setName(name);
			collection.setUserId(userId);
			collectionRepository.save(collection);
		}
	}
	
	public User getUserByIdandPassword(String username) {
		return userRepository.findByusername(username);


	public void renameCollectionTitle(String title, int userId, int collectionId) {
		// TODO Auto-generated method stub
		Collection collection = new Collection();
		collection.setId(collectionId);
		collection.setName(title);
		collection.setUserId(userId);
		collectionRepository.save(collection);
	}

	public void saveCard(String heading, String desc, int collectionId) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setHeading(heading);
		card.setDesc(desc);
		card.setCollectionId(collectionId);
		cardRepository.save(card);
	}

	@Query("UPDATE Card c SET c.desc = ?2 WHERE c.cardId = ?1")
	public void saveCardDesc(int id, String desc) {
		// TODO Auto-generated method stub
		
	}
	
	
}
