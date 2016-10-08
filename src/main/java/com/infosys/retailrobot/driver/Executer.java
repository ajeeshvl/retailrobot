package com.infosys.retailrobot.driver;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.infosys.retailrobot.gherkin.Feature;
import com.infosys.retailrobot.gherkin.GherkinMapper;
import com.infosys.retailrobot.utils.FileManage;
import com.infosys.retailrobot.utils.FileMatchType;
import com.infosys.retailrobot.webdriver.TestContext;
import com.infosys.retailrobot.webdriver.UIActions;
import com.infosys.retailrobot.webdriver.WebDriverFactory;

public class Executer {
	public static UIActions getActions(){
		return TestContext.get().getActions();
	}
	static void featureRunner(String subfeatureName) throws Exception {

		File[] subFeatureFiles=FileManage.getFilesEndWith("src/main/resources/common",FileMatchType.STARTWITH, subfeatureName);
		
		for (File subfeatureFile : subFeatureFiles) {
			Feature feature = GherkinMapper.mapFeatureToObject(subfeatureFile.toString());
			List<Command> commandsList = Parser.getStepCommands(feature);
			//WebDriver driver = WebDriverFactory.getDriver();
			getActions().navigate(config.BaseURI);
			
			// Iterate through each step and do the execution
			ActionsEnum enumval = ActionsEnum.NoValue;
			for (Command command : commandsList) {
				if (command.getName() != null)
					enumval = ActionsEnum.valueOf(command.getName());
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
				}

				default: {
					// throw new Exception("No Command found with name :
					// "+command.getName());
					break;
				}
				}
			}
			driver.quit();
					
		}
	}
}
