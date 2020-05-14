package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grocerylist")
public class GroceryList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "grocerylist", cascade = { CascadeType.ALL })
	private Set<GroceryItem> groceryitems;
	
	@Column
	private String title;
	
	@Column
	private String createdAt;
	
	public GroceryList(int id, Set<GroceryItem> groceryitems, String title, String createdAt) {
		super();
		this.id = id;
		this.groceryitems = groceryitems;
		this.title = title;
		this.createdAt = createdAt;
	}



	public GroceryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
