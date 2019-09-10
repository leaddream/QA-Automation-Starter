package com.esshva.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.esshva.utility.SingletonClass;

public class BasePageObject {
	public void uiSendKeys(WebElement element, String parameter) {
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10);
		    wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(new CharSequence[] { parameter });
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onclick(WebElement element) {
		try{
			WebDriver webdriver = SingletonClass.getUiDriver();
			Actions action = new Actions(webdriver);
			action.moveToElement(element).click().build().perform();		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void inputwithClear(WebElement element, String parameter) {
		try{	
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10); 
		    wait.until(ExpectedConditions.visibilityOf(element));
		    element.clear();
			element.sendKeys(new CharSequence[] { parameter });
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}	
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	

	public void uiSendKeysWithoutKeys(WebElement element, Keys key) {
		try{
			element.sendKeys(new CharSequence[] { key });
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	public void clearText(WebElement element) {
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10); 
		    wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	public String getText(WebElement element) {
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10); 
		    wait.until(ExpectedConditions.visibilityOf(element));
			
		}	
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
		return element.getText();
	}
	

	public void getAttribute(WebElement element, String attributeName) {
		try{
			element.getAttribute(attributeName);
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Boolean isDisplayed(WebElement element, int waitingTime){
		Boolean result = Boolean.valueOf(false);
		int i = 0;
		try {

			while (i < 5) {
				if (element.isDisplayed()) {
					result = Boolean.valueOf(true);
				} else {
					Thread.sleep((waitingTime) / 5);
				}
				i++;
			}
		} 	
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	public void uiClick(WebElement element) {
		try{
			element.click();
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void uiDoubleClick(WebElement element) {

		try{
			Actions action = new Actions(SingletonClass.getUiDriver());
			action.moveToElement(element).doubleClick().perform();
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}

	public Alert uiSwitchToAlert() {
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 2L);
			wait.until(ExpectedConditions.alertIsPresent());
		}
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
		return SingletonClass.getUiDriver().switchTo().alert();
	
	}

	public void uiAcceptAlert(Alert alert) {
		try{
			alert.accept();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	public String uiSwitchToWindow() {
		
		String winHandleBefore = SingletonClass.getUiDriver().getWindowHandle();
		try{
			for (String winHandle : SingletonClass.getUiDriver().getWindowHandles()) {
				SingletonClass.getUiDriver().switchTo().window(winHandle);
			}	
		}
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return winHandleBefore;
	}

	public void uiSwitchBackWindow(String winHandleBefore) {
		try {
			SingletonClass.getUiDriver().switchTo().window(winHandleBefore);
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiSwitchFrame(String frameName) {
		try {
			SingletonClass.getUiDriver().switchTo().frame(frameName);
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String uigetCurrentUrl() {

		return SingletonClass.getUiDriver().getCurrentUrl();
	}

	public String uigetTitle() {

		return SingletonClass.getUiDriver().getTitle();
	}

	public void uiQuit() {
		try {
			SingletonClass.getUiDriver().quit();
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiBack() {
		try {
			SingletonClass.getUiDriver().navigate().back();
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uirefresh() {
		try {
			SingletonClass.getUiDriver().navigate().refresh();
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiForward() {
		try {
			SingletonClass.getUiDriver().navigate().forward();
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiselectByIDVisibleText(String element) {
		try {
			new Select(SingletonClass.getUiDriver().findElement(By.id(element)));
		} 
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiselectByNameVisibleText(String element) {
		try {
			new Select(SingletonClass.getUiDriver().findElement(By.name(element)));
		} 
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiselectByXpathVisibleText(String element) {
		try {
			new Select(SingletonClass.getUiDriver().findElement(By.xpath(element)));
		} 
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String GetTimeStampValue() throws IOException {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		return timestamp.replace(":", "-");
	}

	public void acceptAlert() {
		try {
			Alert alert = SingletonClass.getUiDriver().switchTo().alert();
			alert.accept();
		} 
		catch (WebDriverException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		try {
			SingletonClass.getUiDriver().switchTo().alert();
			return true;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		
		Alert alert = SingletonClass.getUiDriver().switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;

	}
	
	public void uiClickElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10); 
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} 
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String uigetValue(WebElement element) {
		WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute("value");
	}
	
	public void readFromExcel(WebElement element, String src, int index, int row, int column) {
		try{
			
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10);
		    wait.until(ExpectedConditions.visibilityOf(element));
		    
			File link = new File (src);
			FileInputStream fis = new FileInputStream(link);
			XSSFWorkbook wb = new XSSFWorkbook (fis);
			XSSFSheet sheet1 = wb.getSheetAt(index); // index is the position if sheet in the Excel file
			String data = sheet1.getRow(row).getCell(column).getStringCellValue();
			
			element.sendKeys(new CharSequence[] { data });
			
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void uiSendRandomNumber(WebElement element) {
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10);
		    wait.until(ExpectedConditions.visibilityOf(element));
		    
		    Random rnd  = new Random ();
		    int n = rnd.nextInt (1000);
		    String rNo = Integer.toString(n);
		    		    
		    element.sendKeys(new CharSequence[] { rNo });		
		    
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
	public void uiSendRandomString(WebElement element, int length) // length is the number characters in the random word 
	{ 
		try{
			WebDriverWait wait = new WebDriverWait(SingletonClass.getUiDriver(), 10);
		    wait.until(ExpectedConditions.visibilityOf(element));
		    
		    String characters = "ABCDEFGHIJKLMNOPQRST";
		    String randomString = "";
		    
		    Random 	rand = new Random();
		    char[] text = new char[length];
		    
		    for(int i = 0; i<length; i++) {
		    	text[i] = characters.charAt(rand.nextInt(characters.length()));
		    	}
		    
		    for (int i=0; i<text.length; i++) {
		    	randomString += text[i];
		    }
		    
		    element.sendKeys(new CharSequence[] { randomString });
		    
		     	
		    
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
	public Boolean contains(WebElement element,String Parameter, int waitingTime){
		String text1 = element.getText();
		String expected = Parameter;
		Boolean result = Boolean.valueOf(false);
		int i = 0;
		try {

			while (i < 5) {
				if (text1 ==expected) {
					result = Boolean.valueOf(true);
				} else {
					Thread.sleep((waitingTime) / 5);
				}
				i++;
			}
		}
		catch (ElementNotVisibleException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public void mouseover(WebElement element) {
		try{
			WebDriver webdriver = SingletonClass.getUiDriver();
			Actions action = new Actions(webdriver);
			action.moveToElement(element).build().perform();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}