package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.GroceryItem;


public interface GroceryItemDao extends JpaRepository<GroceryItem, Integer> {
	List<GroceryItem> findGroceryItemBygrocerylist_id(int id);
}