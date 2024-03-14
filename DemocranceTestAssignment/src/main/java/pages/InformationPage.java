package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InformationPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@data-e2e=\"field-insured_age\"]")
    private WebElement dobInput;
    @FindBy(xpath = "(//div[@id=\"insured_age\"]//select)[2]")
    private WebElement dobYearDropdown;
    @FindBy(xpath = "(//div[@id=\"insured_age\"]//select)[1]")
    private WebElement dobMonthDropdown;
    @FindBy(xpath = "//div[@id=\"insured_age\"]//span[text()='11']/..")
    private WebElement dobDate;
    @FindBy(xpath = "//button[@data-e2e=\"buttonsBar-next\"]")
    private WebElement nextBtn;

    public InformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToNextPage(){
        dobInput.click();
        Select select = new Select(dobYearDropdown);
        select.selectByVisibleText("1990");
        select = new Select(dobMonthDropdown);
        select.selectByVisibleText("August");
        dobDate.click();
        nextBtn.click();
    }
}
