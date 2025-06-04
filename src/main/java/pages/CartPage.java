package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddToCart(){
        WebElement addToCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='atcBtn_btn_1']"))
        );
        addToCart.click();
    }

    public void clickAddToCartIcon(){
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='https://cart.ebay.com']"))
        );
        cartIcon.click();
    }

    public void totalToPay(){
        WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-test-id='SUBTOTAL'] span.text-display-span")
        ));

        // Get the text
        String subtotal = subtotalElement.getText();
        System.out.println("Total: " + subtotal);
    }

    public void goToCheckOut(){
        WebElement goToCheckout = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, '/checkout')] | //button[contains(text(), 'Go to checkout')]")
        ));
        goToCheckout.click();
    }

    public void goToCheckOutAsGuest() {
        try {
            // Wait for the iframe that contains the guest checkout button
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("iframe[src*='signin']") // Adjust this if your iframe has a different URL pattern
            ));
            driver.switchTo().frame(iframe);

            // Wait and click the guest checkout button inside the iframe
            WebElement guestCheckout = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Check out as guest')] | //a[contains(text(), 'Check out as guest')]")
            ));
            guestCheckout.click();

        } catch (Exception e) {
            System.out.println("Error during guest checkout: " + e.getMessage());
        } finally {
            // Always switch back to default content
            driver.switchTo().defaultContent();
        }
    }
}
