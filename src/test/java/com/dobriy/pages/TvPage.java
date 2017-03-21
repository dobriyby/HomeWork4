package com.dobriy.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

public class TvPage extends BaseForm {

	private Label lblLable = new Label(By.xpath("//h1[contains(text(),'Телевизор')]"), "Lable Text");
	private Label lblPrice = new Label(By.className("offers-description__details"), "Prices Text");
	private Label lblYear = new Label(By.xpath("//td[contains(text(),'Дата выхода на рынок')]/../td[2]"), "Year Text");
	private Label lblDiagonal = new Label(By.xpath("//td[contains(text(),'Диагональ экрана')]/../td[2]"), "Diagonal Text");

	public TvPage() {
		super(By.xpath("//h1[contains(text(),'Телевизор')]"), "TV Page");
	}

	public void assertLable(final String lable) {
		assertTrue(lblLable.getText().contains(lable));
	}

	public void assertPrice(final String price) {
		Double newPrice = Double.parseDouble(price);
		String xpathPrice;
		if (lblPrice.getText().contains("Нет объявлений на б/у товар")) {
			xpathPrice = "price_primary";
		} else {
			xpathPrice = "price_secondary";
		}
		String[] arrayPrice = lblPrice.getElement()
				.findElement(By.xpath(".//div[contains(@class,'" + xpathPrice + "')]")).getText().replaceAll(",", ".")
				.split(" ");
		assertTrue(Double.parseDouble(arrayPrice[0]) <= newPrice);
	}

	public void assertYear(final String year) {
		assertTrue(Integer.parseInt(lblYear.getText().split(" ")[0])>=Integer.parseInt(year));
	}
	
	public void assertDiagonFrom(final String diagFrom) {
		Double diagFromD = Double.parseDouble(diagFrom.replace("\"", ""));
		Double diagCurD = Double.parseDouble(lblDiagonal.getText().replace("\"", ""));
		assertTrue(diagFromD <= diagCurD);
	}
	
	public void assertDiagonTo(final String diagTo){
		Double diagToD = Double.parseDouble(diagTo.replace("\"", ""));
		Double diagCurD = Double.parseDouble(lblDiagonal.getText().replace("\"", ""));
		assertTrue(diagToD>= diagCurD);
	}
	
	public void isCorrectPage(final String tvName){
		assertIsOpen();
		assertTrue(lblLable.getText().contains(tvName));
	}

}
