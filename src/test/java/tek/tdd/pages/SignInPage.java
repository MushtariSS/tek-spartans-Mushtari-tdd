package tek.tdd.pages;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {
    public SignInPage(){
        PageFactory.initElements(getDriver(),this);
    }

        @FindBy(id = "email")
        public WebElement emailInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(className = "error")
    public WebElement errorMessage;
    @FindBy(linkText = "Create New Account")
    public WebElement createNewAccountLink;
    @FindBy(id = "loginBtn")
    public WebElement loginButton;
    public void doSignIn(String email, String password) {
        ExtentTestManager.getTest()
                .info("Signin In with " + email + " And " + password);
        sendText(emailInput, email);
        sendText(passwordInput, password);
        clickOnElement(loginButton);
    }




}
