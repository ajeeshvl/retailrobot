package com.infosys.retailrobot.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepParser {

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
			//e.printStackTrace();
		}
		return command;
	}

}
