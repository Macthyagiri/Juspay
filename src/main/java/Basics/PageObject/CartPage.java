package Basics.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.Set;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//input[@placeholder='Enter delivery pincode']")
    WebElement pincodeField;

    @FindBy(xpath = "//span[text()='Check']")
    WebElement checkBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToProductWindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    public void addProductToCart() throws InterruptedException {
        Thread.sleep(4000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCartBtn);
    	addToCartBtn.click();
        Thread.sleep(2000);
    }

    public void enterPincode(String pincode) throws InterruptedException {
        pincodeField.sendKeys(pincode);
        checkBtn.click();
        Thread.sleep(2000);
    }
}