package com.example.dao;

import com.example.model.Food;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sandeep on 6/11/17.
 */
public interface FoodDao {
	List getListOfFood();

	Food getFoodByName(String foodName);

	List<HashMap> getFoodWithCaloriesGreater(int calories);

	List<Integer> getFoodCaloriesWithPrice(int price);
}
