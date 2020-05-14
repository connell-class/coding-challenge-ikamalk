package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.GroceryItem;
import com.example.model.GroceryList;


public interface GroceryListDao extends JpaRepository<GroceryList, Integer> {

}
