package amazon.pages;

import com.microsoft.playwright.Page;
import baseplaywright.BaseClassPW;

public class HomePage extends BaseClassPW {
	private Page page;
	
	//constructor
	public HomePage(Page page) {
		this.page=page;
	}
	
	private String SignIn = "#nav-link-accountList-nav-line-1";
	private String email = "input[type='email']";
	private String continueBtn = "input.a-button-input";
	private String errorMsg = "(//h4[@class='a-alert-heading'])[1]";
	
	public void signInPage(String text) {
		btnClick(page.locator(SignIn));
		enterText(page.locator(email), text);
		btnClick(page.locator(continueBtn));
		
	}
	public void validate() {
		String originalErrorMsg = "There was a problem";
		CheckText(page.locator(errorMsg), originalErrorMsg);

	}

}
