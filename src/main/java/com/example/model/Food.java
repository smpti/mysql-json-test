package com.example.model;

import com.example.jsonSupport.JsonObjectToLinkedHashMapConverter;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by sandeep on 6/11/17.
 */

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Convert(converter = JsonObjectToLinkedHashMapConverter.class)
	private HashMap nutrition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap getNutrition() {
		return nutrition;
	}

	public void setNutrition(HashMap nutrition) {
		this.nutrition = nutrition;
	}
}
