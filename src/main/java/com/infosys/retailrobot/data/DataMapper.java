package com.infosys.retailrobot.data;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.infosys.retailrobot.utils.HttpClient;

public class DataMapper {

	public DataMap mapDataToObject(String _dataName) {
		String json = "";
		DataMap object;
		if (_dataName.contains("$")) {
			try {
				json = HttpClient.invokeEndPoint("http://localhost:5984/retail_data_bank/" + _dataName.replace("$",""), "GET", "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new Gson();
			object = gson.fromJson(json, new TypeToken<DataMap>() {
			}.getType());

		}else
		{
			object = new DataMap();
			object.setValue(_dataName.replaceAll("$", ""));
		}
		return object;
	}

}
