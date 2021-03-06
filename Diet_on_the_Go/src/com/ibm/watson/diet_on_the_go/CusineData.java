package com.ibm.watson.diet_on_the_go;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CusineData implements JSONAware {

	private int id;
	private String cuisine;

	public CusineData(int id, String cuisine) {
		this.id = id;
		this.cuisine = cuisine;
	}

	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub

		JSONObject obj = new JSONObject();
		obj.put("id", Integer.valueOf(id));
		obj.put("cuisine", cuisine);

		return obj.toString();
	}
}
