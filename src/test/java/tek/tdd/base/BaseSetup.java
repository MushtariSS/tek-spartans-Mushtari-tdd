package tek.tdd.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

/**
 *
 */
//Read config file
//open browsers
//Quit
//Encapsulate
public abstract class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    protected static final long WAIT_IN_SECOND = 25;
    private static WebDriver driver;
    private final Properties properties;

    public BaseSetup() {
        //reading
        String ConfigFieldPath = System.getProperty("user.dir") + "src/test/java/configs/dev-config.properties";


        try {
            LOGGER.debug("Reading config file from path{}", ConfigFieldPath);
            InputStream inputStream = new FileInputStream(ConfigFieldPath);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException ioException) {
            LOGGER.error("Config file error with message{}", ioException.getMessage());
            throw new RuntimeException("Config file error with message" + ioException.getMessage());
        }
    }

    public void SetupBrowser() {
        String url = properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Openning on {} browser", browserType);
        LOGGER.info("is Headless on {}", isHeadless);

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (isHeadless) options.addArguments("--headless");
                driver = new ChromeDriver();
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Wrong browser type,Choose between chrome,firefox and egde");

        }
        LOGGER.info("Navigating to URL{}", url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_IN_SECOND));
    }

    public void quitBrowser() {
        if (driver != null) {
            LOGGER.info("Quiting the Browser");
            driver.quit();
        }

    }

    public WebDriver getDriver() {
        return driver;
    }
}


