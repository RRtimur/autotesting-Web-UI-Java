package Lesson6;

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

    @FindBy(xpath = "//img//ancestor::a[@href='/cat/detail/smartfon-xiaomi-redmi-10-4-64gb-pebble-white/']")
    private WebElement productXpath;



    public ProductPage goToProduct(){
        popupSearchField.sendKeys("Смартфон Xiaomi Redmi 10 4 64GB Pebble White");
        webDriverWait.until(ExpectedConditions.visibilityOf(productXpath));
        productXpath.click();
        return new ProductPage(driver);
    }
}
