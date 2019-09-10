package com.esshva.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoPageFactory {

	static AutoPageFactory autoPageFactory;

	public static AutoPageFactory getInstance() {

		if (autoPageFactory == null) {
			autoPageFactory = new AutoPageFactory();
		}
		return autoPageFactory;
	}

	/*------ Esshva Home Page -----*/


	@FindBy (xpath = ("//div[@class='logo']//a//img"))
	public WebElement esshvaImage;

	@FindBy (xpath = ("//*[contains(text(),'About Esshva')]"))
	public WebElement aboutUs;

	@FindBy (xpath = ("//*[contains(text(),'The Magic Touch')]"))
	public WebElement theMagicTouch;



}
