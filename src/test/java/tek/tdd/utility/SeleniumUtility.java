package tek.tdd.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtility extends BaseSetup {
    private WebDriverWait getWait() {
        return  new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
    private WebElement waitForVisibility (By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnElement (By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendKeysToElement (By locator, String value) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }
    public String getElementText (By locator){
        return waitForVisibility(locator).getText();
    }
    public boolean  isElementEnabled(By locator){
        return waitForVisibility(locator).isEnabled();
    }
    public boolean isElementDisplayed(By locator) {
        return waitForVisibility(locator).isDisplayed();
    }


}
