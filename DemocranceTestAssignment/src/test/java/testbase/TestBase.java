package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public Properties prop;

    private String propFilePath = System.getProperty("user.dir")+"/src/main/resources/config.properties";

    public void init(String browser) throws Exception {
        initProperty();
        if (browser.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            throw new RuntimeException(browser+" is not a valid browser type.");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void initProperty() throws Exception {
        prop = new Properties();
        prop.load(new FileReader(propFilePath));
    }

    public void tearDown(){
        driver.quit();
    }
}
