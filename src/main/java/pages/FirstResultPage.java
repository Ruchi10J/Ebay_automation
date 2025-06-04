package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstResultPage {
    public WebDriver driver;
    protected WebDriverWait wait;

    public FirstResultPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getPhoneName(){
        WebElement itemTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(@class, 'x-item-title__mainTitle')]//span")
        ));
        System.out.println("Item Name: " + itemTitle.getText());
    }

    public void getPhonePrice(){
        WebElement itemPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-testid='x-price-primary']//span")
        ));
        System.out.println("Item Price: " + itemPrice.getText());
    }

    public void getAllDetails(){
        WebElement seeDetails = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(., 'See all details')]")
        ));
        seeDetails.click();
    }
}