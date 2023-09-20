package ru.praktikum.services.qa.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.services.qa.scooter.pageObject.MainPage;
import ru.praktikum.services.qa.scooter.pageObject.OrderPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


//@RunWith(Parameterized.class)

public class OrderTest {

    WebDriver webDriver;
    OrderPage orderPage;

//    String name;
//    String surname;
//    String adress;
//    String metroStaion;
//    String number;
//    String date;
//    int rentTime;
//    String colour;
//    String comment;
//
//    public OrderTest(String name, String surname, String adress, String metroStaion, String number,
//                          String date, int rentTime, String colour, String comment) {
//        this.name = name;
//        this.surname = surname;
//        this.adress = adress;
//        this.metroStaion = metroStaion;
//        this.number = number;
//        this.date = date;
//        this.rentTime = rentTime;
//        this.colour = colour;
//        this.comment = comment;
//    }
//
//    @Parameterized.Parameters
//    public static Object[] getInfo() {
//        return new Object[][]{
//                {"Пабло", "Эскобар", "Колумбийская 69", "44", "12345678910", "22.09.2023", 3, "black", "для быстрой езды"},
//
//                {"Сальвадор", "Дали", "Французская 12", "23", "09876543210", "01.10.2023", 2, "grey", "потихоьнку"},
//        };
//    }

    @Before
    public void set() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        orderPage = new OrderPage(webDriver);
    }

    @Test
    public void orderTest() {
        orderPage.clickCookie();
//                .clickOrderBtnTop()
//                .setLoginInfo(name, surname, adress, metroStaion, number)
//                .setRentInfo (date, rentTime, colour, comment)
//                .clickYesBtn();
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//    }

}

    /*
    Заказ самоката. Весь флоу позитивного сценария. Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
        Из чего состоит позитивный сценарий:
        Нажать кнопку «Заказать». На странице две кнопки заказа.
        Заполнить форму заказа.
        Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
        */