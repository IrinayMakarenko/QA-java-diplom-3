package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    //Ссылка "Войти"
    private By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginLink() {

        webDriver.findElement(loginLink).click();
    }
}
