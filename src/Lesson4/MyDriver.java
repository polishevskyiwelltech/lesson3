package Lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;


public class MyDriver {
    public static void main(String[] args) throws InterruptedException {
        BrowserType browserType = BrowserType.FIREFOX_WEB;

        WebDriver driver = null;

        switch (browserType) {
            case CHROME_WEB:
                System.setProperty("webdriver.chrome.driver", "/Users/serhii/lesson3/sources/chromedriver");
                driver = new ChromeDriver();
                break;
            case CHROME_MOBILE:
                System.setProperty("webdriver.chrome.driver", "/Users/serhii/lesson3/sources/chromedriver");
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX_WEB:
                System.setProperty("webdriver.gecko.driver", "/Users/serhii/lesson3/sources/geckodriver");
                driver = new FirefoxDriver();
                break;
        }

        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[@name= 'q']"));
        Thread.sleep(3000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(3000);
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}