package com.infosys.retailrobot.driver;

import java.io.File;
import java.util.List;

import com.infosys.retailrobot.gherkin.Feature;
import com.infosys.retailrobot.gherkin.GherkinMapper;
import com.infosys.retailrobot.utils.FileManage;
import com.infosys.retailrobot.utils.LogHelper;
import com.infosys.retailrobot.webdriver.TestContext;
import com.infosys.retailrobot.webdriver.UIActions;;

public class Executer {
	
	public static void main(String[] args) throws Exception {
		Config.BaseURI = args[0];
		// Get all master feature files
		File[] masterFeatureFiles=FileManage.getAllFeatures("src/main/resources");
		for(File masterFeatureFile:masterFeatureFiles){
			Executer.featureRunner(masterFeatureFile.toString());
		}
		getActions().quit();
		LogHelper.log("Retail Website: "+Config.BaseURI+" verification completed successfully");
	}
	public static UIActions getActions() {
		return TestContext.get().getActions();
	}

	static void featureRunner(String subfeatureName) throws Exception {

		Feature feature = GherkinMapper.mapFeatureToObject(subfeatureName.toString());
		List<Command> commandsList = Parser.getStepCommands(feature);
		// WebDriver driver = WebDriverFactory.getDriver();
		getActions().navigate(Config.BaseURI);

		// Iterate through each step and do the execution
		ActionsEnum enumval = ActionsEnum.NoValue;
		for (Command command : commandsList) {
			if (command.getName() != null)
				enumval = ActionsEnum.valueOf(command.getName());
			else 
				enumval = ActionsEnum.NoValue;
			switch (enumval) {
			case type: {
				getActions().type(command.getObject(), command.getValue());
				break;
			}
			case click: {
				getActions().click(command.getObject());
				break;
			}
			case clickIfFound: {
				getActions().clickIfFound(command.getObject());
				break;
			}
			case verify: {
				getActions().verify(command.getObject());
				break;
			}case enter:{
				getActions().enter();
			}

			default: {
				break;
			}
			}
		}
	}
}
