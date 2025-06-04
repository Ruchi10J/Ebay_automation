package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public  AllPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFirstItem(){
        // Wait for the product grid to be visible
        WebElement firstItem = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-prp-top-products_grid']//a[@data-testid='ux-action'])[1]"))
        );

        // Scroll into view if needed
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstItem);

        // Click the first product
        firstItem.click();
    }
}
