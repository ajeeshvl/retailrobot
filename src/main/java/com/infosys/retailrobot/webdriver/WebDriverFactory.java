package com.infosys.retailrobot.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\newworkspace\\infosys-retail-robot\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
