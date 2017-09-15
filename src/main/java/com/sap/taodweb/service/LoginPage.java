package com.sap.taodweb.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement txt_UserID() {
		return driver.findElement(By.id("login_inputUsername"));
	}

	private WebElement txt_Password() {
		return driver.findElement(By.id("login_inputPassword"));
	}

	private WebElement btn_LogOn() {
		return driver.findElement(By.id("login_btnOK"));
	}

	public void SignIn_Action() {
		driver.get(Constant.URL);
		txt_UserID().sendKeys(Constant.Username);
		txt_Password().sendKeys(Constant.Passwrod);
		btn_LogOn().click();
	}

	public void SignIn_Action(String username, String password) {
		driver.get(Constant.URL);
		txt_UserID().sendKeys(username);
		txt_Password().sendKeys(password);
		btn_LogOn().click();
	}

}
