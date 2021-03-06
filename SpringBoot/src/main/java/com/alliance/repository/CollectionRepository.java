package com.alliance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alliance.entity.Collection;

@Repository("collectionRepository")
@Transactional
public interface CollectionRepository extends JpaRepository<Collection, Integer>{
	
	public Collection save(Collection collection);
	//public int findOneById(Integer collectionId);
	public String findByName(String name);
	public List<Collection> findAllByUserIdAndIsArchived(int userId, int isArchived);
	
	public Collection findByCollectionIdAndUserId(int collectionId, int userId);
	public List<Collection> findAllByUserIdAndCollectionIdAndIsArchived(int userId, int collectionId, int isArchived);

}
