package Lesson6;

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

    public ProductPopup addProductToCart(){
        addToCartButton.click();
        return new ProductPopup(driver);
    }
    public CartPage goToCart(){
        webDriverWait.until(ExpectedConditions.visibilityOf(goToCartButton));
        goToCartButton.click();
        return new CartPage(driver);
    }

}
