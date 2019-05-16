package com.alliance.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;
import com.alliance.entity.User;
import com.alliance.model.CustomerSearchFilter;
import com.alliance.model.ListResult;
import com.alliance.service.UserService;

@RestController(value = "userApiController")
@RequestMapping(value = "api/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, path = "addCollection")
	public void addCollection(@RequestParam String name, @RequestParam int userId) {
		userService.saveCollection(userId,name);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "renameCollectionTitle")
	public void renameCollectionTitle(@RequestParam String title, @RequestParam int userId, @RequestParam int collectionId) {
		userService.renameCollectionTitle(title,userId,collectionId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "addCardToCollection")
	public void addCardToCollection(@RequestParam int collectionId, @RequestParam String heading, @RequestParam String desc) {
		userService.addCardToCollection(collectionId, heading, desc);
	}
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/{username}/{password}")
//	public User Login(@PathVariable(name = "username") String username,@PathVariable(name = "password") String password) {
//		//userService.saveCollection(userId,name);
//		return userService.getUserByIdandPassword(username,password);
//		
//		}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{cardId}")
	public Card viewCard(@PathVariable(name = "cardId") int cardId) {
		//userService.saveCollection(userId,name);
			return userService.viewCardById(cardId);
		}

	@RequestMapping(method = RequestMethod.POST, path = "editCardDesc")
	public void editCardDesc(@RequestParam int id, @RequestParam String desc) {
<<<<<<< HEAD
		//userService.saveCardDesc(id, desc);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "viewAllCardsByCollectionId")
	public List<Card> viewAllCardsByCollectionId(@RequestParam int collectionId) {
		List<Card> cards = userService.viewAllCardsByCollectionId(collectionId);
		return cards;
=======
		userService.saveCardDesc(id, desc);

	}
	
	@RequestMapping(method = RequestMethod.GET, path = "deleteCard")
	public void deleteCard(@RequestParam String delete, @RequestParam int cardId, @RequestParam int collectionId) {
		if(!delete.isEmpty()) {
			userService.setCardByIsArchived(0, cardId, collectionId);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "renameCollectionTitle")
	public void editCardHeading(@RequestParam String heading, @RequestParam int cardId, @RequestParam int collectionId) {
		userService.editCardHeading(heading, cardId, collectionId);
>>>>>>> 7efc04b7fb4464472fa3c8a0b75c19f9fb6157db
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "viewSingleCardByCardId")
	public Card viewSingleCardByCardId(@RequestParam int cardId) {
		Card card = userService.viewSingleCardByCardId(cardId);
		return card;
	}
	
	
//	@RequestMapping(method = RequestMethod.GET, path = "checkIfUserExists")
//	public User Login(@RequestParam String username, @RequestParam String password) {
//		//userService.saveCollection(userId,name);
//		return userService.getUserByIdandPassword(username,password);
//	}

}
