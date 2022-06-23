package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EldoradoSeachFieldPopup extends BaseView{
    public EldoradoSeachFieldPopup(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@aria-label='Поиск товаров']")
    private WebElement popupSearchField;

    @FindBy(xpath = "//img//ancestor::a[@href='/cat/detail/smartfon-redmi-9a-32gb-granite-gray/']")
    private WebElement productXpath;


    @Step("Перейти на страницу выбранного товара")
    public ProductPage goToProduct(){
        popupSearchField.sendKeys("Смартфон Xiaomi Redmi");
        webDriverWait.until(ExpectedConditions.visibilityOf(productXpath));
        productXpath.click();
        return new ProductPage(driver);
    }
}
