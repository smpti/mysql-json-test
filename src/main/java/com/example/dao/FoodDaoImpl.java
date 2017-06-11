package com.example.dao;

import com.example.model.Food;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sandeep on 6/11/17.
 */

@Component
public class FoodDaoImpl implements FoodDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List getListOfFood() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Food.class);
		return criteria.list();
	}

	@Override
	public Food getFoodByName(String foodName) {
		String nativeSql = "Select f.* from food f where f.name = :foodName";
		SQLQuery query = entityManager.unwrap(Session.class).createSQLQuery(nativeSql);
		query.setParameter("foodName", foodName);
		query.addEntity(Food.class);
		List<Food> food = query.list();
		return food.get(0);
	}

	@Override
	public List<HashMap> getFoodWithCaloriesGreater(int calories) {


//		List<Food> foodWithHigherCalories = entityManager.createNativeQuery(
//				"SELECT f.nutrition -> '$.ingredients.\\\"calories\\\"' FROM food f WHERE " +
//				"JSON_EXTRACT(f.nutrition, '$.ingredients.\\\"calories\\\"') > :calories")
		List<HashMap> foodWithHigherCalories = entityManager.createNativeQuery(
				"SELECT f.nutrition FROM food f WHERE " +
						"JSON_EXTRACT(f.nutrition, '$.ingredients.\\\"calories\\\"') > :calories")
				.setParameter("calories", calories)
				.getResultList();
		return foodWithHigherCalories;
	}

	@Override
	public List<Integer> getFoodCaloriesWithPrice(int price) {


		//		List<Food> foodWithHigherCalories = entityManager.createNativeQuery(
		//				"SELECT f.nutrition -> '$.ingredients.\\\"calories\\\"' FROM food f WHERE " +
		//				"JSON_EXTRACT(f.nutrition, '$.ingredients.\\\"calories\\\"') > :calories")
		List<Integer> foodWithHigherCalories = entityManager.createNativeQuery(
				"select f.nutrition ->> '$.ingredients.\\\"calories\\\"' from food f where " +
						"JSON_EXTRACT(f.nutrition, '$.\\\"priceInDollars\\\"') = :price")
				.setParameter("price", price)
				.getResultList();
		return foodWithHigherCalories;
	}


}
