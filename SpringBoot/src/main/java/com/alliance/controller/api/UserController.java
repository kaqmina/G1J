package com.alliance.controller.api;

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
	
	@RequestMapping(method = RequestMethod.POST, path = "addCard")
	public void addCard(@RequestParam String heading, @RequestParam String desc, @RequestParam int collectionId) {
		userService.saveCard(heading, desc, collectionId);
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
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/{cardId}")
	public Card viewCard(@PathVariable(name = "cardId") int cardId) {
		//userService.saveCollection(userId,name);
			return userService.viewCardById(cardId);
		}

	@RequestMapping(method = RequestMethod.POST, path = "editCardDesc")
	public void editCardDesc(@RequestParam int id, @RequestParam String desc) {
		userService.saveCardDesc(id, desc);

	}
	


}
