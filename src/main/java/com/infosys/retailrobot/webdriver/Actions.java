package com.infosys.retailrobot.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.base.Objects;
import com.infosys.retailrobot.objects.ObjectMap;
import com.infosys.retailrobot.objects.ObjectMapper;

public class Actions {
	public static WebDriver driver;
	public static org.openqa.selenium.support.ui.WebDriverWait webDriverWait;

	public static void startDriver(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\newworkspace\\infosys-retail-robot\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		webDriverWait = new org.openqa.selenium.support.ui.WebDriverWait(driver, 60000);
		driver.get(url);
	}

	public static WebElement FindElement(String object) throws InterruptedException {
		ObjectMap o = new ObjectMapper().mapUIObjectToObject(object);

		List<String> objects = o.getObjects().getCss();
		for (int second = 0; second < 15; second++) {
			for (String obj : objects) {
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

	public static void type(String object, String value) throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement element =FindElement(object);
		if(element!= null)
			element.sendKeys(value);
		
		Thread.sleep(3000);
	}

	public static void click(String object) {
		// TODO Auto-generated method stub

	}

	public static void verify(String object) {
		// TODO Auto-generated method stub

	}

}
