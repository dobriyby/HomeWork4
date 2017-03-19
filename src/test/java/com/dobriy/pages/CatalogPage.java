package com.dobriy.pages;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.CatalogMenu;

public class CatalogPage extends BaseForm {

	private CatalogMenu menCatalog = new CatalogMenu(By.className("catalog-bar-main"), "Catalog Menu");

	public CatalogPage() {
		super(By.xpath("//h1[text()='Каталог']"), "Catalog Page");
	}

	public void clickOnCatalogMenu(final String buttonName) {
		menCatalog.navigateTo(buttonName);
	}

}
