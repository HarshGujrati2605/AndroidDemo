package com.appium.commonactionmethods;

import com.harsh.globalvariable.GlobalVariable;
import com.serosoft.base.*;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Keyboard;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.core.logging.LoggerFactory;
import junit.framework.AssertionFailedError;

/**
 * 
 * @author Harsh Gujrati Do not Modify this action methods . If any change
 *         required, please contact me at harsh.gujrati@serosoft.in
 *
 */

public class CommonMobileActions extends GlobalVariable {

	public static AppiumDriver driver;

	public CommonMobileActions(AppiumDriver driver) {

		this.driver = driver;
		
	}

	public static WebElement getElement(By elementloactor) {
		iLogMessage("Waiting for element to be visible");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(elementloactor));
		return ele;
	}

	public static void clickOnElementAndType(By elementlocator, String value, String nameofelement) throws Exception {
		if (driver != null) {
			WebElement ele = getElement(elementlocator);
			ele.clear();
			iClick(ele, nameofelement);
			ele.sendKeys(value);
			iLogMessage("Clicked on" + nameofelement);

		} else {
			throw new Exception("Element is not displayed");
		}
	}

	public static void isDisplayed(By elementlocator, String elementName) throws Exception {
		iImplicitlywait(30, elementName);
		WebElement element = getElement(elementlocator);
		boolean flag = element.isDisplayed();
		if (flag == true) {
			System.out.println(elementName + " is displayed....");
		} else {
			throw new Exception(elementName + " is not displayed");
		}
	}

	public static void iSwipeDownToElement(By elementlocator, String elementName) throws InterruptedException {
		boolean flag = true;
		int count = 0;

		while (flag) {
			try {
				WebElement element = getElement(elementlocator);
				if (element.isDisplayed()) {
					flag = false;
				}
			} catch (Exception e) {
				if (count == 9) {
				} else {
					count += 1;
					Thread.sleep(1000);
					scrollDown();

				}
			}
		}

	}

	public static void iSwipeUpToElement(By elementlocator, String elementName) throws InterruptedException {
		boolean flag = true;
		int count = 0;

		while (flag) {
			try {
				WebElement element = getElement(elementlocator);
				if (element.isDisplayed()) {
					flag = false;
				}
			} catch (Exception e) {
				if (count == 9) {
				} else {
					count += 1;
					Thread.sleep(1000);
					scrollUp();

				}
			}
		}

	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void scrollDown() {
		iImplicitlywait(2, "Waiitng");
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
		System.out.println("I scrolled down");
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void scrollUp() {
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.5);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollEnd))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollStart))
				.release().perform();
		System.out.println("I scrolled up");
	}

	public void iVerifySelected(By elementlocator, String elementName) {
		try {
			iImplicitlywait(30, elementName);
			WebElement ele = getElement(elementlocator);
			if (ele.isSelected()) {
				System.out.println("The element is selected " + elementName);
			} else {
				System.out.println("The element is not selected " + elementName);
			}
		} catch (Exception e) {
			System.out.println("The element is not selected " + elementName);
		}

	}

	public static void iVerifyPartialText(String actualText, String expectedText) {
		try {
			if (actualText.contains(expectedText)) {
				System.out.println("The expected text contains the actual: " + expectedText);
			} else {
				System.out.println("The expected text does not contains the actual: " + expectedText);
			}
		} catch (Exception e) {
			System.out.println("The expected text does not contains the actual: " + expectedText);
		}
	}

	public static String iGetText(WebElement ele, String elementname) {
		iLogMessage("Getting the text from" + elementname);
		return ele.getText();
	}

	public static void iVerifyPartialElementText(By elementlocator, String expectedText, String elementName) {
		try {
			WebElement ele = getElement(elementlocator);
			if (iGetText(ele, elementName).contains(expectedText)) {
				System.out.println("The actual text contain the partial element text: " + expectedText);
			} else {
				iLogMessage("The actual text does not contain the partial element text: " + expectedText);
			}
		} catch (Exception e) {
			iLogErrorMessage("The actual text does not contain the partial element text: " + expectedText);
		}
	}

	public static void iVerifyExactElementText(By elementlocator, String expectedText, String elementName) {
		WebElement ele = getElement(elementlocator);
		assertEquals(expectedText, ele.getText());
	}

	public static void iImplicitlywait(long sec, String elementName) {
		try {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
			System.out.println("Wait for " + sec + " sec to visible " + elementName);
		} catch (Exception e) {
			System.out.println(elementName + " is not displayed ");
		}
	}

	public static void iClickJSE(WebElement ele, String elementName) {

		try {
			iImplicitlywait(30, elementName);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", ele);
			System.out.println("i Click on the element " + elementName);
		} catch (Exception e) {
			System.out.println("I failed to click on " + elementName);
		}
	}

	public static void iClick(WebElement ele, String elementName) throws Exception {
		iImplicitlywait(30, elementName);
		if (ele.isDisplayed()) {
			Thread.sleep(2000);
			ele.click();
			iLogMessage("i Click on the element " + elementName);
		} else {
			throw new Exception("Element not clicked");
		}
	}
	
	public static void iClickElementByLocator(By locator, String elementName) throws Exception {
		iImplicitlywait(30, elementName);
	    WebElement ele = getElement(locator);
	    CommonMobileActions.iClick(ele, elementName);
		
	}


	public static void allowPermissionss(String alertnamebutton) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			iLogMessage("Alert not present");
		}
	}

	public static void iLogMessage(String message) {
		Logger logger = LoggerHelper.getLogger(CommonMobileActions.class);
		logger.info(message);
	}

	public static void iLogErrorMessage(String message) {
		Logger logger = LoggerHelper.getLogger(CommonMobileActions.class);
		logger.error(message);
	}

	public static void iTapByCoordinates(int x, int y) throws InterruptedException {
		Thread.sleep(2000);
		new TouchAction(driver).tap(PointOption.point((x), (y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).perform();
		iLogMessage("X value: " + (x) + " Y value: " + (y));
		Thread.sleep(2000);
	}

	public static void iTapWithCoordinates(WebElement element, String elementName) throws InterruptedException {
		int leftX = element.getLocation().getX();
		int rightX = leftX + element.getSize().getWidth();
		int X = (leftX + rightX) / 2;
		int upperY = element.getLocation().getY();
		int lowerY = upperY + element.getSize().getHeight();
		int Y = (upperY + lowerY) / 2;
		iTapByCoordinates(X, Y);
		iLogMessage("I tapped on the element : " + elementName + " using the co-ordinates " + X + " , " + Y);
	}

	public static void iClickBack(int times) throws InterruptedException {
		Thread.sleep(3000);
		for (int i = 1; i <= times; i++) {
			driver.navigate().back();
		}
		iLogMessage("Navigated back");
	}

}
