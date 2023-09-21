package ru.praktikum.services.qa.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.ieee1609dot2.SymmRecipientInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum.services.qa.scooter.pageObject.MainPage;
import ru.praktikum.services.qa.scooter.pageObject.OrderPage;

import java.time.Duration;



@RunWith(Parameterized.class)

public class OrderTest {

    WebDriver webDriver;
    MainPage mainPage;
    OrderPage orderPage;

    String name;
    String surname;
    String adress;
    String metroStaion;
    String number;
    String date;
    String rentTime;
    String colour;
    String comment;
    boolean buttonTop;

    public OrderTest(String name, String surname, String adress, String metroStaion, String number,
                          String date, String rentTime, String colour, String comment, boolean buttonTop) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStaion = metroStaion;
        this.number = number;
        this.date = date;
        this.rentTime = rentTime;
        this.colour = colour;
        this.comment = comment;
        this.buttonTop = buttonTop;
    }

    @Parameterized.Parameters
    public static Object[] getInfo() {      //массив для заполнения тестовых данных
        return new Object[][]{
                //первый вариант тестовых данных через верхнюю кнопку заказа
                {"Пабло", "Эскобар", "Колумбийская 69", "44", "12345678910", "22.09.2023", "двое суток", "black", "для быстрой езды",true},
                //второй вариант тестовых данных через нижнюю кнопку заказа
                {"Сальвадор", "Дали", "Французская 12", "23", "09876543210", "01.10.2023", "трое суток", "grey", "потихоьнку",false},
        };
    }

    @Before
    public void setup() {
//        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
//        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage  = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);

    }
    //тест позитивного сценария с 2 точками входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
    @Test
    public void orderTest() {
        mainPage.clickCookie()                                              //закрытие окошка куки
                .chooseOrderBtn(buttonTop);                                 //выбираем кнопку "Заказать"
        orderPage.setLoginInfo(name, surname, adress, metroStaion, number)  //заполнение формы заказа "Для кого самокат"
                .setRentInfo (date, rentTime, colour, comment)              //заполнение формы заказа "Про аренду"
                .clickYesBtn();                                             //подтверждение заказ

        String actualText = orderPage.getStatusOrder();
        Assert.assertTrue(actualText.contains("Заказ оформлен"));           //проверка всплывающего окна об успешном заказе
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
