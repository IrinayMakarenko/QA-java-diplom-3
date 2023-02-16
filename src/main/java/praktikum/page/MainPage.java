package praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    //Кнопка "Личный кабинет"
    private By personalButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    //Кнопка "Войти в аккаунт"
    private By accountButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    //Кнопка "Оформить заказ"
    private By orderButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    //Конструктор
    private By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    //Логотип "Stellar burgers"
    private By stellarBurgersLogo = By.cssSelector(".AppHeader_header__logo__2D0X2");
    //Заголовок "Соберите Бургер"
    private By headerBurger = By.cssSelector(".text.text_type_main-large.mb-5.mt-10");
    //Кнопка "Булки" неактивна
    private By inactiveBunButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Булки']");
    //Кнопка "Булки" активна
    private By activeBunButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Булки']");
    //Кнопка "Соусы" неактивна
    private By inactiveSauceButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Соусы']");
    //Кнопка "Соусы" активна
    private By activeSauceButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Соусы']");
    //Кнопка "Начинки" неактивна
    private By inactiveFillingButton = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Начинки']");
    //Кнопка "Начинки" активна
    private By activeFillingButton = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Начинки']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickPersonalButton() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(personalButton));
        webDriver.findElement(personalButton).click();
    }

    public void clickAccountButton() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        webDriver.findElement(accountButton).click();
    }

    public boolean checkOrderButtonIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return webDriver.findElement(orderButton).isDisplayed();
    }

    public void clickStellarBurgersLogo() {
        webDriver.findElement(stellarBurgersLogo).click();
    }

    public void clickConstructorButton() {
        webDriver.findElement(constructorButton).click();
    }

    public boolean checkHeaderBurgerIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(headerBurger));
        return webDriver.findElement(headerBurger).isDisplayed();
    }

    public void clickInactiveBunButton() {
        webDriver.findElement(inactiveBunButton).click();
    }

    public void clickInactiveSauceButton() {
        webDriver.findElement(inactiveSauceButton).click();
    }

    public void clickInactiveFillingButton() {
        webDriver.findElement(inactiveFillingButton).click();
    }

    public boolean checkActiveBunButtonIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(activeBunButton));
        var x = webDriver.findElement(activeBunButton);
        System.out.println(x.getAttribute("class"));
        return x.isDisplayed();
    }

    public boolean checkActiveSauceButtonIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(activeSauceButton));
        return webDriver.findElement(activeSauceButton).isDisplayed();
    }

    public boolean checkActiveFillingButtonIsDisplayed() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(activeFillingButton));
        return webDriver.findElement(activeFillingButton).isDisplayed();
    }
}

