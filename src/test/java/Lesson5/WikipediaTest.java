package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaTest {
    WebDriver webDriver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;

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
        webDriver.get("https://ru.wikipedia.org/");
    }

    @Test
    void wikipediaSearchTest() {
        webDriver.findElement(By.xpath("//input[@name='search']"))
                .sendKeys("Черепахи");
        webDriver.findElement(By.xpath("//input[@id='searchButton']")).click();
        Assertions.assertTrue(webDriver.findElement(By.xpath("//h1[text()='Черепахи']")).isDisplayed());
    }

    @Test
    void wikipediaLoginError(){
        webDriver.findElement(By.xpath("//span[text()='Войти']")).click();
        webDriver.findElement(By.xpath("//input[@id='wpName1']"))
                .sendKeys("test1");
        webDriver.findElement(By.xpath("//input[@id='wpPassword1']"))
                .sendKeys("test1");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(webDriver.findElement(
                By.xpath("//div[normalize-space() = 'Введены неверные имя участника или пароль. Попробуйте ещё раз.']"))
                .isDisplayed());
        //после нескольких попыток включается капча(
    }


    @AfterEach
    void tearDown() {
        webDriver.quit();
    }
}
