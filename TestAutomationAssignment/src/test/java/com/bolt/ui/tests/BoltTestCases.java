package com.bolt.ui.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bolt.utils.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class BoltTestCases extends BaseTest {

	SoftAssert softAssert = new SoftAssert();

	@Test(priority=0)
	public void verifyTitleTest() throws InterruptedException {
		String expectedTitle = prop.getPropertyValue("EXPECTED_TITLE");
		Thread.sleep(4000);
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}

	@Test(priority=1)
	public void verifyTourTitleTest() throws InterruptedException {
		driver.findElement(By.linkText(prop.getPropertyValue("LINKTEXT_TOUR"))).click();
		Thread.sleep(4000);
		String expectedTourTitle = prop.getPropertyValue("EXPECTED_TOUR_TITLE");
		String actualTourTitle = driver.getTitle();
		softAssert.assertEquals(actualTourTitle, expectedTourTitle);
		softAssert.assertAll();
	}

	@Test(priority=3)
	public void verifyTechnologyTitleTest() throws InterruptedException {
		driver.findElement(By.linkText(prop.getPropertyValue("LINKTEXT_TECHNOLOGY"))).click();
		String expectedTechnologyTitle = prop.getPropertyValue("EXPECTED_TECHNOLOGY_TITLE");
		String actualTechnologyTitle = driver.getTitle();
		softAssert.assertEquals(actualTechnologyTitle, expectedTechnologyTitle);
		softAssert.assertAll();

	}

	@Test(priority=4)
	public void verifyLoginButtonTest() {
		WebElement LoginButton = driver.findElement(By.xpath(prop.getPropertyValue("XPATH_LOGINBUTTON")));
		Boolean checkButtonPresence = LoginButton.isDisplayed();
		softAssert.assertTrue(checkButtonPresence);
		softAssert.assertAll();
	}

	@Test(priority=5)
	public void verifyInvalidLoginTest() {
		driver.findElement(By.xpath(prop.getPropertyValue("XPATH_LOGINBUTTON"))).click();
		WebElement username = driver.findElement(By.id(prop.getPropertyValue("ID_USERNAME")));
		username.sendKeys(prop.getPropertyValue("USERNAME"));
		WebElement password = driver.findElement(By.id(prop.getPropertyValue("ID_PASSWORD")));
		password.sendKeys(prop.getPropertyValue("PASSWORD"));
		WebElement login = driver.findElement(By.xpath(prop.getPropertyValue("XPATH_LOGIN")));
		login.click();
		String actualUrl = prop.getPropertyValue("ACTUALURL"); // dummy url used for testing
		String expectedUrl = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrl, expectedUrl, "Actual URL is not same as expected URL");
		softAssert.assertAll();

	}

}
