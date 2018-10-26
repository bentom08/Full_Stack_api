package com.qa.JSON_api.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;
	
	public JSONUtil() {
		this.gson = new Gson();
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}
	
	public <T> T getObjectForJSON(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
