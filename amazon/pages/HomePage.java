package amazon.pages;

import com.microsoft.playwright.Page;
import baseplaywright.BaseClassPW;

public class HomePage extends BaseClassPW {
	private Page page;
	
	//constructor
	public HomePage(Page page) {
		this.page=page;
	}
	
	private String SignIn = "[data-nav-ref='nav_ya_signin']";
	private String email = "input[type='email']";
	private String continueBtn = "input.a-button-input";
	private String errorMsg = "//h4[text()='There was a problem']";
	
	private String searchTab ="#twotabsearchtextbox";
	private String searchBtn ="input[type='submit']";
	//private String SearchList ="//div[@class='s-suggestion-container']";
	
	private String product="(//span[contains(@class,'a-size-medium a-color-base')])[1]";
	private String addToCart="#add-to-cart-button";
	private String addedToCartMsg ="//span[text()[normalize-space()='Added to Cart']]";
	
	//private String onePlusBrand ="((//span[text()='Brand'])[2]/following::input)[1]";
	
	private String pageResult ="(//div[contains(@class,'a-section a-spacing-small')])[1]";
	
	public void signInPage(String text) {
		btnClick(page.locator(SignIn));
		enterText(page.locator(email), text);
		btnClick(page.locator(continueBtn));
		
	}
	public void validate() {
		CheckText(page.locator(errorMsg), "There was a problem");
		

	}
	
	public void searchFunction(String text) {
		enterText(page.locator(searchTab), text);
		//getTexts(page.locator(SearchList));
	    btnClick(page.locator(searchBtn));
		//clickEqual(page.locator(SearchList),textToClick );
		
	}
	
	public void productAddToCart() {
		//btnClick(page.locator(onePlusBrand));
		getText(page.locator(pageResult));
		
		Page productpage = page.waitForPopup(()->{
			btnClick(page.locator(product));	
		});
		
		btnClick(productpage.locator(addToCart));
		CheckText(productpage.locator(addedToCartMsg), "Added to Cart");
	}

}
