package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.com.Baseclass;

public class SearchPage extends Baseclass {
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(xpath = "//div[@class=\"s-suggestion-container\"]")
	private List<WebElement> searchList;

//	@FindBy(xpath = "//span[text()=\"oneplus 11\"]")
//	private WebElement oneplus;
	
	public void searchpage(String text,String textToClick) {
		enterText(search, text);
		getTexts(searchList);
		//btnclick(oneplus);
		clickEqual(searchList, textToClick);
	}

}
