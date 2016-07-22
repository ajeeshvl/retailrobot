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

public class GherkinDriver {
	
	public static void main(String[] args) throws Exception {
		
		String featurePath = "src/main/resources/login.feature";
		GherkinMapper g = new GherkinMapper();
		Command command = null;
		List<Command> commandsList= new ArrayList<Command>();
		Feature feature = g.mapFeatureToObject(featurePath);
		System.out.println(feature.getDescription());

		// iterate each step and map in a list
		for (Element element : feature.getElements()) {
			for (Step step : element.getSteps()) {
				System.out.println("Step Parsing: "+step.getName());
				command = StepParser.convertToCommand(step.getName());
				 
				System.out.println("Parsed Steps: "+command.getName()  +" "+command.getObject()+" "+command.getValue()+"\n");
				commandsList.add(command);
			}
		}
		
		// Iterate each step and do the execution
		for(Command parsedcommand: commandsList){
			System.out.println(parsedcommand.getName());
			if(parsedcommand.getName().toLowerCase().equals("fill")){
				LogHelper.log("Fill Command");

			}
		}

		 ObjectMap o=new ObjectMapper().mapUIObjectToObject("btn_login");
		 System.out.println(o.getRev());
	}
}
