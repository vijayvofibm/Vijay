package com.ibm.watson.diet_on_the_go;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = null;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call_All_WATSON_API();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public void Call_All_WATSON_API()
    {
    	String urlString = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/DishSuggest?format=json";
		String mTitle = "By Dish";

		try {
			new CallChefWATSONAPI_GetDishList().execute(urlString, mTitle);
			//Toast.makeText(getApplicationContext(), Globals.Returned_Result,Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 urlString = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/IngredientSuggest?format=json";
		 mTitle = "By Ingredient";

		try {
			new CallWATSONAPI_GetIngredientsList().execute(urlString, mTitle);
			//Toast.makeText(getApplicationContext(), Globals.Returned_Result,Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 urlString = "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/CuisineSuggest?format=json";
		 mTitle = "By Style";

		try {
			new CallWATSONAPI_GetCusinesList().execute(urlString, mTitle);
			//Toast.makeText(getApplicationContext(), Globals.Returned_Result,Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

	/* Go Next */
	public void GoToDish(View view) {
		try {

			
			String msg = "Yes";
			Intent intent = new Intent(this, GoToDish.class);
			intent.putExtra(EXTRA_MESSAGE, msg);
			startActivity(intent);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	}

   public void check_diet_restrictions(View view){
	   try {

			
			String msg = "Yes";
			Intent intent = new Intent(this, Set_DIET_Restrictions.class);
			intent.putExtra(EXTRA_MESSAGE, msg);
			startActivity(intent);

		} catch (Exception ex) {

			ex.printStackTrace();

		}
   }
	/* Exit */
	public void Exit(View view) {
		}

}
