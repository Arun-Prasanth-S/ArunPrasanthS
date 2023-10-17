package amazon.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import amazon.pages.HomePage;
import baseplaywright.BaseClassPW;

public class HomepageTest extends BaseClassPW {
	HomePage hp;
	Page page;
	@BeforeTest
	public void frontPage() {
		page = launchBrowser("chromium", "https://www.amazon.in/");
		hp = new HomePage(page);
		hp.signInPage("Arun");
		
	}
	
	@Test
	public void TC1() {
		hp.validate();
	}

}
