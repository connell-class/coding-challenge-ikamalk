package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="groceryitem")
public class GroceryItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String content;
	@OnDelete(action = OnDeleteAction.CASCADE)

	@ManyToOne
	@JoinColumn(name = "grocerylist_id")
	private GroceryList grocerylist;

	public GroceryItem(int id, String type, String content, GroceryList grocerylist) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.grocerylist = grocerylist;
	}

	public GroceryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GroceryList getGrocerylist() {
		return grocerylist;
	}

	public void setGrocerylist(GroceryList grocerylist) {
		this.grocerylist = grocerylist;
	}


	
	

}
