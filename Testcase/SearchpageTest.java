package Testcase;

import org.testng.annotations.Test;

import com.pages.SearchPage;

import base.com.Baseclass;

public class SearchpageTest extends Baseclass{
	SearchPage sp;
	@Test
	public void tc1() {
		browserLanuch("https://www.amazon.in/");
		sp =new SearchPage(driver);
		sp.searchpage("one plus","one plus 11");
	}

}
