package com.example.service;

import com.example.dao.FoodDao;
import com.example.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sandeep on 6/11/17.
 */

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;


	@Override
	public List getAllFood() {
		return foodDao.getListOfFood();
	}

	@Override
	public Food getFoodByName(String foodName) {
		return foodDao.getFoodByName(foodName);
	}

	@Override
	public List<HashMap> getFoodWithCaloriesGreater(int calories) {
		return foodDao.getFoodWithCaloriesGreater(calories);
	}

}