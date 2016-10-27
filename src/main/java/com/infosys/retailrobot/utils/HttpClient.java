package com.infosys.retailrobot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {
	public static String invokeEndPoint(String uri, String requestMethod,
		String requestBody) throws Exception {
		int responseCode=0;
		HttpURLConnection connection=null;
		StringBuilder response = new StringBuilder();
		try {
			URL url = new URL(uri);
			connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod(requestMethod);
			if(requestMethod.equals("POST")){
				connection.setRequestProperty("Accept", "application/json");
				connection.setDoOutput(true);
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(requestBody.getBytes());
				outputStream.flush();
			}
			BufferedReader responseBuffer = 
					new BufferedReader(
					new InputStreamReader(

					(connection.getInputStream())));
			responseCode = connection.getResponseCode(); 
			String output;
			while ((output = responseBuffer.readLine()) != null) {
				response.append(output);
			}

			connection.disconnect();
		} catch (Exception e) {

			e.printStackTrace();

		} 
		return response.toString();
		
	}
}
