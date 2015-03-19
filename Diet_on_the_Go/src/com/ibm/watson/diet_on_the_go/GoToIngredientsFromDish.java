package com.ibm.watson.diet_on_the_go;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class GoToIngredientsFromDish extends ActionBarActivity {

	public static final String EXTRA_MESSAGE = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_go_to_ingredients_from_dish);
		Intent intent = getIntent();
		@SuppressWarnings("unused")
		String message = intent.getStringExtra(GoToDish.EXTRA_MESSAGE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.go_to_ingredients_from_dish, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void getcode(JSONArray msg, String item) {
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator1 = msg.iterator();
		//String code = "";
		IngredientData jsonObject = null;
		try {
			while (iterator1.hasNext()) {
				jsonObject = (IngredientData) (Object) iterator1.next();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(jsonObject.toJSONString());

				JSONObject jsonObject1 = (JSONObject) obj;

				if (jsonObject1.get("ingredient").toString().equals(item)) {

					User_Choices.ingredient1 = jsonObject1.get("id").toString();
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* Go Next */
	public void GoToCusineFromIngredients(View view) {
		try {
			JSONArray msg = Globals.ingredientjson_object;
			EditText edit_text = (EditText) findViewById(R.id.ingredients_entry);
				
			getcode(msg, edit_text.getText().toString());
			Intent intent = new Intent(this, GoToCusineFromIngredients.class);
			
			intent.putExtra(EXTRA_MESSAGE, User_Choices.ingredient1);
			startActivity(intent);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}
}
