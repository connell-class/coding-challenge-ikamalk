package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.GroceryItemDao;
import com.example.dao.GroceryListDao;
import com.example.model.GroceryItem;
import com.example.model.GroceryList;


@Service
public class GroceryListServices {
	
	@Autowired
	GroceryListDao gld;
	

	public GroceryList insert(GroceryList gl) {
		return gld.save(gl);
	}
	
	public List<GroceryList> findAll() {
		return gld.findAll();
	}
	
	public List<GroceryList> findById(Integer id) {
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(id);
		return gld.findAllById(idList);
	}
	

	public String delete(Integer id) {
		gld.deleteById(id);
		return "List deleted!";
	}
	


}
