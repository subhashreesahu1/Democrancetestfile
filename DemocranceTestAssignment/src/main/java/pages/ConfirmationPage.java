package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Download Policy schedule']")
    private WebElement downLoadBtn;
    @FindBy(xpath = "//h1[@class='title block']")
    private WebElement successMsg;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void downloadDoc() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(downLoadBtn));
        downLoadBtn.click();
        wait.until(ExpectedConditions.visibilityOf(downLoadBtn));
    }

    public boolean isSuccess(){
        return successMsg.isDisplayed();
    }
}
