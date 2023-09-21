package ru.praktikum.services.qa.scooter.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локаторы элементов в блоке заказа страницы "Для кого самокат":
    //поле "Имя"
    private By inputNameField = By.xpath(".//input[@placeholder='* Имя']");
    //поле "Фамилия"
    private By inputSurnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле "Адрес"
    private By inputAdressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //список станций метро
    private By inputMetroField = By.xpath(".//input[@placeholder='* Станция метро']");
    //поле "Телефон"
    private By inputPhoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка "Далее"
    private By nextBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локаторы элементов в блоке заказа страницы "Про аренду":
    //поле "Когда привезти самокат"
    private By inputDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле "Срока аренды"
    private By inputPeriodField = By.xpath("//*[@class='Dropdown-placeholder']");
    //поле "Цвет самоката"
    private By inputColourField = By.className("Order_Checkboxes__3lWSI");
    //поле "Комментарии"
    private By inputCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказ"
    private By orderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //кнопка подтверждения "Да"
    private By yesBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    //Локаторы элементов в блоке "Заказ оформлен":
    //блок успешного создания заказа
    private By statusOrder = By.className("Order_ModalHeader__3FDaJ");
    //кнопка "Посмотреть статус"
    private By showStatusBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Посмотреть статус']");


    //Методы для заполнения заказа:
    //заполнение элементов в блоке заказа страницы "Для кого самокат":
    public OrderPage setLoginInfo(String name, String surname, String adress, String metroStaion, String number) {
        inputName(name);
        inputSurname(surname);
        inputAdress(adress);
        inputMetro(metroStaion);
        inputPhoneNumber(number);
        clickNextBtn();
        return this;
    }

    //ввод имени
    public OrderPage inputName(String name) {
        webDriver.findElement(inputNameField).sendKeys(name);
        return this;
    }

    //ввод фамилии
    public OrderPage inputSurname(String surname) {
        webDriver.findElement(inputSurnameField).sendKeys(surname);
        return this;
    }

    //ввод адреса
    public OrderPage inputAdress(String adress) {
        webDriver.findElement(this.inputAdressField).sendKeys(adress);
        return this;
    }

    //выбор стации метро
    public OrderPage inputMetro(String metroStaion) {
        webDriver.findElement(inputMetroField).click();
        webDriver.findElement(By.xpath(".//button[@value='" + metroStaion + "']")).click();
        return this;
    }

    //ввод номера телефона
    public OrderPage inputPhoneNumber(String number) {
        webDriver.findElement(inputPhoneNumberField).sendKeys(number);
        return this;
    }

    //клик на кнопку "Далее"
    public OrderPage clickNextBtn() {
        webDriver.findElement(nextBtn).click();
        return this;
    }

    //заполнение элементов в блоке заказа страницы "Про аренду":
    public OrderPage setRentInfo(String date, String rentTime, String colour, String comment) {
        inputOrderDate(date);
        inputOrderPeriod(rentTime);
        inputColour(colour);
        inputComment(comment);
        clickOrderBtn();
        return this;
    }

    //заполнение даты доставки
    public OrderPage inputOrderDate(String date) {
        webDriver.findElement(inputDateField).click();
        webDriver.findElement(inputDateField).sendKeys(date);
        webDriver.findElement(inputDateField).sendKeys(Keys.ENTER);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    //заполнение срока аренды
    public OrderPage inputOrderPeriod(String rentTime) {
        webDriver.findElement(inputPeriodField).click();
        webDriver.findElement(inputPeriodField).
                findElement(By.xpath("//*[text()='" + rentTime + "']")).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    //выбор цвета
    public OrderPage inputColour(String colour) {
        webDriver.findElement(inputColourField);
        webDriver.findElement(By.xpath("//*[@id='" + colour + "']")).click();
        return this;
    }

    //ввод комментария
    public OrderPage inputComment(String comment) {
        webDriver.findElement(inputCommentField).sendKeys(comment);
        return this;
    }

    //клик на кнопку "Заказать" (заверешение заказа)
    public OrderPage clickOrderBtn() {
        webDriver.findElement(orderBtn).click();
        return this;
    }

    //клик на кнопку "Да" (подтверждение заказа)
    public OrderPage clickYesBtn() {
        webDriver.findElement(yesBtn).click();
        return this;
    }

    // получение текста об успешном заказе + ожидание
    public String getStatusOrder() {
        WebElement orderStatusElement = new WebDriverWait(webDriver, Duration.ofSeconds(2)).
                until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));
        return orderStatusElement.getText();
    }
}
