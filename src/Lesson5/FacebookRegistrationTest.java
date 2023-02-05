package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookRegistrationTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/lesson3/sources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void goToRegistrationScreen() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        WebElement regButton = driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]"));
        regButton.click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void fillInAllFields() throws InterruptedException {
        WebElement firstName = driver.findElement(By.xpath("(//*[@id=\"fullname_field\"]//input)[1]"));
        firstName.sendKeys("Serega");
        WebElement lastName = driver.findElement(By.xpath("(//*[@id=\"fullname_field\"]//input)[2]"));
        lastName.click();
        lastName.sendKeys("Automashevkiy");
        WebElement email = driver.findElement(By.xpath("(//*[@id=\"reg_form_box\"]//input)[3]"));
        email.click();
        email.sendKeys("+380957778899");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password_step_input\"]"));
        password.click();
        password.sendKeys("Privet@123");
        WebElement day = driver.findElement(By.cssSelector("select#day"));
        day.sendKeys("15");
        WebElement mount = driver.findElement(By.cssSelector("select#month"));
        mount.sendKeys("Aug");
        WebElement year = driver.findElement(By.cssSelector("select#year"));
        year.sendKeys("1992");
        WebElement gendor = driver.findElement(By.xpath("//*[@data-type=\"radio\"]//span[2]"));
        gendor.click();
    }

    @Test(priority = 3)
    public void checkInputFields() {
        String firstName = driver.findElement(By.xpath("(//*[@id=\"fullname_field\"]//input)[1]")).getAttribute("value");
        String lastName = driver.findElement(By.xpath("(//*[@id=\"fullname_field\"]//input)[2]")).getAttribute("value");
        String email = driver.findElement(By.xpath("(//*[@id=\"reg_form_box\"]//input)[3]")).getAttribute("value");
        String password = driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).getAttribute("value");
        String day = driver.findElement(By.cssSelector("select#day")).getAttribute("value");
        String month = driver.findElement(By.cssSelector("select#month")).getAttribute("value");
        String year = driver.findElement(By.cssSelector("select#year")).getAttribute("value");

        Assert.assertEquals(firstName, "Serega");
        Assert.assertEquals(lastName, "Automashevkiy");
        Assert.assertEquals(email, "+380957778899");
        Assert.assertEquals(password, "Privet@123");
        Assert.assertEquals(day, "15");
        Assert.assertEquals(month, "8");
        Assert.assertEquals(year, "1992");
    }

    @Test(priority = 4)
    public void checkRegistrationButtonVisibility() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name=\"websubmit\"]")).isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

