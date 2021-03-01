package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BasePage;

import java.util.List;

import static utils.PropertyReader.prop;

public class SellerSearchPage extends BasePage{

    public SellerSearchPage(AppiumDriver<WebElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @FindBy(id = "tv_search")
    WebElement searchbox;
    @FindBy(id = "et_search_box")
    WebElement searchbox2;
//    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
//    WebElement close;
    @FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Seller\"]/android.widget.TextView")
    WebElement sellertab;
    @FindBy(id = "tv_name")
    List<WebElement> storeName;
    @FindBy(id = "tv_name")
    WebElement shopName;
    @FindBy(id = "iv_product")
    WebElement productImage;
    @FindBy(id = "tv_product_name")
    WebElement mobilename;
    @FindBy(id = "tv_final_price")
    WebElement mobilecost;

    public void clickSearchBtn() {

       // click(close, 10);
        click(searchbox, 5);

        click(searchbox2,5);
    }
    public void sendProductName()
    {
        sendKeys(searchbox2,prop.getProperty("productName"),5);
    }
    public void clickSellerTab()
    {
        click(sellertab,5);
    }
    public String returnFirstElement()
    {
        return getTextWithIndex(storeName,4,5);
    }
    public void clickStoreName()
    {
       clickWithIndex(storeName,4,5);
    }
    public String returnStoreName()
    {
        return getText(shopName,5);
    }
    public  void clickProduct()
    {
        click(productImage,5);
    }
    public String returnMobileName()
    {
        return getText(mobilename,5);
    }
    public String returnMobileCost()
    {
        return getText(mobilecost,5);
    }


}
