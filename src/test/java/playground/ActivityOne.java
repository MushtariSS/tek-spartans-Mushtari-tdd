package playground;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityOne {
    public WebDriver driver;
    @BeforeMethod
    public void setUpTest() {
         driver = new ChromeDriver();
        driver.get("https://facebook.com");
    }
    @Test
    public void testFacebookTitle(){
        String applicationTitle = driver.getTitle();
        Assert.assertEquals(applicationTitle, "Facebook - log in or sign up");
    }

    @AfterMethod
    public void cleanupTest() {
        driver.quit();
    }
    }




