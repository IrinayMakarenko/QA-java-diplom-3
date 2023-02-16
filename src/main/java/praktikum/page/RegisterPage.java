package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    //Поле "Имя"
    private By nameField = By.xpath(".//label[text()='Имя']/../input[@class='text input__textfield text_type_main-default']");
    //Поле "Email"
    private By emailField = By.xpath(".//label[text()='Email']/../input[@class='text input__textfield text_type_main-default']");
    //Поле "Пароль"
    private By passwordField = By.xpath(".//label[text()='Пароль']/../input[@class='text input__textfield text_type_main-default']");
    //Кнопка "Зарегистрироваться"
    private By registerButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    //Ссылка "Войти"
    private By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Войти']");
    //Сообщение об ошибке для поля пароля
    private By passwordErrorMessage = By.cssSelector(".input__error.text_type_main-default");

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setRegisterUserName(String userName) {

        webDriver.findElement(nameField).sendKeys(userName);
    }

    public void setRegisterUserEmail(String userEmail) {

        webDriver.findElement(emailField).sendKeys(userEmail);
    }

    public void setRegisterUserPassword(String userPassword) {

        webDriver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickRegisterButton() {

        webDriver.findElement(registerButton).click();
    }

    public void register(String userName, String userEmail, String userPassword) {
        setRegisterUserName(userName);
        setRegisterUserEmail(userEmail);
        setRegisterUserPassword(userPassword);
        clickRegisterButton();
    }

    public void clickLoginLink() {

        webDriver.findElement(loginLink).click();
    }
    public String getTextErrorPassword() {
        return webDriver.findElement(passwordErrorMessage).getText();
    }
}
