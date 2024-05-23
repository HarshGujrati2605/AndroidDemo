package com.serosoft.base;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.harsh.globalvariable.GlobalVariable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class BaseClass extends GlobalVariable {

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getDriver() {
		return driver;

	}

	public static void captureScreenshot(String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());

		}
	}

	public static String getURL() throws IOException {

		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String url = properties.getProperty("appiumURL");
		return url;

	}

	public static String getAppLocation() throws IOException {

		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String appPath = System.getProperty("user.dir") + properties.getProperty("AppLocation");
		return appPath;

	}

	public static String getUDID() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String UDID = properties.getProperty("udid");
		return UDID;

	}

	public static String getappPackage() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String apppackage = properties.getProperty("androidAppPackage");
		return apppackage;

	}

	public static String getappActivity() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String activity = properties.getProperty("androidAppActivity");
		return activity;

	}

	public static String getCloudDeviceChoice() throws IOException {
		Properties properties = new Properties();
		FileInputStream configfile = new FileInputStream("config.properties");
		properties.load(configfile);
		String response = properties.getProperty("Device");
		return response;

	}

	

}
