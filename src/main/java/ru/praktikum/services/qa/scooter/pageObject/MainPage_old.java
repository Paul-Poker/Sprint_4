package ru.praktikum.services.qa.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static ru.praktikum.services.qa.scooter.config.AppConfig.APP_URL;

public class MainPage_old {
    WebDriver webDriver;

    public MainPage_old(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    //локатор кнопки сохранения кук
    private final By cookieBtn = By.id("rcc-confirm-button");
    //локатор кнопки заказать вверху страницы
//    public By rentScooterBtnTop = By.className("Button_Button__ra12g");
    //локатор кнопки заказать внизу страницы
//    private By rentScooterBtnDown = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    //локатор списка вопросов
    private By questionMenu = By.className("accordion");

    //метод для закрытие кук
    public void clickCookie() {
        webDriver.findElement(cookieBtn).click();
    }

    //метод скролла до списка вопросов
    public void scrollToQuestionMenu() {
        WebElement element = webDriver.findElement(questionMenu);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //метод клика на вопрос
    public void clickQuestion(int index) {
        webDriver.findElement(By.id("accordion__heading-"+index)).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
    }

    //метод получения текста вопроса
    public String getDescription(int index) {
        return webDriver.findElement(By.id("accordion__panel-"+index)).getText();
    }


}
