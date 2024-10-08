package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

import java.util.List;

public class CreateNewAccountPage extends SeleniumUtility {
    public CreateNewAccountPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(name = "name")
    public WebElement nameInput;

    @FindBy(id = "emailInput")
    public WebElement emailInput;
    @FindBy(id = "passwordInput")
    public WebElement passwordInput;
    @FindBy(id = "confirmPasswordInput")
    public WebElement confirmPasswordInput;

    @FindBy(id = "signupBtn")
    public WebElement signUpBtn;
    @FindBy(className = "error")
    public WebElement errorMessage;

    @FindBy(className = "error")
    public List<WebElement> fieldErrors;
    //public void fillUpCreateAccountErrorMessages(String nameErrorMessage,String emailErrorMessage,String passwordErrorMessage,String confirmPasswordErrorMessage){

    //}

public void fillUpCreateAccountForm(String name,String email,String password){
    sendText(nameInput,name);
    sendText(emailInput,email);
    sendText(passwordInput,password);
    sendText(confirmPasswordInput,password);


    clickOnElement(signUpBtn);

}
}
