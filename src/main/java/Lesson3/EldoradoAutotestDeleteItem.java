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

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.get("https://www.eldorado.ru/");

        webDriver.findElement(By.xpath("//form[@role='search']")).click();
        webDriver.findElement(By.xpath("//input[@aria-label='Поиск товаров']")).sendKeys("Смартфон Xiaomi Redmi 10 4 64GB Pebble White");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='LA']")));

        webDriver.findElement(By.xpath("//a[@class='LA']")).click();

        webDriver.findElement(By.xpath("//div[@class='priceContainer']//span[text()='Добавить в корзину']")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dy-modal-wrapper']//div[contains(@class,'close')]")));
        webDriver.findElement(By.xpath("//div[@class='dy-modal-wrapper']//div[contains(@class,'close')]")).click();

        webDriver.findElement(By.xpath("//a[@class='basket active']")).click();
        webDriver.findElement(By.xpath("//div[contains(@class,'icons')]//span[@onclick]")).click();



        Thread.sleep(5000);
        webDriver.quit();

    }
}
