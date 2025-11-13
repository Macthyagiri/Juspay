package Basics.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage {
    WebDriver driver;

    
    @FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
    WebElement searchButton;
    

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) throws InterruptedException {
    	searchButton.clear();
    	searchButton.sendKeys(product);
    	searchButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
}