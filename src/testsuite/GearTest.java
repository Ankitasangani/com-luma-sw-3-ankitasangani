package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 6.Write down the following test into ‘GearTest’ class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppingCart()
 * * Mouse Hover on Gear Menu
 * * Click on Bags
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change Qty 3
 * * Click on ‘Add to Cart’ Button.
 * * Verify the text
 * <p>
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on ‘shopping cart’ Link into
 * message
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change Qty to ‘5’
 * * Click on ‘Update Shopping Cart’ button
 * * Verify the product price ‘$225.00’
 */

public class GearTest extends Utility {
    @Before
    public void setUp() {
        logIn(browser);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        // Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // Verify the text "Overnight Duffle"
        Assert.assertEquals("Text didn't match!", "Overnight Duffle", getTextFromElement(By.xpath("//span[@class='base']")));
        // Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        // Verify the text "You added Overnight Duffle to your shopping cart."
        Assert.assertEquals("Text didn't match!", "You added Overnight Duffle to your shopping cart.", getTextFromElement(By.xpath("//div[@class='message-success success message']")));
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the product name "Overnight Duffle"
        Assert.assertEquals("Text didn't match!", "Overnight Duffle", getTextFromElement(By.xpath("//td[@class='col item']//strong[@class='product-item-name']")));
        // Verify the Qty is "3"
        Assert.assertEquals("Text didn't match!", "3", driver.findElement(By.xpath("//input[@class='input-text qty']")).getAttribute("value"));
        // Verify the product price "$135.00"
        Assert.assertEquals("Text didn't match!", "$135.00", getTextFromElement(By.cssSelector("td[class='col subtotal'] span[class='price']")));
        // Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.cssSelector("button[title='Update Shopping Cart'] span"));
        // Verify the product price "$225.00"
        Assert.assertEquals("Text didn't match!", "$225.00",getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
