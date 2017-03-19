package com.dobriy.pages;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.MainMenu;

public class MainPage extends BaseForm {
	
	private MainMenu menMain = new MainMenu(By.xpath("//ul[@class='b-main-navigation']"));

	public MainPage() {
		super(By.xpath("//div[contains(@class,'main-page-grid')]"), "Main Page");
	}
	
	public BaseForm clickOnMenu(final String menuName){
		return menMain.navigateTo(menuName);
	}

}
