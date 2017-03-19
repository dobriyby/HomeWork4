package webdriver.elements;

import org.openqa.selenium.By;
import com.dobriy.pages.TvCatalogPage;
import webdriver.BaseForm;

public class CatalogMenu extends BaseElement {

	private Button btnTV = new Button(By.xpath("//div[@class='catalog-bar']//li[4]"), "TV Button");

	public CatalogMenu(final By locator, final String name) {
		super(locator, name);
	}

	public CatalogMenu(String string, String name) {
		super(string, name);
	}

	public CatalogMenu(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.catalogmenu");
	}

	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}

	public BaseForm navigateTo(final String buttonName) {
		switch (buttonName) {
		case "Телевизоры":
			btnTV.click();
			return new TvCatalogPage();
		default:
			return null;
		}
	}

}
