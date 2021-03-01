package utils;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Driver.driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public void click(WebElement element,int maxTimeOut)
    {
        fluentWait(element, maxTimeOut);
        element.click();
    }
    public void fluentWait(WebElement element,int maxTime)
    {
        Wait wait= new FluentWait(Driver.driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sendKeys(WebElement element, String stringValue, int maxTimeout) {
        fluentWait(element, maxTimeout);
        element.sendKeys(stringValue);
    }
    public static void implicitWait(int timeOut)
    {
        Driver.driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }
    public void swipe(int startx,int starty,int endx,int endy,int duration)
    {
        System.out.println(
                "Swipe (" + startx + "," + starty + "," + endx + "," + endy + "," + duration + ")");
        new TouchAction(Driver.driver).press(new PointOption().withCoordinates(startx,starty))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(duration)))
                .moveTo(new PointOption().withCoordinates(endx,endy)).release().perform();
    }

    public String getText(WebElement element, int maxTimeout) {
        fluentWait(element, maxTimeout);
        return element.getText();
    }
    public static void waitABit(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getTextWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        return elements.get(index).getText();
    }
    public void clickWithIndex(List<WebElement> elements, int index, int maxTimeout) {
        fluentWait(elements.get(index), maxTimeout);
        elements.get(index).click();
    }
    public static void back() {
        driver.navigate().back();
    }



}
