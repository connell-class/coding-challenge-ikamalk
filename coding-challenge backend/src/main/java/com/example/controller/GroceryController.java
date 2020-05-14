package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.GroceryItem;
import com.example.model.GroceryList;
import com.example.service.GroceryItemServices;
import com.example.service.GroceryListServices;

@RestController
@RequestMapping("/grocerylist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GroceryController {
	
	@Autowired
	GroceryListServices gls;
	@Autowired
	GroceryItemServices gis;
	
	@GetMapping
	public List<GroceryList> List() {
		return gls.findAll();
	}
	
	@PostMapping
	public GroceryList insert(@RequestBody GroceryList gl) {
		return gls.insert(gl);
	}
	
	@PostMapping("/item")
	public GroceryItem insert(@RequestBody GroceryItem gl) {
		return gis.insert(gl);
	}
	
	@GetMapping("/{id}")
	public List<GroceryItem> ListItem(@PathVariable("id") int id) {
		return gis.findById(id);
	}
	
	@DeleteMapping("item/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		return gis.delete(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteList(@PathVariable("id") int id) {
		return gls.delete(id);
	}
}
