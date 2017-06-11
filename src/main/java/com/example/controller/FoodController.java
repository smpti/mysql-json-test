package com.example.controller;

import com.example.model.Food;
import com.example.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by sandeep on 6/11/17.
 */
@Controller
public class FoodController {

	@Autowired
	private FoodService foodService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity foodInfo() {

		List foodInfo = foodService.getAllFood();
		return new ResponseEntity (foodInfo, HttpStatus.OK);
	}

	@RequestMapping(value = "/foodByName", method = RequestMethod.GET)
	public ResponseEntity getFoodByName(@RequestParam(value ="foodName", required = true) String foodName){

		Food food = foodService.getFoodByName(foodName);
		return new ResponseEntity (food, HttpStatus.OK);

	}

}
