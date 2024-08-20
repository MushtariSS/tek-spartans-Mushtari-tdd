package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class SecurityTest extends UIBaseClass {

    @Test
    public void validateSigIn(){
        clickOnElement(homePage.signInLink);
        sendText(signInPage.email,"angle@gmail.com");
        sendText(signInPage.password,"Romin2021!");
        clickOnElement(signInPage.loginBtn);
        boolean isDisplayed = isElementDisplayed(homePage.accountLink);
        Assert.assertTrue(isDisplayed,"Looking for account Link to be displayed after login");

    }
@Test
    public void navigateViaSigInTest(){
        clickOnElement(homePage.signInLink);
        sendText(signInPage.email,"angle1@gmail.com");

}
//CreateAccountTest
//
//Story 4: Navigate to Create Account page and Create new Account
//
//Validate New Account Created.



}
