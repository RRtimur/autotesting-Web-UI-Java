package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EldoradoAutotestDeleteItem {
    public static void main(String[] args) throws InterruptedException {


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("https://www.eldorado.ru/");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@role='search']")));
        webDriver.findElement(By.xpath("//form[@role='search']")).click();
        webDriver.findElement(By.xpath("//input[@aria-label='Поиск товаров']"))
                .sendKeys("Смартфон Xiaomi Redmi 10 4 64GB Pebble White");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img//ancestor::a[@href='/cat/detail/smartfon-xiaomi-redmi-10-4-64gb-pebble-white/']")));
        webDriver.findElement(By.xpath("//img//ancestor::a[@href='/cat/detail/smartfon-xiaomi-redmi-10-4-64gb-pebble-white/']")).click();

        webDriver.findElement(By.xpath("//div[@class='priceContainer']//span[text()='Добавить в корзину']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='dy-modal-wrapper']//div[contains(@class,'close')]")));
        webDriver.findElement(By.xpath("//div[@class='dy-modal-wrapper']//div[contains(@class,'close')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='basket active']")));
        webDriver.findElement(By.xpath("//a[@class='basket active']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'icons')]//span[@onclick]")));
        webDriver.findElement(By.xpath("//div[contains(@class,'icons')]//span[@onclick]")).click();


        Thread.sleep(5000);
        webDriver.quit();

    }
}
