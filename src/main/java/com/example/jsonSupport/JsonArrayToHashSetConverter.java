package com.example.jsonSupport;

import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashSet;

/**
 * Created by sandeep on 6/5/17.
 */

@Converter
public class JsonArrayToHashSetConverter implements AttributeConverter<HashSet, String> {

	public String convertToDatabaseColumn(HashSet json) {
		if (json == null) {
			return null;
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	public HashSet convertToEntityAttribute(String jsonString) {
		if (jsonString == null){
			return null;
		}

		Gson gson = new Gson();
		HashSet obj = gson.fromJson(jsonString, HashSet.class);
		return obj;
	}
}

