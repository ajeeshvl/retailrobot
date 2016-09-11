package com.infosys.retailrobot.driver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.infosys.retailrobot.gherkin.Element;
import com.infosys.retailrobot.gherkin.Feature;
import com.infosys.retailrobot.gherkin.Step;

public class Parser {

	public static Command convertToCommand(String line) {
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(line);
		Command command = new Command();
		List<String> matches = new ArrayList<String>();
		while (m.find()) {
			matches.add(m.group(1));
		}
		try {
			command.setName(matches.get(0));
			command.setObject(matches.get(1));
			command.setValue(matches.get(2));
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return command;
	}

	public static String convertToFeature(String line) {
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		Matcher m = p.matcher(line);
		List<String> matches = new ArrayList<String>();
		while (m.find()) {
			matches.add(m.group(1));
		}
		return matches.get(0);
	}

	public static List<Command> getStepCommands(Feature feature) {

		System.out.println(feature.getDescription());
		List<Command> commandsList = new ArrayList<Command>();
		Command commandParsed = null;
		// iterate each step and separate actions and objects
		for (Element element : feature.getElements()) {
			for (Step step : element.getSteps()) {
				System.out.println("Step Parsing: " + step.getName());
				commandParsed = convertToCommand(step.getName());

				System.out.println("Parsed Steps: " + commandParsed.getName() + " " + commandParsed.getObject() + " "
						+ commandParsed.getValue() + "\n");
				commandsList.add(commandParsed);
			}

		}
		return commandsList;
	}

	public static List<String> getSubFeatures(Feature _feature) {
		System.out.println(_feature.getDescription());
		List<String> featureList = new ArrayList<String>();
		for (Element element : _feature.getElements()) {
			for (Step step : element.getSteps()) {
				if (step.getName().contains("\"")) {
					String featureParsed = convertToFeature(step.getName());
					featureList.add(featureParsed);
				}
			}
		}
		return featureList;
	}

}
