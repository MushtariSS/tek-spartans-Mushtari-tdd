package tek.tdd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.pages.AccountPage;
import tek.tdd.utility.DataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateNewAccountTest extends UIBaseClass {
   @Test

   public void createNewAccountTest() {
       clickOnElement(homePage.signInLink);
       clickOnElement(signInPage.createNewAccountLink);

       String expectedEmail = DataGenerator.generateRandomEmail("angle");

       createNewAccountPage.fillUpCreateAccountForm("angle",
               expectedEmail,
               "Password@123");

       String actualEmail = getElementText(accountPage.accountEmailInfo);

       Assert.assertEquals(actualEmail, expectedEmail,
               "Profile Page should have same email as Created");
   }
   // Navigate to Create Account page and Create new Account With existing email and validate error message
    // "this email is already exist, please use another email address"
   @Test
    public void createNewAccountWithExistingEmail(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);
        createNewAccountPage.fillUpCreateAccountForm("Mushtari","angle@gmail.com","Romin2021");
        clickOnElement(createNewAccountPage.signUpBtn);

        String actualErrorMessage = getElementText(createNewAccountPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, "at least one special char");
    }
    //Story# 4.2
    //
    //Navigate to Create new Account page and click sign up button without filling the form
    //
    //Validate all errors on all fields.
    @Test
    public void validateErrorMessages(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);
        clickOnElement(createNewAccountPage.signUpBtn);
        /*String actualNameErrorMessage = getElementText(createNewAccountPage.NameErrorMessage);
        Assert.assertEquals(actualNameErrorMessage, "name is required field","error message");
        String actualEmailErrorMessage = getElementText(createNewAccountPage.emailErrorMessage);
        Assert.assertEquals(actualEmailErrorMessage, "email is required field","error message");
        String actualPasswordErrorMessage = getElementText(createNewAccountPage.PasswordErrorMessage);
        Assert.assertEquals(actualPasswordErrorMessage, "password is required field","error message");
        String actualConfirmPasswordErrorMessage = getElementText(createNewAccountPage.confirmPasswordErrorMessage);
        Assert.assertEquals(actualEmailErrorMessage, "confirm is required field","error message");
        */

            // Create a list of Expected Errors,
            //Get List of All Error Elements
            //Loop through and validate
        List<String> expectedError = Arrays.asList(
                "Name is a required field",
                "Email is a required field" ,
                "Password is a required field" ,
                "Confirm Password is a required field");

        List< WebElement> actualErrorElements = createNewAccountPage.fieldErrors;

        Assert.assertEquals(actualErrorElements.size(), expectedError.size());

        for (int i = 0; i < expectedError.size(); i++) {
            Assert.assertEquals(
                    getElementText(actualErrorElements.get(i)),
                    expectedError.get(i)
            );
        }
    }
        }










