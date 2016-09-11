package com.infosys.retailrobot.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {

	private UIActions actions;
	private WebDriver driver;
	private WebDriverWait webDriverWait;
	/**
	 * To make a thread for each of the TestContext objects.
	 */

	public static ThreadLocal<TestContext> threadLocal =new ThreadLocal<TestContext>(){
		protected synchronized TestContext initialValue() {
			return new TestContext();}
	};
 
	public TestContext() {
			driver=WebDriverFactory.getDriver();
			actions=new UIActions(driver);
			webDriverWait = new org.openqa.selenium.support.ui.WebDriverWait(driver, 60000);
    }

	
	/**
	 * 
	 * @return WebDriver instance
	 */
	public WebDriver getWebDriver(){
		return driver;
	}

	/**
	 * 
	 * @return Command instance
	 */

	public UIActions getActions(){
		return actions;
	}
	public WebDriverWait getWait(){
		return webDriverWait;
	}
	/**
	 * 
	 * @return TestContext object
	 */
	public static TestContext get() {
		return threadLocal.get();
	}
}
