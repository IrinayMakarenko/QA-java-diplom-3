package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.page.MainPage;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class MainPageTest extends BaseUITest{

    @Test
    @DisplayName("Раздел 'Конструктор'")
    @Description("Переход к разделу 'Соусы'")
    public void successActiveSauceButtonIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickInactiveSauceButton();
        boolean successActiveSauceButtonIsDisplayed = mainPage.checkActiveSauceButtonIsDisplayed();
        Assert.assertTrue("Неуспешный переход к разделу 'Соусы'", successActiveSauceButtonIsDisplayed);
    }

    @Test
    @DisplayName("Раздел 'Конструктор'")
    @Description("Переход к разделу 'Начинки'")
    public void successActiveFillingButtonIsDisplayed() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickInactiveFillingButton();
        boolean successActiveFillingButtonIsDisplayed = mainPage.checkActiveFillingButtonIsDisplayed();
        Assert.assertTrue("Неуспешный переход к разделу 'Начинки'", successActiveFillingButtonIsDisplayed);
    }

    @Test
    @DisplayName("Раздел 'Конструктор'")
    @Description("Переход к разделу 'Булки'")
    public void successActiveBunButtonIsDisplayed(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickInactiveSauceButton();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Соусы']")));
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/./span[text()='Булки']"))));
        mainPage.clickInactiveBunButton();
        boolean successActiveBunButtonIsDisplayed = mainPage.checkActiveBunButtonIsDisplayed();
        Assert.assertTrue("Неуспешный переход к разделу 'Булки'", successActiveBunButtonIsDisplayed);
    }
}
