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

public class GoToCusineFromIngredients extends ActionBarActivity {
	public static final String EXTRA_MESSAGE = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_go_to_cusine_from_ingredients);
		Intent intent = getIntent();
		@SuppressWarnings("unused")
		String message = intent.getStringExtra(GoToIngredientsFromDish.EXTRA_MESSAGE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.go_to_cusine_from_ingredients, menu);
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
		CusineData jsonObject = null;
		try {
			while (iterator1.hasNext()) {
				jsonObject = (CusineData) (Object) iterator1.next();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(jsonObject.toJSONString());

				JSONObject jsonObject1 = (JSONObject) obj;

				if (jsonObject1.get("cuisine").toString().equals(item)) {

					User_Choices.cuisine = jsonObject1.get("id").toString();
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/* Go Next*/ 
	public void Apply_WATSON_BR(View view) {
		try {
			
			JSONArray msg = Globals.cuisinejson_object;
			EditText edit_text = (EditText) findViewById(R.id.cusine_entry);
			getcode(msg, edit_text.getText().toString());
			
			Intent intent = new Intent(this, Apply_WATSON_BR.class);
			/*String recipeidurl = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/RecipeInfo?recipeid=3721";
			String url_server = "http://bonapp1.sl.cloud9.ibm.com:8080";
			String url_dish =	"/jaxrs/reciperenderer/generate?dishid=" + User_Choices.dish.toString() +"&";
			String url_ingredients =	"ingredientid="+ User_Choices.ingredient1.toString()+"&";
			String url_cusine =User_Choices.cuisine.toString() + "&";
			recipeidurl = url_server + url_dish + url_ingredients +url_cusine+ "&format=json";
			*/
			intent.putExtra(EXTRA_MESSAGE, User_Choices.cuisine  );
			startActivity(intent);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}
}