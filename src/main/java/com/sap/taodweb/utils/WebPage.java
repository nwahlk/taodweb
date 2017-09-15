package com.sap.taodweb.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {
	public static WebElement findParentLiByLinkText(WebDriver driver, String li_path, String matchString) {
		for (WebElement webElement : driver.findElements(By.xpath(li_path))) {
			// System.out.println("Match string: " + matchString);
			int i = webElement.findElements(By.xpath("/span/a[text()='" + matchString + "']")).size();
			// System.out.println("size " + i);
			if (webElement.findElements(By.xpath("//span/a[text()='" + matchString + "']")).size() != 0) {
				if (webElement.findElements(By.xpath("//span/span[@class='dynatree-expander']")).size() != 0) {
					webElement.findElement(By.xpath("//span/span[@class='dynatree-expander']")).click();
				}
				return webElement;
			}
		}

		return null;
	}

	public static void RunJS(WebDriver driver, String jsCode) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(jsCode);
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	public static void waitForAlert(WebDriver driver) throws InterruptedException {
		int i = 0;
		while (i++ < 10) {
			try {
				Alert alert = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			}
		}
	}

}
