package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPopup extends BaseView {
    public ProductPopup(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='dy-modal-wrapper']//div[contains(@class,'close')]")
    private WebElement closeButton;

    public ProductPage closeProductPopup(){
        webDriverWait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
        return  new ProductPage(driver);
    }
}
