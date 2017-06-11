package com.example.jsonSupport;

import com.google.gson.Gson;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.LinkedHashMap;

/**
 * Created by sandeep on 6/5/17.
 */

@Converter
public class JsonObjectToLinkedHashMapConverter implements AttributeConverter<LinkedHashMap, String> {

	public String convertToDatabaseColumn(LinkedHashMap json) {
		if (json == null) {
			return null;
		}
		Gson gson = new Gson();
		return gson.toJson(json);
	}

	public LinkedHashMap convertToEntityAttribute(String jsonString) {
		if (jsonString == null){
			return null;
		}

		Gson gson = new Gson();
		LinkedHashMap obj = gson.fromJson(jsonString, LinkedHashMap.class);
		return obj;
	}
}

