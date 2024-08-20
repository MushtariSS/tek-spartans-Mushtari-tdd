package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {
    public SignInPage(){
        PageFactory.initElements(getDriver(),this);
    }

        @FindBy(id = "email")
        public WebElement email;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(id = "loginBtn")
    public WebElement loginBtn;

    @FindBy(id = "newAccountBtn")
    public WebElement createNewAccountBtn;




}
