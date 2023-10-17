package baseplaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.List;
public class BaseClassPW {
	Playwright playwright;
	Page page;
	BrowserContext context;
	Browser browser;
	
	//opening Cross browser
	public Page launchBrowser(String browserName,String site) {
		 playwright = Playwright.create();
		 
		 switch (browserName.toLowerCase()) {
		case "chromium":
			playwright.chromium().launch(new LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
		case "safari":
			playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			playwright.chromium().launch(new LaunchOptions()
					.setChannel("chrome")
					.setHeadless(false));
			break;

		default:
			System.out.println("please pass correct browserName....");
			break;
		}
		 
	   	 context = browser.newContext();
		 page = context.newPage();
	     page.navigate(site);
		return page;
	}
	
	//input/fill
	public void enterText(Locator locator, String text) {
		locator.fill(text);

	}
	
	
	//btnclick
	public void btnClick(Locator locator) {
		locator.click();
	}
	
	//pagetitle
	public String getPageTitle() {
		return page.title();
	}
	
	//page url
	public String getPageurl() {
		return page.url();
	}
	
	//check title
	public void checkTitle(String text) {
		assertThat(page).hasTitle(text);
	}
	
	public void CheckText(Locator locator, String TextGot) {
		assertThat(locator).hasText(TextGot);
	}

	//closing all
	public void closepage() {
		page.close();
	}
	public void closebrowser() {
		browser.close();
	}
	public void closeplaywright() {
		playwright.close();
	}
	
	//screenshot fn
	public void screenshot(String path) {
		page.screenshot(new ScreenshotOptions().setPath(Paths.get(path)));
	}
	
	public void screenshotFullPage(String path) {
		page.screenshot(new ScreenshotOptions().setFullPage(true).setPath(Paths.get(path)));
	}
	
	public void screenshotLocator(Locator locator, String path) {
		locator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));
	}
     //get text
	public String getText(Locator locator) {
		String text = locator.innerText();
		return text;

	}
	//gettexts
	public String getTexts(Locator locators) {
		List<String> allInnerTexts = locators.allInnerTexts();
		allInnerTexts.forEach(locator -> 
		{System.out.println(locator);
		});
		return null;
	}
	
	//click equal texts in dropdown
//	public String clickEqual(Locator locators,String textToMatch) {
//		
//		return null;
//		
//	}

}
