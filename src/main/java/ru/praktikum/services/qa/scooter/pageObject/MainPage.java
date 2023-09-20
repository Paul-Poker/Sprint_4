package ru.praktikum.services.qa.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.praktikum.services.qa.scooter.config.AppConfig.APP_URL;

public class MainPage {

    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    //Локаторы элементов на главной странице:
    //кнопка сохранения кук
    private final By cookieBtn = By.id("rcc-confirm-button");
//    //кнопка "Заказать" вверху страницы
//    public By orderBtnTop = By.className("Button_Button__ra12g");
//    //кнопка "Заказать" в середине страницы
//    private By orderBtnDown = By.className("Button_Button__ra12g Button_Middle__1CSJM");
//    //блок выпадающего списка вопросов
    private By questionMenu = By.className("accordion");


    //клик на кнопку принятие куки
    public MainPage clickCookie() {
        webDriver.findElement(cookieBtn).click();
        return this;
    }
//
//    //клик на кнопку "Заказать" (верхняя кнопка)
//    public MainPage clickOrderBtnTop () {
//        webDriver.findElement(orderBtnTop).click();
//        return this;
//    }
//
//    //скролл и клик на кнопку "Заказать" (нижняя кнопка)
//    public MainPage clickOrderBtnDown () {
//        WebElement button = webDriver.findElement(orderBtnDown);
//        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", button);
//        webDriver.findElement(orderBtnDown).click();
//        return this;
//    }

    //cкролл до списка вопросов
    public MainPage scrollToQuestionMenu() {
        WebElement element = webDriver.findElement(questionMenu);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return this;
    }

    //клик на вопрос
    public MainPage clickQuestion(int index) {
        webDriver.findElement(By.xpath((".//div[@id='accordion__heading-"+index)+"']")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    // получение текста вопроса + ожидание
    public String getDescription(int index) {
        WebElement questionElement = new WebDriverWait(webDriver,Duration.ofSeconds(2)).
               until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-" + index + "']/p")));
        return questionElement.getText();
    }

}
