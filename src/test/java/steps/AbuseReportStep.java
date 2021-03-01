package steps;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SellerSearchPage;
import utils.BasePage;

import java.io.IOException;

import static utils.Driver.driver;
import static utils.Driver.setUpDriver;
import static utils.PropertyReader.prop;

public class AbuseReportStep extends BasePage {

    @BeforeTest
    public void setupDriverTest() throws IOException {
        setUpDriver();

    }
    @Test(priority=1)
    public void searchBoxClick()
    {
        SellerSearchPage sellerSearchPage=new SellerSearchPage(driver);
        waitABit(2000);
        sellerSearchPage.clickSearchBtn();

        sellerSearchPage.sendProductName();

        sellerSearchPage.clickSellerTab();

        Assert.assertTrue(sellerSearchPage.returnFirstElement().contains(prop.getProperty("storeName")));

        sellerSearchPage.clickStoreName();

        Assert.assertTrue(sellerSearchPage.returnStoreName().contains(prop.getProperty("storeName")));

        sellerSearchPage.clickProduct();

        Assert.assertTrue(sellerSearchPage.returnMobileName().contains(prop.getProperty("mobileName")));

        Assert.assertTrue(sellerSearchPage.returnMobileCost().contains(prop.getProperty("mobileCost")));

    }
}
