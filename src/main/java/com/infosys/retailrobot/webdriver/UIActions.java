package com.infosys.retailrobot.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.infosys.retailrobot.objects.ObjectMap;
import com.infosys.retailrobot.objects.ObjectMapper;

public class UIActions {

	WebDriver driver;
	public UIActions(WebDriver _driver) {
		this.driver = _driver;
	}

	public void navigate(String url){
		driver.get(url);
		driver.manage().window().maximize();
	}
	public WebElement FindElement(String object) throws InterruptedException {
		ObjectMap o = new ObjectMapper().mapUIObjectToObject(object);

		List<String> objects = o.getObjects().getCss();
		for (int second = 0; second < 15; second++) {
			System.out.println("Iteration: "+second);
			for (String obj : objects) {
				System.out.println("Find Object: "+obj);
				if (driver.findElements(By.cssSelector(obj)).size() > 0){
					WebElement ele = driver.findElement(By.cssSelector(obj));
					if(ele.isDisplayed())
						return ele;
				}
			}
			Thread.sleep(1000);
		}
		return  null;
	}
	public WebElement FindElementWithoutWait(String object) throws InterruptedException {
		ObjectMap o = new ObjectMapper().mapUIObjectToObject(object);

		List<String> objects = o.getObjects().getCss();
			for (String obj : objects) {
				System.out.println("Find Object: "+obj);
				if (driver.findElements(By.cssSelector(obj)).size() > 0){
					WebElement ele = driver.findElement(By.cssSelector(obj));
					if(ele.isDisplayed())
						return ele;
				}
		}
		return  null;
	}
	public void FindElemnentsWithText(String keyword){
		List<WebElement> elements = driver.findElements(By.xpath("//button"));
		
	}

	public void type(String object, String value) throws Exception {
		log("typing on "+object+"as value "+value);
		// TODO Auto-generated method stub
		WebElement element =FindElement(object);
		if(element!= null)
			element.sendKeys(value);
		else
			throw new Exception("to do smart object identifiCATION");
		Thread.sleep(5000);
	}

	public void click(String object) throws Exception {
		log("clicking on "+object);
		// TODO Auto-generated method stub
		WebElement element =FindElement(object);
		if(element!= null)
			element.click();
		else
			throw new Exception("to do smart object identifier");

	}
	static void log(String message){
		System.out.println(message);
	}
	public void clickIfFound(String object) throws InterruptedException {
		log("clicking on "+object+" if found");
		// TODO Auto-generated method stub
		WebElement element =FindElementWithoutWait(object);
		//if(element!= null)
			element.click();
	}
	public void verify(String object) {
		// TODO Auto-generated method stub

	}

}
