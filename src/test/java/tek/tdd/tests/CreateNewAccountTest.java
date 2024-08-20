package tek.tdd.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.pages.AccountPage;
import tek.tdd.utility.DataGenerator;

public class CreateNewAccountTest extends UIBaseClass {
   @Test

   public void createNewAccountTest() {
       clickOnElement(homePage.signInLink);
       clickOnElement(signInPage.createNewAccountBtn);

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
    public void createNewAccountWithExistingEmail(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountBtn);
        createNewAccountPage.fillUpCreateAccountForm("Mushtari","angle@gmail.com","Romin2021");
        clickOnElement(createNewAccountPage.signUpBtn);

        String actualErrorMessage = getElementText(createNewAccountPage.errorMessage);
        Assert.assertEquals(actualErrorMessage, "this email is already exist, please use another email address");
    }





}
