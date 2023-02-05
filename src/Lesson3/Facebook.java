package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Facebook {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/lesson3/sources/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");

        WebElement regButton = driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]"));
        regButton.click();
        Thread.sleep(2000);
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
        WebElement mount = driver.findElement(By.xpath("//*[@aria-label=\"Month\"]//option"));
        mount.sendKeys("Sep");
        WebElement day = driver.findElement(By.xpath("//*[@name=\"birthday_day\"]//option"));
        day.sendKeys("15");
        WebElement year = driver.findElement(By.xpath("//*[@aria-label=\"Year\"]//option"));
        year.sendKeys("1992");
        WebElement gendor = driver.findElement(By.xpath("//*[@data-type=\"radio\"]//span[2]"));
        gendor.click();
        WebElement submit = driver.findElement(By.xpath("//*[@name=\"websubmit\"]"));
        submit.click();
        driver.quit();
    }
}
