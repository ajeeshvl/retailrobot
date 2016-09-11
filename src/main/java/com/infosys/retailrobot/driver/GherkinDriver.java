package com.infosys.retailrobot.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import com.infosys.retailrobot.gherkin.Element;
import com.infosys.retailrobot.gherkin.Feature;
import com.infosys.retailrobot.gherkin.GherkinMapper;
import com.infosys.retailrobot.gherkin.Step;
import com.infosys.retailrobot.utils.FileManage;
import com.infosys.retailrobot.utils.FileMatchType;
import com.infosys.retailrobot.utils.LogHelper;
import com.infosys.retailrobot.webdriver.UIActions;
import com.infosys.retailrobot.webdriver.WebDriverFactory;

public class GherkinDriver {

	public static void main(String[] args) throws Exception {

		config.BaseURI = args[0];
		
		// Get all master feature files
		File[] masterFeatureFiles=FileManage.getFilesEndWith("src/main/resources",FileMatchType.ENDWITH, "test.feature");
		
		// Iterate through each master feature and store the sub features in a map
		Map<String, List> featureMapper = new LinkedHashMap<String, List>();
		for(File masterFeatureFile:masterFeatureFiles){
			
			Feature masterFeature = GherkinMapper.mapFeatureToObject(masterFeatureFile.toString());
			List<String> subFeatures = Parser.getSubFeatures(masterFeature);
			
			featureMapper.put(masterFeatureFile.toString(), subFeatures);
		}
		
		// Iterate though each feature from each master file and execute in order
		for(Map.Entry<String, List> map: featureMapper.entrySet())
		{
			LogHelper.log("Executing the master test case: "+map.getKey()+ "...");
			List<String> subFeatures = map.getValue();
			for(String subFeature: subFeatures){
				Executer.featureRunner(subFeature);
			}
			
		}
		LogHelper.log("Retail Website: "+config.BaseURI+" verification completed successfully");
	}

}
