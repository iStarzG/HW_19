package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WindowsCloser;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.browser.model.WindowState;
import org.openqa.selenium.devtools.v85.page.model.WindowOpen;
import pages.components.AvitoTestRandomData;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AvitoPerfomancePages {

    private SelenideElement
            categoryResult = $(".page-title-text-tSffu"),
            buttonRegistration = $(".index-module-login-K8jzD"),
            moduleLogin = $(".styles-module-root-nvJ_K"),
            clickInputCity = $(".desktop-nev1ty"),
            inputCity = $(".suggest-input-rORJM"),
            buttonClear = $(".icon-icon-jrOym"),
            buttonResultCityName = $(".desktop-xujs2d"),
            searchBarName = $(".input-input-Zpzc1"),
            searchResultName = $(".page-title-text-tSffu page-title-inline-zBPFx"),
            buttonDeliveryName = $x("//h4[contains(.,'Доставка')]"),
            deliveryCheckResultName = $x("//h1[contains(.,'Авито Доставка')]"),
            closeCity = $(".desktop-smz193"),
            buttonAutotekaName = $x("//h4[contains(.,'Автотека')]"),
            autotekaResult = $(".header-main-title-TDDlr"),
            tableCalendarName = $x("//div/div/div/div/table/tbody/tr[3]/td[3]/div"),
            tableCalendarDualName = $x("//div[2]/table/tbody/tr[4]/td[6]/div"),
            calendarCloseName = $x("//div[2]/div/div/div/div/div[2]/button/span"),
            randomAddName = $x("//div[5]/div/div/div[2]/div/a/h3"),
            addNameVisible = $(".style-title-info-_liyt"),
            buttonHelpName = $x("//a[contains(text(),'Помощь')]"),
            helpResultName = $("._1agAUwZfOLyww_mmrX31X0"),
            buttonClickFavoritesName = $(".desktop-1gzlbya"),
            favoritesName = $(".index-container-MxQrS");


    @Step("Открытие браузера и нужной страницы")
    public AvitoPerfomancePages openPage() {
        open("https://www.avito.ru/");
        return this;
    }

    @Step("Открытие категории {value} в главном блоке категорий на главной странице")
    public AvitoPerfomancePages selectRandomCategory(String value) {
        $x("//img[@alt='" + value + "']").click();
        return this;
    }

    @Step("Проверка открытия нужной страницы")
    public AvitoPerfomancePages checkCategoryResult() {
        categoryResult.shouldBe();
        return this;
    }

    @Step("Нажатие на кнопку Вход и регистрация")
    public AvitoPerfomancePages checkButtonRegistration() {
        buttonRegistration.click();
        return this;
    }

    @Step("Проверка открытия модуля логина и регистрации")
    public AvitoPerfomancePages checkOpenModule() {
        moduleLogin.shouldBe();
        return this;
    }

    @Step("Нажатие на кнопку выбора города")
    public AvitoPerfomancePages clickInputCity() {
        sleep(2000);
        clickInputCity.click();
        return this;
    }

    @Step("Нажатие на кнопку очистки предыдущего названия города из поля значения")
    public AvitoPerfomancePages clearCityName() {
        buttonClear.click();
        return this;
    }

    @Step("Ввод в поле названия города {value}")
    public AvitoPerfomancePages inputCityName(String value) {
        inputCity.setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Нажатие на опцию расширенного поиска города (город, область) {value}")
    public AvitoPerfomancePages inputOptionCity(String value) {
        $x("//li[contains(.,'" + value + "')]").click();
        return this;
    }

    @Step("Нажатие на кнопку Показать объявления")
    public AvitoPerfomancePages clickButtonCityResults() {
        buttonResultCityName.click();
        return this;
    }

    @Step("Проверка изменения города на главной странице на выбранный город {value}")
    public AvitoPerfomancePages checkResultCitySelect(String value) {
        clickInputCity.shouldHave(text(value));
        return this;
    }

    @Step("Ввод в поисковую строку {value} и нажатие enter")
    public AvitoPerfomancePages inputSearchBar(String value) {
        searchBarName.setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Проверка выдачи результатов через поисковую строку")
    public AvitoPerfomancePages searchResultCheck() {
        searchResultName.shouldBe();
        return this;
    }

    @Step("Соглашение на выбор предложенного города")
    public AvitoPerfomancePages agreementCity() {
        closeCity.click();
        sleep(2000);
        return this;
    }

    @Step("Проверка наличия кнопки Доставка")
    public AvitoPerfomancePages visibleDeliveryButton() {
        buttonDeliveryName.shouldBe();
        return this;
    }

    @Step("Нажатие и проверка работоспособности кнопки Доставка")
    public AvitoPerfomancePages checkDeliveryButton() {
        buttonDeliveryName.click();
        return this;
    }

    @Step("Проверка открытия нужной страницы Авито Доставка")
    public AvitoPerfomancePages checkResultDelivery() {
        sleep(5000);
        deliveryCheckResultName.shouldBe();
        return this;
    }

    @Step("Проверка наличия кнопки Автотека")
    public AvitoPerfomancePages buttonAutotekaVisible() {
        buttonAutotekaName.shouldBe();
        return this;
    }

    @Step("Нажатие и проверка работоспособности кнопки Автотека")
    public AvitoPerfomancePages buttonAutotekaClick() {
        buttonAutotekaName.click();
        return this;
    }

    @Step("Проверка открытия нужной страницы")
    public AvitoPerfomancePages autotekaResultsCheck() {
        sleep(5000);
        autotekaResult.shouldBe();
        return this;
    }

    @Step("Открытие страницы Онлайн-бронирование жилья")
    public AvitoPerfomancePages openPageRent() {
        open("https://www.avito.ru/all/kvartiry/sdam/posutochno/");
        return this;
    }

    @Step("Выбор в календаре день заезда")
    public AvitoPerfomancePages selectFirstDate() {
        tableCalendarName.click();
        return this;
    }

    @Step("Выбор в календаре день выезда")
    public AvitoPerfomancePages selectEndDate() {
        tableCalendarDualName.click();
        return this;
    }

    @Step("Клик и проверка закрытия календаря")
    public AvitoPerfomancePages calendarClose() {
        calendarCloseName.click();
        return this;
    }

    @Step("Открытие предложенного объявления")
    public AvitoPerfomancePages openAdd() {
        randomAddName.click();
        return this;
    }

    @Step("Проверка открытия объявления")
    public AvitoPerfomancePages visibleOpenPage() {
        sleep(5000);
        addNameVisible.shouldBe();
        return this;
    }

    @Step("Нажатие кнопки Помощь")
    public AvitoPerfomancePages clickButtonHelp() {
        sleep(2000);
        buttonHelpName.click();
        return this;
    }

    @Step("Проверка работоспособности кнопки Помощь и открытия нужной страницы")
    public AvitoPerfomancePages checkResultHelpButton() {
        sleep(2000);
        helpResultName.shouldBe();
        return this;
    }

    @Step("Клик на кнопку Избранное")

    public AvitoPerfomancePages buttonClickFavorites() {
        buttonClickFavoritesName.click();
        return this;
    }

    @Step("Проверка открытия страницы Избранное")

    public AvitoPerfomancePages checkFavorites() {
        sleep(2000);
        favoritesName.click();
        return this;
    }
}

