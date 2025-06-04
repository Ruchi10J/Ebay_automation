package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CellPhoneResultPage {

    protected WebDriver driver;
    WebDriverWait wait;

    public CellPhoneResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void allMobilePhones(){

        WebElement AllItems = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[span[contains(text(), 'See All')]]"))
        );
        AllItems.click();
    }
}
