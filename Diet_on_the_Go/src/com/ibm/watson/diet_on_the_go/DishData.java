package com.ibm.watson.diet_on_the_go;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 * @author vijayv
 * 
 */

public class DishData implements JSONAware {
	private int id;
	private String dish;

	public DishData(int id, String dish) {
		this.id = id;
		this.dish = dish;
	}

	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub

		JSONObject obj = new JSONObject();
		obj.put("id", Integer.valueOf(id));
		obj.put("dish", dish);

		return obj.toString();
	}

}
