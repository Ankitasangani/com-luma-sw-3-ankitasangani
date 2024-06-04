package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

/**
 * 5. Write down the following test into ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on Men Menu
 * * Mouse Hover on Bottoms
 * * Click on Pants
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size
 * 32.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour
 * Black.
 * * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product colour ‘Black’
 */

public class MenTest extends Utility {
    @Before
    public void setUp() {
        logIn(browser);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Men')]"));
        // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        // Click on Pants
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(pants).click().build().perform();
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.id("option-label-size-143-item-175"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour black
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.id("option-label-color-93-item-49"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.className("primary"));
        // Verify the text "You added Cronus Yoga Pant to your shopping cart."
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Text didn't match!", expectedText, actualText);
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text "Shopping Cart"
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Text didn't match!", expectedText1, actualText1);
        // Verify the product name "Cronus Yoga Pant"
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Text didn't match!", expectedText2, actualText2);
        // Verify the product size "32"
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Text didn't match!", expectedText3, actualText3);
        // Verify the product colour "Black"
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Text didn't match!", expectedText4, actualText4);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
