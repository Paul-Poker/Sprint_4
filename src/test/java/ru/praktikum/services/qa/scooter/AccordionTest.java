package ru.praktikum.services.qa.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.services.qa.scooter.pageObject.FrequentlyQuestionsPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AccordionTest {

    private WebDriver driver;
    private FrequentlyQuestionsPage frequentlyQuestionsPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
        frequentlyQuestionsPage = new FrequentlyQuestionsPage(driver);
    }

    @Test
    public void testAccordion() {
        new WebDriverWait(driver, Duration.ofSeconds(2)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-0']/p")));
        frequentlyQuestionsPage.openQuestion(1);
        String expectedDescription = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualDescription = frequentlyQuestionsPage.getDescriptionText(1);
        Assert.assertEquals(expectedDescription, actualDescription);

//            frequentlyQuestionsPage.openQuestion(2);
//            String expectedDescription_2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
//            String actualDescription_2 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(3);
//            String expectedDescription_3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
//            String actualDescription_3 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(4);
//            String expectedDescription_4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
//            String actualDescription_4 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(5);
//            String expectedDescription_5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
//            String actualDescription_5 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(6);
//            String expectedDescription_6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
//            String actualDescription_6 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(7);
//            String expectedDescription_7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
//            String actualDescription_7 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);
//
//            frequentlyQuestionsPage.openQuestion(8);
//            String expectedDescription_8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
//            String actualDescription_8 = frequentlyQuestionsPage.getDescriptionText(2);
//            Assert.assertEquals(expectedDescription, actualDescription);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
