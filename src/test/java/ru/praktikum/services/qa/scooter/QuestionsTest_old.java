package ru.praktikum.services.qa.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.services.qa.scooter.pageObject.MainPage_old;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class QuestionsTest_old {

    WebDriver webDriver;
    MainPage_old mainPage;

    //Переменные
//    private String text;
//    private int index;

//    private By[] questions = {
//            By.xpath(".//div[@id='accordion__heading-0']")  // вопрос 1
//    };
//
//    private final By[] descriptions = {
//            By.xpath(".//div[@id='accordion__panel-0']/p"),    // описание 1
//    };


//    public QuestionsTest(String text, int index) {
//        this.text = text;
//        this.index = index;
//    }

//    @Parameterized.Parameters
//    public static Object[] getDescriptionText() {
//        return new Object[][]{
//                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
//                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
//                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
//                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
//                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
//                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
//                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
//                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
//        };
//    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
    @Test
    public void questionTest() {
        new MainPage_old(webDriver)
                .clickCookie();

//        webDriver.get(APP_URL);
//        mainPage = new MainPage(webDriver);

//        mainPage.clickCookie();
//        mainPage.scrollToQuestionMenu();
//        mainPage.clickQuestion(index);
//        assertEquals("Текст не совпадает", text, mainPage.getDescription(index));


//       By cookieBtn = (By.id("rcc-confirm-button")); webDriver.findElement(cookieBtn).click();


//        public void openQuestion(int index) {
//            WebElement question = webDriver.findElement(questions[index - 1]);
//            question.click();
//        }
//        WebElement elementFAQ_1 = webDriver.findElement(questions[0]);
//        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", elementFAQ_1);
////
//        elementFAQ_1.click();
//
//        new WebDriverWait(webDriver,Duration.ofSeconds(2)).
//                until(ExpectedConditions.visibilityOfElementLocated(descriptions[0]));
//
//        WebElement FAQ_answer_1 = webDriver.findElement(descriptions[0]);

//        String actualDescription = FAQ_answer_1.getText();
//        System.out.println("Описание 1 кнопки: " + actualDescription);

//        String FAQ_1_Desc = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
//
//        Assert.assertEquals(FAQ_1_Desc, actualDescription);

    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//    }

}
