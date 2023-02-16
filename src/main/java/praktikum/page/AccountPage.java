package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

    //Кнопка "Профиль"
    private By profileButton = By.cssSelector(".Account_link__2ETsJ.text.text_type_main-medium.text_color_inactive.Account_link_active__2opc9");
    //Кнопка "Выйти"
    private By logoutButton = By.cssSelector(".Account_button__14Yp3.text.text_type_main-medium.text_color_inactive");

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkProfileButtonIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        return webDriver.findElement(profileButton).isDisplayed();
    }
    public void clickLogoutButton() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        webDriver.findElement(logoutButton).click();
    }
}
