package Basics.Test;

import org.testng.annotations.*;

import Basics.PageObject.*;
import Basics.Common.BaseTest;

public class FlipkartBuyProductTest extends BaseTest {
    LoginPage login;
    HomePage home;
    ProductPage product;
    CartPage cart;

    @DataProvider(name = "productData")
    public Object[][] getData() {
        return new Object[][] {
            {"7036007030", "T Shirt", "500032"} // mobile, product, pincode
        };
    }

    @Test(dataProvider = "productData")
    public void buyProductFlow(String mobile, String productName, String pincode) throws Exception {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);

        login.loginWithMobile(mobile);
        home.searchProduct(productName);
        product.selectFirstProduct();
        cart.switchToProductWindow();
        cart.addProductToCart();
        cart.enterPincode(pincode);
    }
}