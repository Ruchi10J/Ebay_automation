package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public  HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void openURL(String url) {
        driver.get(url); // URL

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    public void getElectronics(){
        // Locate the 'Electronics' menu
        WebElement electronicsMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Electronics']"))
        );

        // Hover over the 'Electronics'
        actions.moveToElement(electronicsMenu).perform();
    }

    public void getAllPhones(){
        // Wait for and click 'Cell Phones & Smartphones'
        WebElement cellPhonesOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Smartphones and accessories']"))
        );
        cellPhonesOption.click();
    }

}
