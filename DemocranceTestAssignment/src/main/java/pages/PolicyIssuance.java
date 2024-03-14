package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PolicyIssuance {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Mr']")
    private WebElement titleMr;
    @FindBy(name = "full_name")
    private WebElement fullName;
    @FindBy(xpath = "//input[@data-e2e=\"field-nationality\"]")
    private WebElement nationality;
    @FindBy(xpath = "//div[@id=\"nationality\"]//span[text()='Algeria']/../..")
    private WebElement nationalityOptionAlgeria;
    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement email;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobile;
    @FindBy(xpath = "//input[@placeholder='(XXX-XXXX-XXXXXXX-X)']")
    private WebElement eid;
    @FindBy(xpath = "//input[@data-e2e=\"field-emirates_id_expiry_date\"]")
    private WebElement eidExpInput;
    @FindBy(xpath = "(//div[@id=\"emirates_id_expiry_date\"]//select)[2]")
    private WebElement eidExpYearDropdown;
    @FindBy(xpath = "(//div[@id=\"emirates_id_expiry_date\"]//select)[1]")
    private WebElement eidExpMonthDropdown;
    @FindBy(xpath = "//div[@id=\"emirates_id_expiry_date\"]//span[text()='11']/..")
    private WebElement eidExpDate;
    @FindBy(xpath = "//button[@data-e2e=\"buttonsBar-next\"]")
    private WebElement nextBtn;

    public PolicyIssuance(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToNext() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(titleMr));
        titleMr.click();
        fullName.sendKeys("Democrance Assignment");
        nationality.click();
        nationalityOptionAlgeria.click();
        email.sendKeys("test@test.com");
        mobile.sendKeys("568983399");
        eid.clear();
        eid.sendKeys("784-1000-0000000-0");
        eid.click();
        eidExpInput.click();
        Select select = new Select(eidExpYearDropdown);
        select.selectByVisibleText("2025");
        select = new Select(eidExpMonthDropdown);
        select.selectByVisibleText("August");
        eidExpDate.click();
        nextBtn.click();
    }
}
