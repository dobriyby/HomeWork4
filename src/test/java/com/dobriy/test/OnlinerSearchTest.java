package com.dobriy.test;

import org.testng.xml.XmlTest;

import com.dobriy.pages.*;
import webdriver.BaseTest;

public class OnlinerSearchTest extends BaseTest {

	@Override
	public void runTest() {
		XmlTest curContext = context.getCurrentXmlTest();

		logStep();
		MainPage mainPage = new MainPage();
		mainPage.assertIsOpen();
		mainPage.clickOnMenu(curContext.getParameter("mainMenu"));

		logStep();
		CatalogPage catalogPage = new CatalogPage();
		catalogPage.assertIsOpen();
		catalogPage.clickOnCatalogMenu(curContext.getParameter("catalogMenu"));

		logStep();
		TvCatalogPage tvCatalogPage = new TvCatalogPage();
		tvCatalogPage.assertIsOpen();
		tvCatalogPage.getFilter().setLabel(curContext.getParameter("label"));
		tvCatalogPage.getFilter().setPriceTo(curContext.getParameter("price"));
		tvCatalogPage.getFilter().setDateTo(curContext.getParameter("year"));
		tvCatalogPage.getFilter().setDiagonalFrom(curContext.getParameter("diagonFrom"));
		tvCatalogPage.getFilter().setDiagonalTo(curContext.getParameter("diagonTo"));

		logStep();
		tvCatalogPage.resultTestContext("label", curContext.getParameter("label"))
					 .resultTestContext("price", curContext.getParameter("price"))
					 .resultTestContext("year", curContext.getParameter("year"))
					 .resultTestContext("diagonFrom", curContext.getParameter("diagonFrom"))
					 .resultTestContext("diagonTo", curContext.getParameter("diagonTo"));
		tvCatalogPage.resultTestStart();
	}
}
