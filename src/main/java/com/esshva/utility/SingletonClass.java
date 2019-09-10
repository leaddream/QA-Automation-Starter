package com.esshva.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.esshva.pageFactory.AutoPageFactory;

public class SingletonClass {
	private static WebDriver driver;
	private static String browser;
	private static Properties prop;
	private static Properties propTestdata;
	private static Properties propExpectedresults;
	private static SingletonClass obj;
	public static WebDriverWait wait;
	public String env;
	private static SingletonClass singletonClass;
	private static AutoPageFactory pfez;
	private static String userName;
	private String passWord;
	private String baseUrl;

	private static final Logger log = Logger.getLogger(SingletonClass.class);

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public static String getUseName() {
		return userName;
	}

	public static void setUseName() {
		userName = "user name";
		/* SingletonClass.getUiProp("userName") */;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord() {
		this.passWord = "password";
	}

	private SingletonClass() {

	}

	public static WebDriver getUiDriver() {
		return driver;
	}

	public static final SingletonClass getInstance() {
		if (singletonClass == null) {
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
		log.info("Start setup Env");
	}

	public static void setUiDriver(String execBrowser, String driverPath) {
		
		Path path = Paths.get(driverPath);
		if(execBrowser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",path.toAbsolutePath().toString());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			log.info("Start Chrome");
		}
		else if(execBrowser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", path.toAbsolutePath().toString());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			log.info("Start Internet Explorer Edge");
		}
		else if(execBrowser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", path.toAbsolutePath().toString());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			log.info("Start Firefox");
		}
		
		wait = new WebDriverWait(driver, 15000);
		
		log.info("setUiDriver");
	}

	public String getUiBrowser() {
		return browser;

	}

	public void setUiBrowser(String browser) {
		SingletonClass.browser = browser;

	}

	public static String getUiProp(String key) {
		return prop.getProperty(key);
	}

	public static void setUiProp() {

		prop = new Properties();
		try {
			prop.load(new FileInputStream(
					"./src/test/resources/TestData/framework.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("END setUiProp - framework.properties");
	}

	public static SingletonClass getObj() {
		return obj;
	}

	public static void setObj(SingletonClass obj) {
		SingletonClass.obj = obj;
	}

	public static String getUiPropTestData(String key) {
		return propTestdata.getProperty(key);
	}

	public static void setUiPropTestData() {

		propTestdata = new Properties();
		try {
			propTestdata.load(new FileInputStream(
					"./src/test/resources/TestData/testdata.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("END setUiProp - testdata.properties");
	}

	public static String getUiPropExpectedresults(String key) {
		return propExpectedresults.getProperty(key);
	}

	public static void setUiPropExpectedresults() {

		propExpectedresults = new Properties();
		try {
			propExpectedresults
					.load(new FileInputStream(
							"./src/test/resources/TestData/expectedresults.properties"));
		} catch (IOException e) {
			Log.info(e.getMessage());
		}

		log.info("END setUiProp - expectedresults.properties");
	}

	public AutoPageFactory getPfez() {
		return pfez;
	}

	public void setPfez() {
		pfez = PageFactory.initElements(getUiDriver(), AutoPageFactory.class);
		log.info("SetUp Page Factory - ezPageFactory");

	}

}
