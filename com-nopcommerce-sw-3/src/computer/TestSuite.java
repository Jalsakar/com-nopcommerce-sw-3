package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        Thread.sleep(2000);
        //1.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        Thread.sleep(2000);
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='details']/child::h2/a"));
        List<String> tempElements = new ArrayList<>();
        for (WebElement element : elements) {
            tempElements.add(element.getText());
        }
        System.out.println("Before sorting: " + tempElements);
        List<WebElement> afterSortingElements = driver.findElements(By.xpath("//div[@class='details']/child::h2/a"));
        List<String> tempAfterSortingElements = new ArrayList<>();
        for (WebElement element1 : afterSortingElements) {
            tempAfterSortingElements.add(element1.getText());
        }
        Thread.sleep(2000);
        Collections.sort(tempAfterSortingElements, Collections.reverseOrder());
        System.out.println("After sorting elements: " + tempAfterSortingElements);
        Thread.sleep(2000);
        Assert.assertTrue("Not sorted", tempElements.equals(tempAfterSortingElements));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        Thread.sleep(2000);
        // 2.2 Click on Desktop
        clickOnElement(By.xpath("//li[@class='active last']//a[normalize-space()='Desktops']"));
        Thread.sleep(2000);
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(2000);
        //2.4 Add to Cart
        clickOnElement(RelativeLocator.with(By.tagName("button")).below(By.xpath("//span[contains(text(),'$1,200.00')]")));
        Thread.sleep(2000);
        //2.5 Verify the Text "Build your own computer"
        verifyText("Invalid text", "Build your own computer", getTextElement(By.xpath("//h1[normalize-space()='Build your own computer']")));
        Thread.sleep(2000);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        Thread.sleep(2000);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        Thread.sleep(2000);
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        //2.11 Verify the price "$1,475.00"
        verifyText("Invalid price", "$1,475.00", getTextElement(By.id("price-value-1")));
        Thread.sleep(2000);
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        Thread.sleep(2000);
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("Invalid text", "The product has been added to your shopping cart", getTextElement(By.xpath("//p[@class='content']")));
        Thread.sleep(2000);
        //2.13.1 After that close the bar clicking on the cross button.
        clickOnElement(By.xpath(" //span[@title='Close']"));
        Thread.sleep(2000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElements(By.id("topcartlink"));
        Thread.sleep(2000);
        clickMouseHoverOnElements(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(2000);
        //2.15 Verify the message "Shopping cart"
        verifyText("Invalid text", "Shopping cart", getTextElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        Thread.sleep(2000);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clickOnElement(By.xpath("//td[@class='quantity']/child::input"));
        driver.findElement(By.xpath("//td[@class='quantity']/child::input")).clear();
        sendTextToElement(By.xpath("//td[@class='quantity']/child::input"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);
        //2.17 Verify the Total"$2,950.00"
        verifyText("Invalid price", "$2,950.00", getTextElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")));
        Thread.sleep(2000);
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Invalid text", "Welcome, Please Sign In!", getTextElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")));
        Thread.sleep(2000);
        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        Thread.sleep(2000);
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Karan");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Johar");
        sendTextToElement(By.id("BillingNewAddress_Email"), "karan286johar@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "India");
        sendTextToElement(By.id("BillingNewAddress_City"), "Surat");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "12,Happy Residency");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "3900232");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9727433803");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(2000);
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(2000);
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/descendant::a/following::button[1]"));
        Thread.sleep(2000);
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        Thread.sleep(2000);
        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Mr Karan Johar");
        sendTextToElement(By.id("CardNumber"), "5425233430109903");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "04");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        sendTextToElement(By.id("CardCode"), "676");
        Thread.sleep(2000);
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Invalid method", "Credit Card", getTextElement(By.xpath("//span[normalize-space()='Credit Card']")));
        Thread.sleep(2000);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Invalid method", "Next Day Air", getTextElement(By.xpath("//span[normalize-space()='Next Day Air']")));
        Thread.sleep(2000);
        //2.33 Verify Total is “$2,950.00”
        verifyText("Invalid total", "$2,950.00", getTextElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]")));
        Thread.sleep(2000);
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        Thread.sleep(2000);
        //2.35 Verify the Text “Thank You”
        verifyText("Invalid greeting", "Thank you", getTextElement(By.xpath("//h1[normalize-space()='Thank you']")));
        Thread.sleep(2000);
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Invalid order succes message", "Your order has been successfully processed!", getTextElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        Thread.sleep(2000);
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        Thread.sleep(2000);
        //2.37 Verify the text “Welcome to our store”
        verifyText("Invalid entry message on website", "Welcome to our store", getTextElement(By.xpath("//h2[normalize-space()='Welcome to our store']")));
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}