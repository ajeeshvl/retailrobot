package com.infosys.retailrobot.driver;

import java.util.ArrayList;
import java.util.List;

import com.infosys.retailrobot.gherkin.Element;
import com.infosys.retailrobot.gherkin.Feature;
import com.infosys.retailrobot.gherkin.GherkinMapper;
import com.infosys.retailrobot.gherkin.Step;
import com.infosys.retailrobot.objects.ObjectMap;
import com.infosys.retailrobot.objects.ObjectMapper;
import com.infosys.retailrobot.utils.LogHelper;
import com.infosys.retailrobot.webdriver.Actions;

public class GherkinDriver {

	public static void main(String[] args) throws Exception {

		// System.out.println(args[0]);
		String featurePath = "src/main/resources/search.feature";
		GherkinMapper g = new GherkinMapper();
		Command commandParsed = null;
		List<Command> commandsList = new ArrayList<Command>();
		Feature feature = g.mapFeatureToObject(featurePath);
		System.out.println(feature.getDescription());

		// iterate each step and separate actions and objects
		for (Element element : feature.getElements()) {
			for (Step step : element.getSteps()) {
				System.out.println("Step Parsing: " + step.getName());
				commandParsed = StepParser.convertToCommand(step.getName());

				System.out.println("Parsed Steps: " + commandParsed.getName() + " " + commandParsed.getObject() + " "
						+ commandParsed.getValue() + "\n");
				commandsList.add(commandParsed);
			}
		}
		Actions.startDriver("http://www.sears.com");
		testRunner(commandsList);
		Actions.driver.quit();
	}

	static void testRunner(List<Command> commandsList) throws InterruptedException {
		// Iterate through each step and do the execution
		for (Command command : commandsList) {
			ActionsEnum enumval = ActionsEnum.valueOf(command.getName());
			switch (enumval) {
			case fill: {
				Actions.type(command.getObject(), command.getValue());
				break;
			}
			case click: {
				Actions.click(command.getObject());
				break;
			}
			case verify: {
				Actions.verify(command.getObject());
				break;
			}
			default:
				break;
			}

		}

	}
}
