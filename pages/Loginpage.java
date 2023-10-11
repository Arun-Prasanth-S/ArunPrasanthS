package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.com.Baseclass;
import base.com.LocatorsPage;

public class Loginpage extends Baseclass {
	 LocatorsPage locator;
	
	public Loginpage(WebDriver driver) {
		locator=PageFactory.initElements(driver, LocatorsPage.class);

	}
	
	
	public void login(String name) {
		mouseHover(locator.getFindL());
		btnclick(locator.getSignInbtn());
		enterText(locator.getSignInbtn(), name);
		btnclick(locator.getcontinu());
		
	}
	
	public void validate() {
		String v = "There was a problem";
		String c = getText(locator.getError());
		Assert.assertEquals(c, v, "both are not equal");
	}

}

