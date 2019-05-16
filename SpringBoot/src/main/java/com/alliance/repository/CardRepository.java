package com.alliance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.entity.Card;
import com.alliance.entity.Collection;

@Repository("cardRepository")
@Transactional
public interface CardRepository extends JpaRepository<Card, Integer>{
	
	//@SuppressWarnings("unchecked")
	public Card save(Card card);

	public List<Card> findAllByCollectionId(int collectionId);

	public Card findOneByCardId(int cardId);
}
