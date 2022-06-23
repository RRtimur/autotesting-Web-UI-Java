package Lesson6;


import Lesson6.EldoradoMainPage;
import Lesson7.AddBonusFunctional;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.EventListener;

@Feature("Работа с корзиной")
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
        webDriver = new EventFiringDecorator(new AddBonusFunctional()).decorate(new ChromeDriver(chromeOptions));
//        webDriver = new ChromeDriver(chromeOptions);
        //driver = new EventFiringDecorator(new AdditionalAllureSteps()).decorate(new ChromeDriver());
        webDriver.get("https://www.eldorado.ru/");
    }
    @Story("удаление телефона из корзины")
    @Test
    @Description("Удаление товара из корзины")
    @Issue("OOP-221")
    @TmsLink("223")
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
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for(LogEntry logEntry : logEntries){
            Allure.addAttachment("логи браузера", logEntry.getMessage());
        }

        webDriver.quit();
    }


}