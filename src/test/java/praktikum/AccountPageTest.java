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
import praktikum.page.AccountPage;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegisterPage;

public class AccountPageTest extends BaseUITest {
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
        loginPage.login(email, password);
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg")));
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Переход в аккаунт по клику на 'Личный кабинет'")
    public void successTransitionInProfileIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        AccountPage accountPage = new AccountPage(webDriver);
        boolean profileButtonIsDisplayed = accountPage.checkProfileButtonIsDisplayed();
        Assert.assertTrue("Пользователь не перешел в профиль", profileButtonIsDisplayed);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на 'Конструктор'")
    public void successTransitionToConstructorByClickConstructorIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        AccountPage accountPage = new AccountPage(webDriver);
        accountPage.checkProfileButtonIsDisplayed();
        mainPage.clickConstructorButton();
        boolean headerBurgerIsDisplayed = mainPage.checkHeaderBurgerIsDisplayed();
        Assert.assertTrue("Неуспешный переход в конструктор", headerBurgerIsDisplayed);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Переход по клику на логотип Stellar Burgers")
    public void successTransitionToConstructorByClickLogoIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        AccountPage accountPage = new AccountPage(webDriver);
        accountPage.checkProfileButtonIsDisplayed();
        mainPage.clickStellarBurgersLogo();
        boolean headerBurgerIsDisplayed = mainPage.checkHeaderBurgerIsDisplayed();
        Assert.assertTrue("Неуспешный переход в конструктор", headerBurgerIsDisplayed);
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Выход из аккаунта по кнопке 'Выйти' в личном кабинете")
    public void successLogoutIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        AccountPage accountPage = new AccountPage(webDriver);
        accountPage.clickLogoutButton();
        LoginPage loginPage = new LoginPage(webDriver);
        boolean successLoginHeaderIsDisplayed = loginPage.checkSuccessLoginHeaderIsDisplayed();
        Assert.assertTrue("Пользователь не вышел из аккаунта", successLoginHeaderIsDisplayed);
    }
}
