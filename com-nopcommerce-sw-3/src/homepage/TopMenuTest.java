package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1.1 Create method with name "selectMenu" it has one parameter name "menu" of type string
     * 1.2 This method should click on the menu whatever name is passed as parameter.
     * 1.3.Create the @Test method name verifyPageNavigation.
     * Use selectMenu method to select the Menu and click on it and verify the page navigation.
     */
    public void selectMenu(String menu) {
        List<WebElement> selectMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : selectMenu) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        verifyText("Invalid title", "Computers", getTextElement(By.xpath("//h1[contains(text(),'Computers')]")));
        selectMenu("Electronics");
        verifyText("Invalid title", "Electronics", getTextElement(By.xpath("//h1[contains(text(),'Electronics')]")));
        selectMenu("Apparel");
        verifyText("Invalid title", "Apparel", getTextElement(By.xpath("//h1[contains(text(),'Apparel')]")));
        selectMenu("Digital downloads");
        verifyText("Invalid title", "Digital downloads", getTextElement(By.xpath("//h1[contains(text(),'Digital downloads')]")));
        selectMenu("Books");
        verifyText("Invalid title", "Books", getTextElement(By.xpath("//h1[contains(text(),'Books')]")));
        selectMenu("Jewelry");
        verifyText("Invalid title", "Jewelry", getTextElement(By.xpath("//h1[contains(text(),'Jewelry')]")));
        selectMenu("Gift Cards");
        verifyText("Invalid title", "Gift Cards", getTextElement(By.xpath("//h1[contains(text(),'Gift Cards')]")));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}