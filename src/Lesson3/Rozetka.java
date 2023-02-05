package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Rozetka {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/lesson3/sources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/mobile-phones/c80003/");
        Thread.sleep(5000);

        List<WebElement> elements = driver.findElements(By.xpath("(//*[contains(text(),'АКЦІЯ')]//ancestor::div[contains(@class,'goods-tile__inner')][1])[position() < 4]"));

        for (int i = 0; i < 3; i++) {
            System.out.println(elements.get(i).getText());
        }
        driver.quit();
    }
}
