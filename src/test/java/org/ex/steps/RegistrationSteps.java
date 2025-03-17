package org.ex.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ex.pages.AfterLogPage;
import org.ex.pages.BeforeLogPage;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

public class RegistrationSteps extends BaseStep {
    BeforeLogPage beforeLogPage;
    AfterLogPage afterLogPage;
    HomePage homePage;

    @Given("Переход на страницу {string}")
    public void openUrl(String url) {
        beforeLogPage = new BeforeLogPage().openPage(url, BeforeLogPage.class);
    }

    @When("Производим регистрацию")
    public void registerUser() {
        afterLogPage = beforeLogPage.singUp(getLogin(),getPassword());
    }

    @And("Производим авторизацию")
    public void loginUser() {
        homePage = afterLogPage.logIn(getLogin(),getPassword(), HomePage.class);
    }

    @Then("Пользователь успешно авторизовался")
    public void isUserLogin() {
        Assertions.assertTrue(homePage.isRegistered(getLogin()),
                "Имя пользователя не отображено в поле приветствия!");
    }

}
