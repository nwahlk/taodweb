package com.sap.taodweb.service;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sap.taodweb.utils.WebPage;

public class RequestSubmitPage {
	private WebDriver driver;

	public RequestSubmitPage(WebDriver driver) {
		this.driver = driver;
	}

	public void CreateSQLRequest(String InstallProject, String TestCasePathList, boolean BookVM, String ToTGroup)
			throws InterruptedException {
		// 1. Click RequestSubmit Tab;
		driver.findElement(By.linkText("Request Submit")).click();

		// 2. Select install build
		selectInstallBuild(InstallProject);

		// 3. Select test cases
		driver.findElement(By.cssSelector("div#ddlScope div.sap-ui-dropdownicon")).click();
		driver.findElement(By.xpath("//li[text()='Customize']")).click();
		// selectTestCase(TestCaseList);
		selectTestCasebyPathList(TestCasePathList);
		// click OK Button
		driver.findElement(By.cssSelector("div.buttons>button:first-child")).click();

		// 4. Book VM
		if (BookVM) {
			driver.findElement(By.cssSelector("input#txtBookNo")).clear();
			driver.findElement(By.cssSelector("input#txtBookNo")).sendKeys("1");
		}

		// 5. Choose Machine Group
		if (ToTGroup.equals("All")) {
			// select all tot groups
			for (String tot_group : Constant.ToTGroups) {
				tot_group = "SQL_" + tot_group;
				driver.findElement(By.cssSelector("div[title='" + tot_group + "']")).click();
			}
		} else {
			String tot_group = "SQL_" + ToTGroup;
			driver.findElement(By.cssSelector("div[title='" + tot_group + "']")).click();
		}

		// 6. Update vm capacity to 10
		// Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#chkMoreInformation")).click();
		driver.findElement(By.cssSelector("div#chkMoreInformation")).click();
		driver.findElement(By.cssSelector("div#ConfigRepeatInput input[configkey = 'VmCapacity']")).clear();
		driver.findElement(By.cssSelector("div#ConfigRepeatInput input[configkey = 'VmCapacity']")).sendKeys("10");

		// 7. Click Add button
		driver.findElement(By.cssSelector("input[action='add']")).click();
		WebPage.waitForAlert(driver);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void CreateHANARequest() {
		driver.findElement(By.cssSelector("input[value='Create']")).click();
		// Input Install Path
		driver.findElement(By.id("btnInstallPath")).click();
		Actions builder = new Actions(driver);
		builder.doubleClick(driver.findElement(By.linkText(Constant.InstallProject))).perform();

	}

	// Install Project selection: 9.2_DEV;9.2_COR;9.3_DEV;9.3_COR
	private void selectInstallBuild(String InstallProject) {
		// 1. Click Install Path
		WebDriverWait wait = new WebDriverWait(driver, Constant.MaxWaitSecond, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("btnInstallPath"))));
		driver.findElement(By.id("btnInstallPath")).click();

		// 2. Double click install project address
		Actions builder = new Actions(driver);
		builder.doubleClick(driver.findElement(By.linkText(InstallProject))).perform();

		// 3. Select the last build
		List<WebElement> elements = driver.findElements(By.xpath("//li/a[contains(text(),'MSSQL')]"));
		WebElement lastElement = elements.get(elements.size() - 1);
		builder.doubleClick(lastElement).perform();

		// 4. Select the product package and double click it
		builder.doubleClick(
				lastElement.findElement(By.xpath("//following-sibling::ul//a[starts-with(text(),'Product')]")))
				.perform();
	}

	private void selectTestCase(String[] TestCaseList) {
		for (String testcase : TestCaseList) {
			selectSingleTestCase(testcase);
		}
	}

	private void selectTestCasebyPathList(String TestCasePathList) {
		String[] TestCaseList = TestCasePathList.split(";");
		for (String testcase : TestCaseList) {
			selectSingleTestCase(testcase);
		}
	}

	private void selectSingleTestCase(String TestCasePath) {
		String[] path = TestCasePath.split("/");
		WebElement parent = driver.findElement(By.cssSelector("div#p4Tree>ul>li"));
		// ignore first 5 path for they not show in the popup window
		for (int i = 5; i < path.length; i++) {
			WebElement li = findParentLiByText(parent, path[i]);
			// Click expand icon if not dynatree-expanded
			if (i >= 6 && i < path.length - 1) {
				if (!li.findElement(By.cssSelector("span")).getAttribute("class").contains("dynatree-expanded")) {
					li.findElement(By.cssSelector("span>span.dynatree-expander")).click();
				}
			}
			// Select check box for the last step if not selected
			if (i == path.length - 1) {
				if (!li.findElement(By.cssSelector("span")).getAttribute("class").contains("dynatree-selected")) {
					li.findElement(By.cssSelector("span>span.dynatree-checkbox")).click();
				}
			}
			parent = li;
		}

	}

	private WebElement findParentLiByText(WebElement parent, String matchString) {
		for (WebElement webElement : parent.findElements(By.cssSelector("ul>li"))) {
			String text_path = "span:first-child>a";
			if (webElement.findElement(By.cssSelector(text_path)).getText().equals(matchString)) {
				return webElement;
			}
		}
		return null;
	}

}
