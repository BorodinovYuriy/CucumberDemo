package org.ex.steps;

import com.codeborne.selenide.Screenshots;
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

import static org.ex.steps.BaseStep.getLogin;
import static org.ex.steps.BaseStep.getPassword;

//Для каждого сценария - делается новый экземпляр Hooks!!!

public class Hooks {
    private static boolean isRegistered = false;

    private final String url = "https://www.demoblaze.com/";

    @Before(order = 0)
    public void openSiteAndAuth() {
        if (!isRegistered) {
            HomePage homePage = new BeforeLogPage()
                    .openPage(url, BeforeLogPage.class)
                    .singUp(getLogin(), getPassword())
                    .logIn(getLogin(), getPassword(), HomePage.class);

            Assertions.assertTrue(homePage.isRegistered(getLogin()),
                    "Регистрация провалена!");

            isRegistered = true;
        }
    }

    @After
    public void onTestFailure(Scenario scenario) {
//        if (scenario.isFailed()) {
//            try {
//                File screenshot = Screenshots.takeScreenShotAsFile();
//                InputStream targetStream = new FileInputStream(screenshot);
//                Allure.addAttachment("Screenshot on fail", "image/png", targetStream, "png");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}