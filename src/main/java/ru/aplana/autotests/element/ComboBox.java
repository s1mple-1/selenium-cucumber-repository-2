package ru.aplana.autotests.element;

import com.aplana.chameleon.elements.selenium.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComboBox extends WebElementFacade {

    public ComboBox(WebElement element, String elementName, String driverId) {
        super(element, elementName, driverId);
    }


    @Override
    public void type(String value) {
		((JavascriptExecutor) getDriver())
			.executeScript("return arguments[0].scrollIntoView(true)",  getWrappedElement());
		getWrappedElement().click();
		getWrappedElement()
			.findElement(By.xpath(".//div[contains(@class,'choices__item')][contains(text(),'" + value + "')]")).click();
    }

	public String getErrorMsg() {
		return null;
	}

	public String getLabel() {
		return null;
	}
}
