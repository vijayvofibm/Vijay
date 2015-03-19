package com.ibm.watson.diet_on_the_go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import android.os.AsyncTask;

public class CallWATSONAPI_GetCusinesList extends AsyncTask<String, String, String> {
	@SuppressWarnings("unused")
	protected String doInBackground(String... params) {

		String urlString = params[0];
		String text = "test";
		//switch (selection) {
		//case "By Style":
/*
			try {

			 urlString =
				 "http://bonapp1.sl.cloud9.ibm.com:8080/IronChefUI/jaxrs/query/CuisineSuggest?format=json";

				URL url = new URL(urlString);
				HttpURLConnection urlConnection = (HttpURLConnection) url
						.openConnection();
				int http_status = urlConnection.getResponseCode();
				urlConnection.setReadTimeout(120 * 10000);
			if (http_status >= HttpStatus.SC_BAD_REQUEST) {
					System.out.println("HTTP Status is " + http_status);
				//	break;
				}
				try {
					urlConnection.setReadTimeout(120 * 1000);
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
	@SuppressWarnings({ "unused", "unchecked" })
	public static String create_simple_json()
	{
		String json_string = "DUMMY";
		  JSONArray data = new JSONArray();
		  JSONObject obj=new JSONObject();
		/*  obj.put("dish",new String("topping"));	obj.put("id",new Integer(16466));	json_string = json_string + obj.toJSONString() ; 
		  obj.put("dish",new String("dip"));	obj.put("id",new Integer(16468));	json_string = json_string + obj.toJSONString() ;
		  obj.put("dish",new String("non"));	obj.put("id",new Integer(16468));	json_string = json_string + obj.toJSONString() ;
		  obj.put("dish",new String("soup"));	obj.put("id",new Integer(16472));	json_string = json_string + obj.toJSONString() ;
		  obj.put("dish",new String("cookie"));	obj.put("id",new Integer(16475));	json_string = json_string + obj.toJSONString() ;
		 */
		  data.add(new CusineData(34,"african"));
		  data.add(new CusineData(83,"american"));
		  data.add(new CusineData(116,"anniversary"));
		  data.add(new CusineData(161,"argentine"));
		  data.add(new CusineData(183,"asian"));
		  data.add(new CusineData(197,"austrian"));
		  data.add(new CusineData(232,"back to school"));
		  data.add(new CusineData(312,"basque"));
		  data.add(new CusineData(315,"bastille day"));
		  data.add(new CusineData(374,"belgian"));
		  data.add(new CusineData(400,"birthday"));
		  data.add(new CusineData(548,"bridal shower"));
		  data.add(new CusineData(561,"british"));
		  data.add(new CusineData(570,"brooklyn"));
		  data.add(new CusineData(648,"cajun"));
		  data.add(new CusineData(662,"cali persian"));
		  data.add(new CusineData(663,"california"));
		  data.add(new CusineData(680,"canadian"));
		  data.add(new CusineData(736,"caribbean"));
		  data.add(new CusineData(920,"chinese"));
		  data.add(new CusineData(926,"chinese new year"));
		  data.add(new CusineData(983,"christmas"));
		  data.add(new CusineData(1101,"comfort"));
		  data.add(new CusineData(1272,"creole"));
		  data.add(new CusineData(1311,"cuban"));
		  data.add(new CusineData(1359,"danish"));
		  data.add(new CusineData(1410,"diner"));
		  data.add(new CusineData(1448,"diwali"));
		  data.add(new CusineData(1527,"easter"));
		  data.add(new CusineData(1528,"eastern european"));
		  data.add(new CusineData(1543,"edible gift"));
		  data.add(new CusineData(1580,"engagement"));
		  data.add(new CusineData(1583,"english"));
		  data.add(new CusineData(1592,"english scottish"));
		  data.add(new CusineData(1621,"fall"));
		  data.add(new CusineData(1633,"family reunion"));
		  data.add(new CusineData(1654,"fathers day"));
		  data.add(new CusineData(1763,"fourth of july"));
		  data.add(new CusineData(1772,"french"));
		  data.add(new CusineData(1862,"galician"));
		  data.add(new CusineData(1906,"german"));
		  data.add(new CusineData(1972,"graduation"));
		  data.add(new CusineData(2019,"greek"));
		  data.add(new CusineData(2133,"halloween"));
		  data.add(new CusineData(2167,"hawaiian"));
		  data.add(new CusineData(2257,"holidays"));
		  data.add(new CusineData(2374,"indian"));
		  data.add(new CusineData(2385,"irish"));
		  data.add(new CusineData(2390,"israeli"));
		  data.add(new CusineData(2391,"italian"));
		  data.add(new CusineData(2392,"italian american"));
		  data.add(new CusineData(2414,"jamaican"));
		  data.add(new CusineData(2420,"japanese"));
		  data.add(new CusineData(2519,"korean"));
		  data.add(new CusineData(2537,"labor day"));
		  data.add(new CusineData(2573,"latin american"));
		  data.add(new CusineData(2711,"lunar new year"));
		  data.add(new CusineData(2761,"maine"));
		  data.add(new CusineData(2766,"malaysian"));
		  data.add(new CusineData(2798,"march meals"));
		  data.add(new CusineData(2800,"mardi gras"));
		  data.add(new CusineData(2881,"mediterranean"));
		  data.add(new CusineData(2892,"memorial day"));
		  data.add(new CusineData(2896,"mexican"));
		  data.add(new CusineData(2917,"middle eastern"));
		  data.add(new CusineData(2987,"moroccan"));
		  data.add(new CusineData(2993,"mothers day"));
		  data.add(new CusineData(3039,"nashville"));
		  data.add(new CusineData(3052,"new england"));
		  data.add(new CusineData(3054,"new orleans"));
		  data.add(new CusineData(3058,"new year's day"));
		  data.add(new CusineData(3062,"new years eve"));
		  data.add(new CusineData(3101,"north african"));
		  data.add(new CusineData(3103,"north carolina"));
		  data.add(new CusineData(3111,"nuevo latino"));
		  data.add(new CusineData(3144,"oktoberfest"));
		  data.add(new CusineData(3301,"party"));
		  data.add(new CusineData(3413,"persian"));
		  data.add(new CusineData(3418,"peruvian"));
		  data.add(new CusineData(3601,"portland"));
		  data.add(new CusineData(3609,"portuguese"));
		  data.add(new CusineData(3670,"provencal"));
		  data.add(new CusineData(3685,"puglian"));
		  data.add(new CusineData(3934,"russian"));
		  data.add(new CusineData(3956,"saint patricks day"));
		  data.add(new CusineData(3989,"san francisco"));
		  data.add(new CusineData(4038,"scandinavian"));
		  data.add(new CusineData(4053,"scottish"));
		  data.add(new CusineData(4150,"sichuan"));
		  data.add(new CusineData(4238,"soul"));
		  data.add(new CusineData(4259,"south american"));
		  data.add(new CusineData(4264,"southeast asian"));
		  data.add(new CusineData(4266,"southern"));
		  data.add(new CusineData(4277,"southwestern"));
		  data.add(new CusineData(4293,"spanish"));
		  data.add(new CusineData(4337,"spring"));
		  data.add(new CusineData(4447,"summer"));
		  data.add(new CusineData(4484,"superbowl"));
		  data.add(new CusineData(4537,"tailgating"));
		  data.add(new CusineData(4587,"tex mex"));
		  data.add(new CusineData(4590,"texas"));
		  data.add(new CusineData(4591,"thai"));
		  data.add(new CusineData(4600,"thanksgiving"));
		  data.add(new CusineData(4782,"turkish"));
		  data.add(new CusineData(4790,"tuscan"));
		  data.add(new CusineData(4808,"valentines day"));
		  data.add(new CusineData(4876,"vietnamese"));
		  data.add(new CusineData(4918,"wedding"));
		  data.add(new CusineData(4994,"winter"));
		  data.add(new CusineData(5025,"yard to table"));

		  
		  Globals.cuisinejson_object = data;
		  
	return json_string;	
	}
	
	protected void onPostExecute(String result) {
		/*
		 * String text = null;
		 * 
		 * Intent intent;
		 */
	//	NavigationDrawerFragment.Returned_Result = result;
		//Globals.Returned_Result = result;
		Globals.Returned_Cusine_List = create_simple_json();
		//MainActivity.Returned_Result = result;
		if (result == null) {
			result = "Please wait till the list is available.....";
			
		}
		
	}

}

