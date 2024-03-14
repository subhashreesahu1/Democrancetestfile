package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import testbase.TestBase;

public class PolicyJourneyTest extends TestBase {

    InformationPage ip;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void initApp(String browser) throws Exception {
        init(browser);
        ip = new InformationPage(driver);
    }

    @Test
    public void policyJourneyTest() throws Exception {
        ip.proceedToNextPage();

        QuotePage quotePage = new QuotePage(driver);
        quotePage.proceedToNextPage();

        PolicyIssuance policyIssuance = new PolicyIssuance(driver);
        policyIssuance.proceedToNext();

        SummaryPage summaryPage = new SummaryPage(driver);
        summaryPage.proceedNext();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        boolean isSuccess = confirmationPage.isSuccess();
        Assert.assertTrue(isSuccess);
        confirmationPage.downloadDoc();
    }

    @AfterClass(alwaysRun = true)
    public void browserClose(){
        tearDown();
    }
}
