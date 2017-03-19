package webdriver.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Filter extends BaseElement {

	private List<WebElement> manufacturer = getElement()
			.findElementsByXPath("//span[contains(text(),'Производитель')]/../following-sibling::div//label");
	private TextBox txtPriceTo = new TextBox(By.xpath("//input[contains(@class,'input_price') and @placeholder='до']"),
			"Price to");
	private TextBox txtDateFrom = new TextBox(
			By.xpath("//input[contains(@class,'number-input') and @placeholder='2010']"), "Date to");
	private ComboBox cmbDiagonalFrom = new ComboBox(
			By.xpath("//span[(text()='Диагональ')]/../../div[3]/div/div[1]/select"), "Diagonal From");
	private ComboBox cmbDiagonalTo = new ComboBox(
			By.xpath("//span[(text()='Диагональ')]/../../div[3]/div/div[2]/select"), "Diagonal To");

	public Filter(final By locator, final String name) {
		super(locator, name);
	}

	public Filter(String string, String name) {
		super(string, name);
	}

	public Filter(By locator) {
		super(locator);
	}

	protected String getElementType() {
		return getLoc("loc.filter");
	}

	public boolean isEnabled() {
		return this.getElement().isEnabled();
	}

	public Filter setLabel(final String label) {
		for (WebElement elem : manufacturer) {
			if (elem.getText().equals(label)) {
			    browser.getDriver().executeScript("arguments[0].style.border='3px solid red'", elem);
				logger.info("Check Box \"" + elem.getText() + "\" is checked");
				elem.click();
				break;
			}
		}
		return this;
	}

	public Filter setPriceTo(final String price) {
		txtPriceTo.setText(price);
		return this;
	}

	public Filter setDateTo(final String date) {
		txtDateFrom.setText(date);
		return this;
	}

	public Filter setDiagonalFrom(final String diagonal) {
		cmbDiagonalFrom.setOption(diagonal);
		return this;
	}

	public Filter setDiagonalTo(final String diagonal) {
		cmbDiagonalTo.setOption(diagonal);
		return this;
	}
}
