package com.ibm.watson.diet_on_the_go;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpStatus;

import android.os.AsyncTask;

public class CallChefWATSONAPI_ApplyBR extends AsyncTask<String, String, String> {
	protected String doInBackground(String... params) {

		String urlString = params[0];
		String text = "test";
		//switch (selection) {
		//case "By Style":

	try {

			// urlString =
			//		 "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/RecipeInfo?recipeid=3721&format=json";

				URL url = new URL(urlString);
				HttpURLConnection urlConnection = (HttpURLConnection) url
						.openConnection();
				int http_status = urlConnection.getResponseCode();
				//urlConnection.setReadTimeout(12 * 1000);
			if (http_status >= HttpStatus.SC_BAD_REQUEST) {
					System.out.println("HTTP Status is " + http_status);
				//	break;
				}
				try {
					//urlConnection.setReadTimeout(12 * 1000);
					InputStream in = new BufferedInputStream(
							urlConnection.getInputStream());
					text = convertInputStreamToString_Open(in);
				} finally {
					urlConnection.disconnect();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return text;

		}


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
	protected void onPostExecute(String result) {
		/*
		 * String text = null;
		 * 
		 * Intent intent;
		 */
	//	NavigationDrawerFragment.Returned_Result = result;
		Globals.Returned_Result = result;

		
		//MainActivity.Returned_Result = result;
		if (result == null) {
			result = "Please wait till the list is available.....";
			
		}
		
	}

}

