package Lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class EldoradoTest {
    WebDriver webDriver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;

    private static Logger logger = LoggerFactory.getLogger(EldoradoTest.class);


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void beforeEach() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://www.eldorado.ru/");
    }

    @Test
    void eldoradoDeleteItem() {

        //не понимаю, работает через раз, за все попытки, хотя бы раз,
        // да вылетит ошибка в рандомном шаге, это у меня такой плохой код получился или сайт такой?

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

        Assertions.assertTrue(webDriver.findElement(By.xpath("//span[@id='total_price_id'][text()='0 ']")).isDisplayed());
        logger.info("eldoradoDeleteItem - тест успешен");
    }


    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

}
