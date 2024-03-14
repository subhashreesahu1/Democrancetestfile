package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuotePage {

    private WebDriver driver;

    @FindBy(xpath = "(//span[@class=\"check is-info\"])[1]")
    private WebElement tnc;
    @FindBy(xpath = "(//span[@class=\"check is-info\"])[2]")
    private WebElement quoteTnc;
    @FindBy(xpath = "//button[@data-e2e=\"buttonsBar-next\"]")
    private WebElement nextBtn;

    public QuotePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToNextPage() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(tnc));
        tnc.click();
        quoteTnc.click();
        nextBtn.click();
    }
}
