package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest { // calling class
    String baseUrl = "https://demo.nopcommerce.com/"; // base url

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } // opening browser

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.linkText("Computers")).click();
        String expectedResult = "Computers";
        WebElement actualResultElement = driver.findElement(By.xpath("//h1"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.linkText("Electronics")).click();
        String expectedText = "Electronics";
        WebElement actualText = driver.findElement(By.xpath("//h1"));
        String actualTextResult = actualText.getText();
        Assert.assertEquals(actualTextResult, expectedText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.linkText("Apparel")).click();
        String expectedText = "Apparel";
        WebElement actualText = driver.findElement(By.xpath("//h1"));
        String actualTextResult = actualText.getText();
        Assert.assertEquals(actualTextResult, expectedText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")).click();
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.linkText("Books")).click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.linkText("Jewelry")).click();
        String expectedText = "Jewelry ";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.linkText("Gift Cards")).click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser(); // closing browser
    }
}
