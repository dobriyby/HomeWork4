package com.dobriy.pages.elements;

import org.openqa.selenium.By;

import com.dobriy.pages.CatalogPage;

import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Button;

public class MainMenu extends BaseElement {

	private Button btnCatalog = new Button(By.xpath("//ul[@class='b-main-navigation']//span[contains(text(),'Каталог')]"), "Catalog Button");

	public MainMenu(final By locator, final String name) {
		super(locator, name);
	}

	public MainMenu(String string, String name) {
		super(string, name);
	}

	public MainMenu(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.mainmenu");
	}

	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}

	public BaseForm navigateTo(final String buttonName) {
		switch (buttonName) {
		case "Каталог":
			btnCatalog.click();
			return new CatalogPage();
		default: return null;
		}
	}

}
