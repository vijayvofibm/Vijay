package com.ibm.watson.diet_on_the_go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;

import android.os.AsyncTask;

public class CallChefWATSONAPI_GetDishList extends AsyncTask<String, String, String> {
	protected String doInBackground(String... params) {

		String text = "test";
		//switch (selection) {
		//case "By Style":

	/*		try {

			 urlString =
				 "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/DishSuggest?format=json";

				URL url = new URL(urlString);
				HttpURLConnection urlConnection = (HttpURLConnection) url
						.openConnection();
				int http_status = urlConnection.getResponseCode();
				urlConnection.setReadTimeout(1200 * 10000);
			if (http_status >= HttpStatus.SC_BAD_REQUEST) {
					System.out.println("HTTP Status is " + http_status);
				//	break;
				}
				try {
					urlConnection.setReadTimeout(1200 * 1000);
					InputStream in = new BufferedInputStream(
							urlConnection.getInputStream());
					text = convertInputStreamToString_Open(in);
				} finally {
					urlConnection.disconnect();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			return text;

		}


	@SuppressWarnings("unused")
	private String convertInputStreamToString_Open(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";

		while ((line = bufferedReader.readLine()) != null) {
			result += line;
		}
		// inputStream.close();

		return result;
	}
	@SuppressWarnings("unchecked")
	public static String create_dish()
	{
		String json_string = "DUMMY";
		  JSONArray data = new JSONArray();
		
		  data.add(new DishData(17013,"dinner"));
		  data.add(new DishData(16562,"breakfast"));
		  data.add(new DishData(16472,"soup"));
		  data.add(new DishData(16475,"cookie"));
		  data.add(new DishData(19081,"lunch"));
		  data.add(new DishData(18633,"supper"));
		  data.add(new DishData(18519,"beverage"));
		  data.add(new DishData(21469,"hot"));
		  data.add(new DishData(16929,"fritatta"));
		

		  Globals.dishjson_object = data;
		  
	return json_string;	
	}
	protected void onPostExecute(String result) {
	
		Globals.Returned_Dish_List = create_dish();
	
		if (result == null) {
			result = "Please wait till the list is available.....";
			
		}
		
	}

}

