package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest { //calling the BaseTest class to LoginTest class

    String baseUrl = "https://demo.nopcommerce.com/";  //URL

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    } //Method for launching the browser

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.linkText("Register")).click(); // click on register
        String expectedText = "Register"; // storing txt
        String actualText = driver.findElement(By.xpath("//h1")).getText().trim(); // storing actual text
        Assert.assertEquals(expectedText, actualText);  // Comparing actual and expected text
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        Random randomGenerator = new Random(); // generating random number
        int randomInt = randomGenerator.nextInt(1000); //storing the random number
        driver.findElement(By.linkText("Register")).click(); // click on register
        driver.findElement(By.id("gender-male")).click(); // selecting the male
        driver.findElement(By.id("FirstName")).sendKeys("Vishal"); //entering name
        driver.findElement(By.id("LastName")).sendKeys("Bond"); // surname
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("2"); //selecting date
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January"); // selecting month
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1990"); // selecting year
        driver.findElement(By.id("Email")).sendKeys("username" + randomInt + "@gmail.com"); //generating random email
        driver.findElement(By.id("Company")).sendKeys("Prime");//entering company name
        driver.findElement(By.id("Password")).sendKeys("Password1234@"); //entering password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Password1234@"); //confirmed password
        driver.findElement(By.id("register-button")).click(); // click
        String expectedText = "Your registration completed"; // expected text
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText(); // actual text
        Assert.assertEquals(expectedText,actualText); // comparing text
    }

    @After
    public void tearDown() {
        closeBrowser();
    } // closing browser
}
