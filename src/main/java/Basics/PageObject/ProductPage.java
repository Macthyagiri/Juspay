package Basics.PageObject;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProductPage {
    WebDriver driver;

    @FindBy(className = "wvIX4U")
    List<WebElement> productList;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFirstProduct() throws InterruptedException {
        productList.get(1).click();
        Thread.sleep(3000);
    }
}