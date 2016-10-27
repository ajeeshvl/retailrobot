package com.infosys.retailrobot.webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.infosys.retailrobot.data.DataMap;
import com.infosys.retailrobot.data.DataMapper;
import com.infosys.retailrobot.objects.ObjectMap;
import com.infosys.retailrobot.objects.ObjectMapper;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class UIActions {

	WebDriver driver;

	public UIActions(WebDriver _driver) {
		this.driver = _driver;
	}

	public void navigate(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public WebElement GetLocator(String object, List<String> objects,
			ObjectType objectType) throws InterruptedException {

		for (int second = 0; second < 15; second++) {
			for (String obj : objects) {
				System.out.println("Locating Object Pattern: " + obj);
				if (objectType == ObjectType.CSS) {
					if (driver.findElements(By.cssSelector(obj)).size() > 0) {
						WebElement ele = driver
								.findElement(By.cssSelector(obj));
						if (ele.isDisplayed()) {
							System.out.println("*Object Pattern " + obj
									+ " Located Successfully*");
							return ele;
						}
					}
				} else if (objectType == ObjectType.XPATH) {
					System.out.println("Locating Object Pattern: " + obj);
					if (driver.findElements(By.xpath(obj)).size() > 0) {
						WebElement ele = driver.findElement(By.xpath(obj));
						if (ele.isDisplayed()) {
							System.out.println("*Object Pattern " + obj
									+ " Located Successfully*");
							return ele;
						}
					}
				} else if (objectType == ObjectType.PARTIALLINKTEXT) {
					WebElement ele = driver
							.findElement(By.partialLinkText(obj));
					if (ele.isDisplayed()){
						System.out.println("*Object Pattern " + obj
								+ " Located Successfully*");
						return ele;
					}
				}
			}
			Thread.sleep(1000);
		}
		return null;
	}

	public WebElement FindElement(String object) throws InterruptedException {
		
		WebElement element =null;
		
		if (!object.contains("$")) {
			ObjectMap o = new ObjectMapper().mapUIObjectToObject(object);
			List<String> objects = o.getObjects().getCss();
			if (objects.size() > 0) {
				System.out
						.println("Trying to locate CSS Locator.Please wait..");
				element = GetLocator(object, objects, ObjectType.CSS);
			}
			if (element == null) {
				objects = o.getObjects().getXpath();
				if (objects.size() > 0) {
					System.out
							.println("Trying to locate XPath Locators.Please wait..");
					element = GetLocator(object, objects, ObjectType.XPATH);
				}
			}
			
		} else {
			DataMap data = new DataMapper().mapDataToObject(object);
			System.out
					.println("Trying to locate Partial Link Text Locators.Please wait..");
			List<String> linktext = new ArrayList<String>();
			linktext.add(data.getValue());
			element = GetLocator(object, linktext, ObjectType.PARTIALLINKTEXT);

		}
		return element;
	}

	public WebElement FindElementWithoutWait(String object)
			throws InterruptedException {
		ObjectMap o = new ObjectMapper().mapUIObjectToObject(object);

		List<String> objects = o.getObjects().getCss();
		for (String obj : objects) {
			System.out.println("Find Object: " + obj);
			if (driver.findElements(By.cssSelector(obj)).size() > 0) {
				WebElement ele = driver.findElement(By.cssSelector(obj));
				if (ele.isDisplayed())
					return ele;
			}
		}
		return null;
	}

	public void FindElemnentsWithText(String keyword) {
		List<WebElement> elements = driver.findElements(By.xpath("//button"));

	}

	public void type(String object, String value) throws Exception {
		DataMap o = new DataMapper().mapDataToObject(value);
		log("typing on " + object + "as value " + o.getValue());
		// TODO Auto-generated method stub
		WebElement element = FindElement(object);
		if (element != null)
			element.sendKeys(o.getValue());
		else
			throw new Exception("to do smart object identifiCATION");
		Thread.sleep(5000);
	}

	public void click(String object) throws Exception {
		log("clicking on " + object);
		// TODO Auto-generated method stub
		WebElement element = FindElement(object);
		if (element != null) {
			// element.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		} else
			//throw new Exception("to do smart object identification");
			enter();
		Thread.sleep(3000);
	}

	static void log(String message) {
		System.out.println(message);
	}

	public void clickIfFound(String object) throws InterruptedException {
		log("clicking on " + object + " if found");
		// TODO Auto-generated method stub
		WebElement element = FindElementWithoutWait(object);
		// if(element!= null)
		element.click();
	}

	public void verify(String object) {
		// TODO Auto-generated method stub

	}

	public void enter() {
		log("Pressing on keyboard enter key");
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (Exception ex) {

		}

	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

}
