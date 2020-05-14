package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.GroceryItemDao;
import com.example.model.GroceryItem;


@Service
public class GroceryItemServices {
	@Autowired
	GroceryItemDao gid;
	
	
	public GroceryItem insert(GroceryItem gi) {
		return gid.save(gi);
	}
	public List<GroceryItem> findById(Integer id) {
		return gid.findGroceryItemBygrocerylist_id(id);
	}
	
	public String delete(Integer id) {
		gid.deleteById(id);
		return "Item deleted!";
	}
	
}
