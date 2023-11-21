package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest { //calling the BaseTest class to LoginTest class
    String baseUrl = "https://demo.nopcommerce.com/";  //URL

    @Before
    public void setUp() {
        openBrowser(baseUrl); //Method for launching the browser
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Log in")).click(); // clicking login button
        String expectedText = "Welcome, Please Sign In!";  //Storing expected Text
        WebElement actualTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = actualTextElement.getText(); // storing actual Text
        Assert.assertEquals("Not redirected to the login page", expectedText, actualText);  // Comparing actual and expected text
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click(); //Registering
        driver.findElement(By.id("Email")).sendKeys("vishal@gmail.com"); // entering email
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password"); //entering password
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button']")).click(); //click on log in
        String expectedLogoutText = "Log out"; //Storing expected Text
        String actualLogOutText = driver.findElement(By.xpath("//a[@class='ico-logout']")).getText(); // storing actual Text
        Assert.assertEquals(expectedLogoutText,actualLogOutText); // Comparing actual and expected text

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.linkText("Log in")).click(); //click on log in
        driver.findElement(By.id("Email")).sendKeys("vhal@gmail.com"); // entering email
        driver.findElement(By.id("Password")).sendKeys("prime123"); //entering password
        driver.findElement(By.xpath("//button[starts-with(@class,'button-1 login')]")).click();  //click on log in
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" + //Storing expected Text
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();// storing actual Text
        Assert.assertEquals(expectedText, actualErrorMessage); // Comparing actual and expected text
    }
    @After
    public void tearDown() {
        closeBrowser();
    } //closing the browser
}
