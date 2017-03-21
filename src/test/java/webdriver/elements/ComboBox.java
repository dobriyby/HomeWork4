package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement {
	
	public ComboBox(final By locator, final String name) {
		super(locator, name);
	}

	public ComboBox(String string, String name) {
		super(string, name);
	}

	public ComboBox(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.combobox");
	}

	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}
	
	public void setOption(final String option){
		waitForIsElementPresent();
	    browser.getDriver().executeScript("arguments[0].style.border='3px solid red'", element);
	    new Select(element).selectByVisibleText(option);;
	}
}
