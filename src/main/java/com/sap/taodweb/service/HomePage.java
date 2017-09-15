package com.sap.taodweb.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String lbl_User() {
		return driver.findElement(By.className("user")).getText();
	}

	public boolean CheckLoginSuccess() {
		if (lbl_User().contains(Constant.Username)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean CheckLoginSuccess(String username) {
		if (lbl_User().contains(username)) {
			return true;
		} else {
			return false;
		}
	}

	public void ChangeProject() {
		driver.findElement(By.className("sap-ui-dropdownicon")).click();

		driver.findElement(By.xpath("//li[@class='sap-ui-dropdownlist-item'][text()='" + Constant.Project + "']"))
				.click();
	}

	// Project selection: 9.2_DEV;9.2_HANA_DEV;9.3_DEV;9.3_HANA_DEV
	public void ChangeProject(String project) {
		driver.findElement(By.className("sap-ui-dropdownicon")).click();

		driver.findElement(By.xpath("//li[@class='sap-ui-dropdownlist-item'][text()='" + project + "']")).click();
	}
}
