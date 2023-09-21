package ru.praktikum.services.qa.scooter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.services.qa.scooter.pageObject.MainPage;
import ru.praktikum.services.qa.scooter.pageObject.OrderPage;

@RunWith(Parameterized.class)

public class OrderTest extends BaseTest{

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
    public void init(){
        mainPage = new MainPage(webDriver);
        orderPage = new OrderPage(webDriver);
    }
    //тест позитивного сценария с 2 точками входа в сценарий: кнопка «Заказать» вверху страницы и внизу
    //при запуске через Chrome невозможно оформить заказ - не нажимается кнопка "Да" для подтверждения заказа
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

}
