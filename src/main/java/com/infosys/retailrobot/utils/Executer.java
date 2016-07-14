package com.infosys.retailrobot.utils;

import java.util.List;
import com.infosys.retailrobot.entities.Command;

public class Executer {
	public void executeTest(List<Command> commands){
		for(Command command: commands){
			if("fill" == (command.getName().toLowerCase())){
				System.out.println("THere is  Fill commdn");
			}
		}
	}
}
