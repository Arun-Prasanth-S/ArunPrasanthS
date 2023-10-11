package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.com.Baseclass;
import base.com.LocatorsPage;

public class SearchPage extends Baseclass {
	 LocatorsPage locator;
	public SearchPage(WebDriver driver) {
		locator=PageFactory.initElements(driver, LocatorsPage.class);
	}
	public void searchpage(String text,String textToClick) {
		enterText(locator.getSearch(), text);
		getTexts(locator.getSearchList());
		clickEqual(locator.getSearchList(), textToClick);
	}

}
