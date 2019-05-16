package com.alliance.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;
import com.alliance.entity.User;

@Repository("cardRepository")
@Transactional
public interface CardRepository extends JpaRepository<Card, Integer>{
	

	public Card save(Card card);
	public Card findOneBycardId(int cardId);
}
