package com.example.dao;

import com.example.model.Food;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Food.class);

		String nativeSql = "Select f.* from food f where f.name = :foodName";
		SQLQuery query = entityManager.unwrap(Session.class).createSQLQuery(nativeSql);
		query.setParameter("foodName", foodName);
		query.addEntity(Food.class);
		List<Food> food = query.list();
		return food.get(0);
	}

}
