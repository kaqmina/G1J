package com.alliance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public User getUserByIdandPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}

//	public Card viewCardById(int cardId) {
//		return cardRepository.findOneByCardId(cardId);
//	}
	
	
	public void renameCollectionTitle(String title, int userId, int collectionId) {
		// TODO Auto-generated method stub
		Collection collection = new Collection();
		collection.setId(collectionId);
		collection.setName(title);
		collection.setUserId(userId);
		collectionRepository.save(collection);
	}

	public void addCardToCollection(int collectionId, String heading, String desc) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setHeading(heading);
		card.setDesc(desc);
		card.setCollectionId(collectionId);
		cardRepository.save(card);
	}

	public List<Card> viewAllCardsByCollectionId(int collectionId) {
		// TODO Auto-generated method stub
		List<Card> cards = cardRepository.findAllByCollectionId(collectionId);
		return cards;
	}


	public Card viewSingleCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		Card card = cardRepository.findOneByCardId(cardId);
		return card;
	}



	public void setCardByIsArchived(int i, int cardId, int collectionId) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setId(cardId);
		card.setCollectionId(collectionId);
		card.setIsArchived(i);
		cardRepository.save(card);
	}
	
	public void editCardHeading(String heading, int cardId, int collectionId) {
		// TODO Auto-generated method stub
		Card card = new Card();
		card.setId(cardId);
		card.setHeading(heading);
		card.setCollectionId(collectionId);
		cardRepository.save(card);
	}

	

	

}
