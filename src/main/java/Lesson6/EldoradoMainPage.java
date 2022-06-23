package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EldoradoMainPage extends BaseView {
    public EldoradoMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@role='search']")
    private WebElement searchField;

    @Step("Нажать на поле поиска по товарам")
    public EldoradoSeachFieldPopup openSearchField() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();
        return new EldoradoSeachFieldPopup(driver);
    }


}
