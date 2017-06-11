package com.example.jsonSupport;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * File from https://vladmihalcea.com/2016/06/20/how-to-map-json-objects-using-generic-hibernate-types/
 */
public class JsonStringType
		extends AbstractSingleColumnStandardBasicType<Object>
		implements DynamicParameterizedType {

	public JsonStringType() {
		super(
				JsonStringSqlTypeDescriptor.INSTANCE,
				new JsonTypeDescriptor()
		);
	}

	public String getName() {
		return "json";
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((JsonTypeDescriptor) getJavaTypeDescriptor())
				.setParameterValues(parameters);
	}
}