package tests;

import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EbayTest {

    private WebDriver driver;

    private HomePage homePage;
    private CellPhoneResultPage mobilePhonesPage;
    private AllPage allPhonesPage;
    private FirstResultPage firstResultPage;
    private CartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private NewWindow newWindow;


    @BeforeTest
    public  void setUp() {
        String exePath = System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        mobilePhonesPage = new CellPhoneResultPage(driver);
        allPhonesPage = new AllPage(driver);
        firstResultPage = new FirstResultPage(driver);
        shoppingCartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        newWindow = new NewWindow(driver);
    }

    @Test(priority = 0)
    public void goToURL() {

        homePage.openURL("https://www.ebay.com/");
        //Verify the correct page has loaded
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals(homePageURL, "https://www.ebay.com/", "Incorrect page has been loaded.");
        homePage.getElectronics();
        homePage.getAllPhones();
    }

    @Test(priority = 1)
    public void seeAll () {
        mobilePhonesPage.allMobilePhones();
    }

    @Test(priority = 2)
    public void selectFirstPhone() {
        allPhonesPage.selectFirstItem();
    }

    @Test(priority = 3)
    public void searchResultDetails() {
        firstResultPage.getPhoneName();
        firstResultPage.getPhonePrice();
        firstResultPage.getAllDetails();
    }

    @Test(priority = 4)
    public void openNewWindow(){
        newWindow.changeToNextWindow();
    }
    @Test(priority = 5)
    public void addToCart(){
        shoppingCartPage.clickAddToCart();
        shoppingCartPage.clickAddToCartIcon();
        shoppingCartPage.totalToPay();
        shoppingCartPage.goToCheckOut();
        shoppingCartPage.goToCheckOutAsGuest();
    }

    @Test(priority = 6)
    public void placeOrder(){
        
        checkoutPage.fillDetails();
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
