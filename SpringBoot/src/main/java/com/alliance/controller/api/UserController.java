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
	
	@RequestMapping(method = RequestMethod.GET, value = "/{username}/{password}")
	public int Login(@PathVariable(name = "username") String username,@PathVariable(name = "password") String password) {
		//return userService.getUserByIdandPassword(username,password);
		User user= new User();
		user=userService.getUserByIdandPassword(username,password);
		if(user!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/{cardId}")
//	public Card viewCard(@PathVariable(name = "cardId") int cardId) {
//		//userService.saveCollection(userId,name);
//			return userService.viewCardById(cardId);
//		}

	// in progress: error is SQL Syntax
	@RequestMapping(method = RequestMethod.POST, path = "editCardDesc")
	public void editCardDesc(@RequestParam int cardId, @RequestParam int collectionId, @RequestParam String desc) {
		userService.editCardDesc(cardId, collectionId, desc);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "viewAllCardsByCollectionId")
	public List<Card> viewAllCardsByCollectionId(@RequestParam int collectionId) {
		List<Card> cards = userService.viewAllCardsByCollectionId(collectionId);
		return cards;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "deleteCard")
	public void deleteCard(@RequestParam String delete, @RequestParam int cardId, @RequestParam int collectionId) {
		if(!delete.isEmpty()) {
			userService.setCardByIsArchived(0, cardId, collectionId);
		}
	}
	
//	@RequestMapping(method = RequestMethod.POST, path = "renameCardHeading")
//	public void editCardHeading(@RequestParam String heading, @RequestParam int cardId, @RequestParam int collectionId) {
//		userService.editCardHeading(heading, cardId, collectionId);
//	}
	
	@RequestMapping(method = RequestMethod.POST, path = "viewSingleCardByCardId")
	public Card viewSingleCardByCardId(@RequestParam int cardId) {
		Card card = userService.viewSingleCardByCardId(cardId);
		return card;
	}
	
	@RequestMapping(method = RequestMethod.POST, path="deleteCollection")
	public void deleteCollection(@RequestParam int userId, @RequestParam int collectionId) {
		userService.setCollectionIsArchived(1, userId, collectionId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="viewCollectionByUserId")
	public List<Collection> viewCollectionByUserId(@RequestParam int userId) {
		List<Collection> collection = userService.viewAllCollectionByUserId(userId);
		return collection;
	}
	
	@RequestMapping(method = RequestMethod.POST, path="register")
	public void addUser(@RequestParam String username, @RequestParam String password) {
		if (!username.isEmpty() && !password.isEmpty()) {
			userService.saveUser(username, password);
		} else {
			System.out.println("Please enter required fields.");
		}
	}

}
