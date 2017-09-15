package com.sap.dragonboat.taod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sap.taodweb.service.Constant;
import com.sap.taodweb.service.HomePage;
import com.sap.taodweb.service.LoginPage;
import com.sap.taodweb.service.RequestSubmitPage;

public class TAOD {
	private static WebDriver driver = null;
	private static Logger Log = Logger.getLogger(TAOD.class.getName());

	@Test(priority = 0)
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.SignIn_Action(username, password);
		HomePage homePage = new HomePage(driver);
		Log.info(homePage.lbl_User() + " Login.");
		Assert.assertTrue(homePage.CheckLoginSuccess());
	}

	@Test(priority = 1)
	@Parameters({ "project", "InstallProject", "TestCasePathList", "BookVM", "ToTGroup" })
	public void create_request(String project, String InstallProject, String TestCasePathList, boolean BookVM,
			String ToTGroup) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.ChangeProject(project);
		RequestSubmitPage requestSubmitPage = new RequestSubmitPage(driver);
		if (project.contains("HANA")) {
			requestSubmitPage.CreateHANARequest();
		} else {
			requestSubmitPage.CreateSQLRequest(InstallProject, TestCasePathList, BookVM, ToTGroup);
		}
		Log.info("Submit request successfully!");
	}

	@BeforeSuite
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
		driver = new ChromeDriver();
		// driver = new HtmlUnitDriver();
		// set max wait time for all
		driver.manage().timeouts().implicitlyWait(Constant.MaxWaitSecond, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
