package org.ex.steps;

import io.cucumber.java.en.Given;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

public class AuthSteps extends BaseSteps{
    @Given("Пользователь авторизован на сайте")
    public void isUserLogIn() {
        Assertions.assertTrue(new HomePage()
                        .goHome(HomePage.class)
                        .isRegistered(getLogin())
                ,"Log пользователя не отображен в блоке Welcome");
    }
}
