package com.infosys.retailrobot.gherkin;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import gherkin.formatter.JSONFormatter;
import gherkin.parser.Parser;
import gherkin.util.FixJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class GherkinMapper{

	long startTime = System.currentTimeMillis();

	public Feature mapFeatureToObject(String fPath) {
		String gherkin = null;
		try {
			gherkin = FixJava.readReader(new InputStreamReader(
					new FileInputStream(fPath), "UTF-8"));
		} catch (FileNotFoundException e) {
			System.out.println("Feature file not found");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		StringBuilder json = new StringBuilder();
		JSONFormatter formatter;
		formatter = new JSONFormatter(json);

		Parser parser = new Parser(formatter);
		parser.parse(gherkin, fPath, 0);

		formatter.done();
		formatter.close();
		System.out.println("json output: " + json);
		Gson gson = new Gson();
		List<Feature> features = gson.fromJson(json.toString(),
				new TypeToken<List<Feature>>() {
				}.getType());
		return features.get(0);
		
	}

	
	public void writeJsonToFile(String jPath, String json){
		try {
			FileWriter file = new FileWriter(jPath);
			file.write(json.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
