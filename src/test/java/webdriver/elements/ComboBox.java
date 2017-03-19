package webdriver.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ComboBox extends BaseElement {
	
	private List<WebElement> listElem = getElement().findElements(By.xpath(".//option"));

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
		getElement().click();
		for (WebElement elem: listElem){
			if (elem.isDisplayed() && elem.getText().equals(option)){
				logger.info(getElementType()+" '"+name+"' :: "+getLoc("loc.is.select")+" '"+ elem.getText()+"'");
				elem.click();
				break;
			}
		}
	}
}
