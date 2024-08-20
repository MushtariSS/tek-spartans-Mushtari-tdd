package tek.tdd.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "top_nav__logo")
    public WebElement topLeftLogo;

    @FindBy(id = "signinLink")
    public WebElement signInLink;

    @FindBy(id = "accountLink")
    public WebElement accountLink;
   public static final By SING_IN_LINK = By.id("signinLink");
    //public static final By ACCOUNT_LINK = By.id("accountLink");
}
