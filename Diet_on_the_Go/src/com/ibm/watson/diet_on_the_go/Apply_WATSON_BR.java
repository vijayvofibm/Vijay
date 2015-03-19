package com.ibm.watson.diet_on_the_go;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import android.support.v7.app.ActionBarActivity;
import android.text.method.LinkMovementMethod;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Apply_WATSON_BR extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply__watson__br);
		Intent intent = getIntent();
		String message = intent
				.getStringExtra(GoToCusineFromIngredients.EXTRA_MESSAGE);

		// String recipeidurl =
		// "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/RecipeInfo?recipeid=3721";
		String url_server = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/reciperenderer/generate?";
		String url_dish = "dishid=" + User_Choices.dish.toString() + "&";
		String url_ingredients = "ingredientid="
				+ User_Choices.ingredient1.toString() + "&";
		if (User_Choices.ingredient2 != null) {
			url_ingredients = url_ingredients
					+ User_Choices.ingredient2.toString() + "&";
		}
		String url_cusine = "cusine=" + User_Choices.cuisine.toString() + "&";
		String recipeidurl = url_server + url_dish + url_ingredients
				+ url_cusine + "&format=json";

		Toast.makeText(this.getApplicationContext(), recipeidurl,
				Toast.LENGTH_LONG).show();

		new CallChefWATSONAPI_ApplyBR().execute(recipeidurl, message);
		message = Globals.Returned_Result;
		if (Globals.Returned_Result == null) {
			Globals.Returned_Result = recipeidurl;
		}
		this.getWindow().findViewById(R.id.button1).bringToFront();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apply__watson__br, menu);
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

	public void apply_watson_br(View tv) {
		String message = Globals.Returned_Result;

		if (Globals.Returned_Result == null) {
			message = "Please wait for few more moments...and click on the GoWATSONbutton again";
		} else {
			message = Globals.Returned_Result;
		}
		TextView textView = (TextView) findViewById(R.id.textView1);
		

//		setContentView(textView);

		// textView.setText(message);

		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(message);

			JSONObject jsonObject = (JSONObject) obj;
			JSONObject jsonObject1 = (JSONObject) jsonObject.get("response");

			JSONArray msg = (JSONArray) jsonObject1.get("data");

			long total_rows = (Long) jsonObject1.get("totalRows");
			// loop array
			try {
				String url = populateOptions(msg, total_rows);
				
				textView.setText(url);
				textView.setMovementMethod(LinkMovementMethod.getInstance());

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String populateOptions(JSONArray msg, long total_rows) {
		// @SuppressWarnings("unchecked")
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> iterator1 = msg.iterator();
		String testing = "";
		try {
			while (iterator1.hasNext()) {

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(iterator1.next().toString());
				JSONObject jsonObject = (JSONObject) obj;
				if (jsonObject.get("sourceurl") == null) {
					testing = testing + "";// + "no source url";

				} else {
					testing = jsonObject.get("sourceurl").toString();
				}

				if (jsonObject.get("recipeid") == null) {
					testing = testing + "";// + "no recipeid";;
				} else {
					// testing = testing +
					// jsonObject.get("recipeid").toString();
					testing = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/RecipeInfo?recipeid="
							+ jsonObject.get("recipeid").toString()
							+ "&format=json";
					new CallChefWATSONAPI_ApplyBR().execute(testing,
							"sourceurl_links");

					testing = get_sourceurl(Globals.Returned_Result);

				}

				if (jsonObject.get("templates") == null) {
					testing = testing + "";// + "no templates";

				} else {
					testing = testing + jsonObject.get("templates").toString();
				}

				if (jsonObject.get("stepsText") == null) {
					testing = testing + "";// + "no steps";

				} else {
					testing = testing + jsonObject.get("stepsText").toString();
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println(testing);
		if (testing == "") {
			return Globals.Returned_Result;

		} else {
			return testing;
		}
	}

	public String get_sourceurl(String sourceurl) {
		String links = "";
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(sourceurl);
			JSONObject jsonObject = (JSONObject) obj;
			links = jsonObject.get("sourceurl").toString();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return links;
	}

}
