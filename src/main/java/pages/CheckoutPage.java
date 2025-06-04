package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillDetails(){

        // Fill in First Name
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName"))).sendKeys("Rashmika");

        // Fill in Last Name
        driver.findElement(By.id("lastName")).sendKeys("Tester");

        // Fill in Street Address
        driver.findElement(By.id("addressLine1")).sendKeys("123 Selenium Lane");

        // Fill in Street Address 2 (optional)
        driver.findElement(By.id("addressLine2")).sendKeys("Apt 4B");

        // Fill in City
        driver.findElement(By.id("city")).sendKeys("Testville");

        // Fill in State/Province/Region
        driver.findElement(By.id("stateOrProvince")).sendKeys("California");

        // Fill in ZIP Code
        driver.findElement(By.id("postalCode")).sendKeys("90001");

        // Fill in Email
        driver.findElement(By.id("email")).sendKeys("rashmika@example.com");

        // Confirm Email
        driver.findElement(By.id("emailConfirm")).sendKeys("rashmika@example.com");

        // Fill in Phone Number
        driver.findElement(By.id("phoneNumber")).sendKeys("1234567890");
    }
}
