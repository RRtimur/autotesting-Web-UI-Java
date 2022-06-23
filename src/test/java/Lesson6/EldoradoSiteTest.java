package Lesson6;


import Lesson6.EldoradoMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EldoradoSiteTest {
    WebDriver webDriver;
    ChromeOptions chromeOptions;
    WebDriverWait webDriverWait;

    private static Logger logger = LoggerFactory.getLogger(EldoradoSiteTest.class);


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
        webDriver.get("https://www.eldorado.ru/");
    }

    @Test
    void eldoradoDeleteItem()  {

        new EldoradoMainPage(webDriver)
                .openSearchField()
                .goToProduct()
                .addProductToCart()
                .closeProductPopup()
                .goToCart()
                .deleteProductFromCart()
                .checkSuccessDeleteProductFromCart();
                logger.info("eldoradoDeleteItem тест - Тест пройден успешно!");

    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }


}