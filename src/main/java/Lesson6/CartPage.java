package Lesson6;





import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BaseView{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class,'icons')]//span[@onclick]")
    private WebElement deleteFromCartButton;
    @FindBy(xpath = "//span[@id='total_price_id'][text()='0 ']")
    private  WebElement cartIsEmpty;

    public CartPage deleteProductFromCart(){
        webDriverWait.until(ExpectedConditions.visibilityOf(deleteFromCartButton));
        deleteFromCartButton.click();
        return this;
    }
    public void checkSuccessDeleteProductFromCart(){
        Assertions.assertTrue(cartIsEmpty.isDisplayed());
    }
}
