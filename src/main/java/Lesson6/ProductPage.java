package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BaseView {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='priceContainer']//span[text()='Добавить в корзину']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='basket active']")
    private WebElement goToCartButton;

    @Step("Нажать на кнопку 'Добавить товар в корзину' ")
    public ProductPopup addProductToCart(){
        addToCartButton.click();
        return new ProductPopup(driver);
    }
    @Step("Нажать на кнопку 'Перейти в корзину'")
    public CartPage goToCart(){
        webDriverWait.until(ExpectedConditions.visibilityOf(goToCartButton));
        goToCartButton.click();
        return new CartPage(driver);
    }

}
