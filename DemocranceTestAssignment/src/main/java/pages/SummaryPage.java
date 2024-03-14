package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SummaryPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@data-e2e=\"buttonsBar-next\"]")
    private WebElement nextBtn;
    @FindBy(xpath = "//span[normalize-space()='Generate Invoice']")
    private WebElement generateInvoice;
    @FindBy(xpath = "//input[@placeholder='Payment Reference']")
    private WebElement paymentRefNo;
    @FindBy(xpath = "//span[normalize-space()='Continue']")
    private WebElement continueBtn;

    public SummaryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedNext() throws InterruptedException {
        try{
            Thread.sleep(2000);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", nextBtn);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            nextBtn.click();
            wait.until(ExpectedConditions.visibilityOf(generateInvoice));
            generateInvoice.click();
            wait.until(ExpectedConditions.visibilityOf(paymentRefNo));
            paymentRefNo.sendKeys("12232");
            continueBtn.click();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
