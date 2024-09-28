package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.AccountPage;
import tek.tdd.pages.CreateNewAccountPage;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.SignInPage;
import tek.tdd.utility.SeleniumUtility;
@Listeners({ExtentITestListenerClassAdapter.class})
public class UIBaseClass extends SeleniumUtility {
        private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public SignInPage signInPage;
    public CreateNewAccountPage createNewAccountPage;
    public AccountPage accountPage;

        @BeforeMethod
        public void setupTests() {
            LOGGER.info("Setup Test and opening browser");
            SetupBrowser();
            homePage = new HomePage();
            signInPage= new SignInPage();
            createNewAccountPage = new CreateNewAccountPage();
            accountPage = new AccountPage();
        }

        @AfterMethod
        public void testCleanup(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
                TakesScreenshot screenshot = (TakesScreenshot) getDriver();
                String shot = screenshot.getScreenshotAs(OutputType.BASE64);

                ExtentTestManager.getTest()
                        .fail("Test Failed Taking screen shot" ,
                                MediaEntityBuilder.createScreenCaptureFromBase64String(shot).build());
            }
            LOGGER.info("running after each test and quite browser");
            quitBrowser();
        }
    public void validCredentialSignIn() {
        clickOnElement(homePage.signInLink);
        signInPage.doSignIn("angle@gmail.com" , "Romin0421!");
    }
    }



