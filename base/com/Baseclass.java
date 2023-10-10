package base.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	protected WebDriver driver;

	public void browserLanuch(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);

	}

	public void btnclick(WebElement element) {
		element.click();

	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}
	public String getTexts(List<WebElement> element) {
		List<WebElement> elements = element;
        for (WebElement element1 : elements) {
            String elementText = element1.getText();
            System.out.println(elementText);
        }
		return null;
		
	}
	
	public WebElement clickEqual(List<WebElement> elements, String textToMatch) {
	    for (WebElement element : elements) {
	        String elementText = element.getText();
	        if (elementText.equals(textToMatch)) {
	            element.click(); 
	            return element; 
	        }
	    }
	    
	    return null; 
	}

	
	public WebElement mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		return element;

	}

	public WebElement findLocatorById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findLocatorByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public WebElement findLocatorByClassName(String data) {
		WebElement element = driver.findElement(By.className(data));
		return element;
	}

	public WebElement findLocatorByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public String gettitle() {
		String title = driver.getTitle();
		return title;

	}

	public void closebrowser() {
		driver.close();
	}

	public void closeallbrowser() {
		driver.quit();

	}

	public void alertByAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public void alertByDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		;

	}

	public void alertBySendkeys(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}
	

	public void selectByIndex(WebElement element, int indexnum) {
		Select s = new Select(element);
		s.selectByIndex(indexnum);
	}

	public void selectByValue(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public void selectByVisibletext(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public void deselectByIndex(WebElement element, int indexnum) {
		Select s = new Select(element);
		s.deselectByIndex(indexnum);
	}

	public void deselectByValue(WebElement element, String data) {
		Select s = new Select(element);
		s.deselectByValue(data);
	}

}
