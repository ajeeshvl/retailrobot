package com.infosys.retailrobot.objects;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.infosys.retailrobot.utils.HttpClient;

public class ObjectMapper {
	
	public ObjectMap mapUIObjectToObject(String _objectName){
		String json ="";
		try {
			json = HttpClient.invokeEndPoint("http://10.11.160.143:5984/retail_object_bank/"+_objectName, "GET", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		ObjectMap object = gson.fromJson(json,
				new TypeToken<ObjectMap>() {
				}.getType());

		return object;
	}

}
