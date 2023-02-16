package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.generator.UserGenerator;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegisterPage;

import static org.junit.Assert.assertEquals;

public class RegisterPageTest extends BaseUITest{

    private String name;
    private String email;
    private String password;

    @Before
    public void setUp() {

        name = UserGenerator.getRandomName();
        email = UserGenerator.getRandomEmail();
        password = UserGenerator.getRandomPassword();
    }

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Успешная регистрация")
    public void successRegisterIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.register(name, email, password);
        boolean successLoginHeaderIsDisplayed = loginPage.checkSuccessLoginHeaderIsDisplayed();
        Assert.assertTrue("Пользователь не зарегистрирован", successLoginHeaderIsDisplayed);
    }

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Ошибка для некорректного пароля")
    public void errorPasswordMessageIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalButton();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.register(name, email, "123");
        String actualErrorTextPassword = registerPage.getTextErrorPassword();
        assertEquals("Отсутствует текст об ошибке ввода пароля", "Некорректный пароль", actualErrorTextPassword);
    }
}