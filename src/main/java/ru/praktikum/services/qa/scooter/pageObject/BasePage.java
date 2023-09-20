package ru.praktikum.services.qa.scooter.pageObject;

import org.openqa.selenium.WebDriver;

public class BasePage {

    public final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
