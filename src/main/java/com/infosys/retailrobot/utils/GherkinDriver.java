package com.infosys.retailrobot.utils;

import java.util.ArrayList;
import java.util.List;

import com.infosys.retailrobot.entities.Command;
import com.infosys.retailrobot.entities.Element;
import com.infosys.retailrobot.entities.Feature;
import com.infosys.retailrobot.entities.Step;

public class GherkinDriver {
	
	public static void main(String[] args) {
		
		String featurePath = "src/main/resources/login.feature";
		GherkinMapper g = new GherkinMapper();
		Command command = null;
		List<Command> commandsList= new ArrayList<Command>();
		Feature feature = g.getFeature(featurePath);
		System.out.println(feature.getDescription());

		for (Element element : feature.getElements()) {
			for (Step step : element.getSteps()) {
				System.out.println("Step Parsing: "+step.getName());
				command = StepParser.convertToCommand(step.getName());
				 System.out.println("Parsed Steps: "+command.getName()  +" "+command.getObject()+" "+command.getValue()+"\n");
				commandsList.add(command);
			}
		}
		new Executer().executeTest(commandsList);
//		 Command c=StepParser.convertToCommand("");
//		 System.out.println(""c.getName()  +" "+c.getObject()+" "+c.getValue());
	}
}
