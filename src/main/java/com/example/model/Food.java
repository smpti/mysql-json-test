package com.example.model;

import com.example.jsonSupport.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.HashMap;

/**
 * Created by sandeep on 6/11/17.
 */
@TypeDefs({
		@TypeDef(name = "json", typeClass = JsonStringType.class),
})
@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Type(type = "json")
	@Column(columnDefinition = "json")
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
