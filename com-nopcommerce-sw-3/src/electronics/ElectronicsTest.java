package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
//1.1 Mouse Hover on “Electronics” Tab
        mouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Thread.sleep(2000);
//1.2 Mouse Hover on “Cell phones” and click
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(2000);
//1.3 Verify the text “Cell phones”
        verifyText("Invalid text", "Cell phones", getTextElement(By.xpath("//h1[normalize-space()='Cell phones']")));
        Thread.sleep(2000);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
// 2.1       Mouse Hover on “Electronics” Tab
        mouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Thread.sleep(2000);
//2.2 Mouse Hover on “Cell phones” and click
        clickMouseHoverOnElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(2000);
//2.3 Verify the text “Cell phones”
        verifyText("Invalid text", "Cell phones", getTextElement(By.xpath("//h1[normalize-space()='Cell phones']")));
        Thread.sleep(2000);
//2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        Thread.sleep(2000);
//2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
//2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(2000);
        verifyText("Invalid text", "Nokia Lumia 1020", getTextElement(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']")));
//2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        verifyText("Invalid price", "$349.00", getTextElement(By.id("price-value-20")));
//2.8 Change quantity to 2
        Thread.sleep(2000);
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        Thread.sleep(2000);
//2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        Thread.sleep(2000);
//2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Invalid message", "The product has been added to your shopping cart", getTextElement(By.xpath("//div[@class='bar-notification success']")));
        Thread.sleep(2000);
//After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);
//2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElements(By.xpath("//a[@class='ico-cart']"));
        Thread.sleep(2000);
        clickMouseHoverOnElements(By.xpath("//button[normalize-space()='Go to cart']"));
//2.12 Verify the message "Shopping cart"
        Thread.sleep(2000);
        verifyText("Invalid message", "Shopping cart", getTextElement(By.xpath("//h1[normalize-space()='Shopping cart']")));
//2.13 Verify the quantity is 2
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        String qty = text.getAttribute("value");
        Assert.assertEquals("Invalid quantity", "2", qty);
//2.14 Verify the Total $698.00
        Thread.sleep(2000);
        verifyText("Invalid total price", "$698.00", getTextElement(By.xpath("//td[@class='subtotal']")));
//2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));
//2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
//2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Invalid title", "Welcome, Please Sign In!", getTextElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
//2.18 Click on “REGISTER” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
//2.19 Verify the text “Register”
        Thread.sleep(2000);
        verifyText("Invalid register text", "Register", getTextElement(By.xpath("//h1[normalize-space()='Register']")));
//2.20 Fill the mandatory fields
        Thread.sleep(2000);
        sendTextToElement(By.id("FirstName"), "Karan");
        sendTextToElement(By.id("LastName"), "Johar");
        sendTextToElement(By.id("Email"), "karan286johar@gmail.com");
        sendTextToElement(By.id("Password"), "9081811670@Dv");
        sendTextToElement(By.id("ConfirmPassword"), "9081811670@Dv");
        Thread.sleep(2000);
//2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        Thread.sleep(2000);
//2.22 Verify the message “Your registration completed”
        verifyText("Invalid result", "Your registration completed", getTextElement(By.xpath("//div[@class='result']")));
        Thread.sleep(2000);
//2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);
//2.24 Verify the text “Shopping card”
        verifyText("Invalid text", "Shopping cart", getTextElement(By.xpath("//div[@class='page-title']/h1")));
        Thread.sleep(2000);
//2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);
//2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
//2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Karanaa");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Joharaa");
        sendTextToElement(By.id("BillingNewAddress_Email"), "karanaa28joharaa@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "India");
        sendTextToElement(By.id("BillingNewAddress_City"), "Ankleshwar");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "19,Happy Residency");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "3900232");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9727433813");
        Thread.sleep(2000);
//2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);
//2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        Thread.sleep(2000);
//2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(2000);
//2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
//2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        Thread.sleep(2000);
//2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr Harsh Johar");
        sendTextToElement(By.id("CardNumber"), "4263982640269299");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "837");
        Thread.sleep(2000);
//2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
//2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Invalid method", " Credit Card ", getTextElement(By.xpath("//span[normalize-space()='Credit Card']")));
        Thread.sleep(2000);
//2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("Invalid text", "Shipping Method: 2nd Day Air", getTextElement(By.xpath("//li[@class='shipping-method']")));
        Thread.sleep(2000);
//2.37 Verify Total is “$698.00”
        verifyText("Invalid price", "$698.00", getTextElement(By.xpath("//td[@class='subtotal']")));
        Thread.sleep(2000);
//2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        Thread.sleep(2000);
//2.39 Verify the Text “Thank You”
        verifyText("Invalid greeting", "Thank you", getTextElement(By.xpath("//h1[normalize-space()='Thank you']")));
        Thread.sleep(2000);
//2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Invalid order success message", "Your order has been successfully processed!", getTextElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        Thread.sleep(2000);
//2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        Thread.sleep(2000);
//2.42 Verify the text “Welcome to our store”
        verifyText("Invalid entry message on website", "Welcome to our store", getTextElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
        Thread.sleep(2000);
//2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        Thread.sleep(2000);
//2.44 Verify the URL is “https://demo.nopcommerce.com/”
        verifyText("Invalid Url", "https://demo.nopcommerce.com/", driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}