package pages;

import org.openqa.selenium.WebDriver;

public class NewWindow {

    protected WebDriver driver;

    public NewWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void changeToNextWindow(){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
