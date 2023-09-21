package ru.praktikum.services.qa.scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browserName"); //выбор браузера через установку -DbrowserName
        webDriver = WebDriverFactory.get(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
