package Basics.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement loginbutton;
    
    @FindBy(xpath = "//input[@class='r4vIwl BV+Dqf']")
    WebElement mobileField;
    
    @FindBy(xpath = "//button[normalize-space()='Request OTP']")
    WebElement otpButton;

    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithMobile(String mobileNo) throws Exception {
    	Thread.sleep(4000);
    	loginbutton.click();
    	mobileField.sendKeys(mobileNo);
    	Thread.sleep(4000);
    	otpButton.click();
        System.out.println("OTP requested. Please enter OTP manually in browser.");
        System.out.println("Execution paused for OTP entry...");
        Thread.sleep(20000); // Wait 20 seconds for manual OTP entry
        System.out.println("Resuming test execution after OTP entry...");
    }
}