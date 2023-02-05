package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserTitleTest {
    private WebDriver driver;

    @DataProvider(name = "browserProvider")
    public Object[][] getData() {
        return new Object[][] {
                {"Chrome", new ChromeDriver()},
                {"Firefox", new FirefoxDriver()}
        };
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/lesson3/sources/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/lesson3/sources/geckodriver");
    }

    @Test(dataProvider = "browserProvider")
    public void testTitle(String browserName, WebDriver browserDriver) throws InterruptedException {
        driver = browserDriver;
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.xpath("//*[@name='q']"));
        element.sendKeys("Selenium");
        element.submit();
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Selenium"), "Title verification failed for " + browserName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
