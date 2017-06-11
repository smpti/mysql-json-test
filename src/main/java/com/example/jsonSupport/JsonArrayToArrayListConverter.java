package com.example.jsonSupport;

import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;

/**
 * Created by sandeep on 6/5/17.
 */

@Converter
public class JsonArrayToArrayListConverter implements AttributeConverter<ArrayList, String> {

	public String convertToDatabaseColumn(ArrayList json) {
		if (json == null) {
			return null;
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	public ArrayList convertToEntityAttribute(String jsonString) {
		if (jsonString == null){
			return null;
		}

		Gson gson = new Gson();
		ArrayList obj = gson.fromJson(jsonString, ArrayList.class);
		return obj;
	}
}

