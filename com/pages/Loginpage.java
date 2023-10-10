package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.com.Baseclass;

public class Loginpage extends Baseclass {
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class=\"nav-line-1-container\"]")
	private WebElement findL;
	
	@FindBy(xpath = "(//span[text()=\"Sign in\"])[1]")
	private WebElement signInbtn;

	@FindBy(name = "email")
	private WebElement userName;
	
	@FindBy(id = "continue")
	private WebElement con;
	
	@FindBy(xpath = "//h4[text()=\"There was a problem\"]")
	private WebElement error;
	
	public void login(String name) {
		mouseHover(findL);
		btnclick(signInbtn);
		enterText(userName, name);
		btnclick(con);
		
	}
	
	public void validate() {
		String v = "There was a problem";
		String c = getText(error);
		Assert.assertEquals(c, v, "both are not equal");
	}

}

