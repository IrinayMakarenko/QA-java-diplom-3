package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.generator.UserGenerator;
import praktikum.page.*;


public class LoginPageTest extends BaseUITest{

    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {

        name = UserGenerator.getRandomName();
        email = UserGenerator.getRandomEmail();
        password = UserGenerator.getRandomPassword();

        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.register(name, email, password);
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Вход']")));
        mainPage.clickStellarBurgersLogo();
    }

    @Test
    @DisplayName("Проверка входа")
    @Description("Вход по кнопке 'Войти в аккаунт' на главной странице")
    public void successLoginInAccountButtonInMainPageIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);
        boolean orderButtonIsDisplayed = mainPage.checkOrderButtonIsDisplayed();
        Assert.assertTrue("Пользователь не авторизован", orderButtonIsDisplayed);
    }

    @Test
    @DisplayName("Проверка входа")
    @Description("Вход по кнопке 'Личный кабинет' на главной странице")
    public void successLoginInPersonalButtonInMainPageIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, password);
        boolean orderButtonIsDisplayed = mainPage.checkOrderButtonIsDisplayed();
        Assert.assertTrue("Пользователь не авторизован", orderButtonIsDisplayed);
    }

    @Test
    @DisplayName("Проверка входа")
    @Description("Вход через кнопку в форме регистрации")
    public void successLoginInLoginLinkInRegisterPageIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.clickLoginLink();
        loginPage.login(email, password);
        boolean orderButtonIsDisplayed = mainPage.checkOrderButtonIsDisplayed();
        Assert.assertTrue("Пользователь не авторизован", orderButtonIsDisplayed);
    }

    @Test
    @DisplayName("Проверка входа")
    @Description("Вход через кнопку в форме восстановления пароля")
    public void successLoginInLoginLinkInForgotPasswordPageIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.clickLoginLink();
        loginPage.login(email, password);
        boolean orderButtonIsDisplayed = mainPage.checkOrderButtonIsDisplayed();
        Assert.assertTrue("Пользователь не авторизован", orderButtonIsDisplayed);
    }
}
