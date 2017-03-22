package com.dobriy.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dobriy.pages.elements.Filter;

import webdriver.BaseForm;

public class TvCatalogPage extends BaseForm {
	
	private Filter filter = new Filter(By.xpath("//*[@id='schema-filter']"), "Tv Catalog Filter");
	private Map<String, String> listTestTask = new HashMap<String, String>();

	public TvCatalogPage() {
		super(By.xpath("//h1[text()='Телевизоры']"), "TvCatalog Page");
	}

	public Filter getFilter() {
		return filter;
	}

	public TvCatalogPage resultTestContext(String type, String value) {
		listTestTask.put(type, value);
		return this;
	}
	
	/*
	 *  Уверен, тут есть костыли, но в мометны, когда onliner лагал, они меня спасали 
	 */
	public void resultTestStart() {
		if (listTestTask.size() > 0) {
			new Actions(browser.getDriver()).keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).perform();
			assertIsOpen();
			(new WebDriverWait(browser.getDriver(),30)).until(ExpectedConditions.attributeToBe(By.id("schema-products"), "class", "schema-products"));
			List<WebElement> listResult = browser.getDriver().findElements(By.xpath("//div[@class='schema-product__title']/a"));
			for (WebElement elem : listResult) {
				String modelName= elem.getText();
				info("Test "+modelName+" is start!");	
			    browser.getDriver().executeScript("arguments[0].style.border='3px solid red'", elem);
				elem.click();
				switchHandle();
				TvPage tvPage = new TvPage();
				testPage(tvPage, modelName);
				browser.getDriver().close();
				switchHandle();
			}
		}
	}
	
	private void switchHandle(){
		for (String winHandle : browser.getDriver().getWindowHandles()) {
			browser.getDriver().switchTo().window(winHandle);
		}
	}
	
	private void testPage(TvPage tvPage, String modelName){
		tvPage.isCorrectPage(modelName);
		for (Entry<String, String> task : listTestTask.entrySet()) {
			switch (task.getKey()) {
			case "label":
				tvPage.assertLable(task.getValue());
				info("	Label test SUCCESS! ");
				break;
			case "price":
				tvPage.assertPrice(task.getValue());
				info("	Price test SUCCESS! ");
				break;
			case "diagonFrom":
				tvPage.assertDiagonFrom(task.getValue());
				info("	DiagoFrom test SUCCESS! ");
				break;
			case "diagonTo":
				tvPage.assertDiagonTo(task.getValue());
				info("	DiagoTo test SUCCESS! ");
				break;
			case "year":
				tvPage.assertYear(task.getValue());
				info("	Year test SUCCESS! ");
				break;
			default:
				info(task.getValue() + " not found");
				break;
			}
		}
	}

}
