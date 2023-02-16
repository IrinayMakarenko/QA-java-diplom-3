package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    //Ссылка "Зарегистрироваться"
    private By registerLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    //Ссылка "Восстановить пароль"
    private By forgotPasswordLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    //Поле "Email"
    private By emailField = By.xpath(".//label[text()='Email']/../input[@class='text input__textfield text_type_main-default']");
    //Поле "Пароль"
    private By passwordField = By.xpath(".//label[text()='Пароль']/../input[@class='text input__textfield text_type_main-default']");
    //Кнопка "Войти"
    private By loginButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    //Заголовок "Вход"
    private By successLoginHeader = By.xpath(".//h2[text()='Вход']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickRegisterLink() {
        webDriver.findElement(registerLink).click();
    }
    public void clickForgotPasswordLink() {
        webDriver.findElement(forgotPasswordLink).click();
    }
    public boolean checkSuccessLoginHeaderIsDisplayed() {
        return webDriver.findElement(successLoginHeader).isDisplayed();
    }

    public void setLoginUserEmail(String userEmail) {

        webDriver.findElement(emailField).sendKeys(userEmail);
    }
    public void setLoginUserPassword(String userPassword) {

        webDriver.findElement(passwordField).sendKeys(userPassword);
    }
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void login(String userEmail, String userPassword) {
        setLoginUserEmail(userEmail);
        setLoginUserPassword(userPassword);
        clickLoginButton();
    }
}
