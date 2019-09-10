package com.esshva.tests;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.esshva.utility.Log;
import com.esshva.utility.SingletonClass;

import java.util.Map;


public class ConfigureFramework {

        public static ITestResult result;
        public static String workingDir;

        // Declare A Map Object To Hold TestNG Results
        public static Map<Integer, Object[]> TestNGResults;


        @BeforeSuite
        public void ConfigureFrameWorkProperties() {
        	DOMConfigurator.configure("log4j.xml");
        	SingletonClass.getInstance().setEnv("QA");
            SingletonClass.getInstance();
            SingletonClass.setUiProp();
            SingletonClass.setUiPropTestData();
            SingletonClass.setUiPropExpectedresults();
            SingletonClass.getInstance().setUiBrowser(SingletonClass.getUiProp("browser"));
            SingletonClass.setUiDriver(SingletonClass.getUiProp("browser"), SingletonClass.getUiProp(SingletonClass.getUiProp("browser")+"DriverPath"));
            //SingletonClass.getInstance().setPf();
            SingletonClass.getInstance().setPfez();
            Log.info("Configure Framework properties");
        }

        @BeforeTest
        public void beforeTestMethod() {
            Log.startTestCase(this.getClass().getName());
            try {
                SingletonClass.getInstance();
                SingletonClass.getUiDriver().get(SingletonClass.getUiProp("baseUrl"));
                //Log.info("Test URL - "+SingletonClass.getUiProp("baseUrl"));
                System.out.println("Test URL - "+SingletonClass.getUiProp("baseUrl"));

                Thread.sleep(2000);
                Log.info("Start Test");


            } catch (Exception e) {
                System.out.println(e);
                Log.info(TestNGResults.toString() + e);
            }

        }

        @AfterSuite
        public void tearDown() throws InterruptedException {
            Thread.sleep(5000);
            SingletonClass.getUiDriver().quit();
        }
    }

