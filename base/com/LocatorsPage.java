package base.com;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsPage {
	@FindBy(xpath = "//div[@class=\"nav-line-1-container\"]")
	private WebElement findL;
	
	@FindBy(xpath = "(//span[text()=\"Sign in\"])[1]")
	private WebElement signInbtn;

	@FindBy(name = "email")
	private WebElement userName;
	
	@FindBy(id = "continue")
	private WebElement continu;

	@FindBy(xpath = "//h4[text()=\"There was a problem\"]")
	private WebElement error;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(xpath = "//div[@class=\"s-suggestion-container\"]")
	private List<WebElement> searchList;

	
	public WebElement getFindL() {
		return findL;
	}

	public WebElement getSignInbtn() {
		return signInbtn;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getcontinu() {
		return continu;
	}

	public WebElement getError() {
		return error;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getSearchList() {
		return searchList;
	}

}
