package ru.praktikum.services.qa.scooter.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.praktikum.services.qa.scooter.config.AppConfig.APP_URL;

public class FrequentlyQuestionsPage {
    WebDriver driver;

    public FrequentlyQuestionsPage(WebDriver driver) {
        this.driver = driver;
        driver.get(APP_URL);
    }

    // Селекторы для вопросов
    private By[] questions = {
            By.id("accordion__heading-0"),   // вопрос 1
            By.id("accordion__heading-1"),   // вопрос 2
            By.id("accordion__heading-2"),  // вопрос 3
            By.id("accordion__heading-3"),  // вопрос 4
            By.id("accordion__heading-4"),  // вопрос 5
            By.id("accordion__heading-5"),  // вопрос 6
            By.id("accordion__heading-6"),  // вопрос 7
            By.id("accordion__heading-7")   // вопрос 8
    };

    // Селекторы для описаний
    private final By[] descriptions = {
            By.xpath(".//div[@id='accordion__panel-0']/p"),    // описание 1
            By.id("accordion__panel-1"),    // описание 2
            By.id("accordion__panel-2"),    // описание 3
            By.id("accordion__panel-3"),    // описание 4
            By.id("accordion__panel-4"),    // описание 5
            By.id("accordion__panel-5"),    // описание 6
            By.id("accordion__panel-6"),    // описание 7
            By.id("accordion__panel-7")     // описание 8
    };

    // Метод для открытия вопроса
    public void openQuestion(int index) {
        WebElement question = driver.findElement(questions[index - 1]);
        question.click();
    }

    // Метод для получения текста описания
    public String getDescriptionText(int index) {
        WebElement description = driver.findElement(descriptions[index - 1]);
        return description.getText();
    }
}
