package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AccountPage extends SeleniumUtility {
    public AccountPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "account__information-email")
    public WebElement accountEmailInfo;
    @FindBy(id = "nameInput")
    public WebElement NameInput;
    @FindBy(id="personalPhoneInput")
    public WebElement PersonalPhoneInput;
    @FindBy(className = "account__information-username")
    public WebElement accountUserNameText;
    @FindBy(id="personalUpdateBtn")
    public WebElement UpdateButton;

    public void updateNameAndPhone(String name, String phone) {
        sendText(NameInput, name);
        sendText(PersonalPhoneInput, phone);

        clickOnElement(UpdateButton);
    }
}
