package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ex.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	public Item findByName(String name);
	
	@Modifying
	@Query("update Item i set i.description = ?1, i.price = ?2 where i.name = ?3")
	public void updateItem(String description,double price,String name);
}
