package ru.aplana.autotests.element;

import com.aplana.chameleon.elements.selenium.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends WebElementFacade {

    public Button(WebElement element, String elementName, String driverId) {
        super(element, elementName, driverId);
    }


    @Override
    public void click() {
        ((JavascriptExecutor) getDriver())
                .executeScript("return arguments[0].scrollIntoView(true)",  getWrappedElement());
		new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(
                        getWrappedElement())).click();
    }

	public String getErrorMsg() {
		return null;
	}

	public String getLabel() {
		return null;
	}
}
