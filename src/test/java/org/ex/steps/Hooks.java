package org.ex.steps;

import com.codeborne.selenide.Screenshots;
import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.ex.pages.BeforeLogPage;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//Для каждого сценария - делается новый экземпляр Hooks!!!
public class Hooks {
    private static boolean isRegistered = false;
    private static final String login;
    private static final String password;
    private static final Faker faker;

    static {
        faker = new Faker();
        // Инициализация логина и пароля один раз
        login = faker.name().firstName()
                + "_MyTestOnSelenideCucumber_"
                + faker.name().firstName();
        password = faker.internet().password();
    }

    private HomePage homePage;
    private String url = "https://www.demoblaze.com/";

    @Before(order = 0)
    public void openSiteAndAuth() {
        if (!isRegistered) {
            homePage = new BeforeLogPage()
                    .openPage(url, BeforeLogPage.class)
                    .singUp(login, password)
                    .logIn(login, password, HomePage.class);

            Assertions.assertTrue(homePage.isRegistered(login),
                    "Регистрация провалена!");

            isRegistered = true;
        }
    }

    @After
    public void onTestFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshot = Screenshots.takeScreenShotAsFile();
                InputStream targetStream = new FileInputStream(screenshot);
                Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}