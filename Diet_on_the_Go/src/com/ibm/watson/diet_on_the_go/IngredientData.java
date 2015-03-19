package com.ibm.watson.diet_on_the_go;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class IngredientData  implements JSONAware{

    private int id;
    private String ingredient;
    
    public IngredientData(int id, String ingredient){
        this.id = id;
        this.ingredient = ingredient;
}
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		
		JSONObject obj = new JSONObject();
		  obj.put("id", Integer.valueOf(id));
		obj.put("ingredient", ingredient);
	  
	    return obj.toString();
	}
}
