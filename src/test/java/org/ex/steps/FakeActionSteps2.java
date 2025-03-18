package org.ex.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.ex.pages.FakeActionsPage;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class FakeActionSteps2 extends BaseStep {
    HomePage homePage;
    FakeActionsPage fakePage;

    @Given("Пользователь авторизован на сайте2")
    public void isUserLogIn() {
        Assertions.assertTrue(new HomePage()
                        .clickHome(HomePage.class)
                        .isRegistered(getLogin())
                ,"Log пользователя не отображен в блоке Welcome");
    }

    @When("Задаём setFakeList2")
    public void setFakeList() {
        fakePage = new FakeActionsPage().setFakeList();
    }

    @Then("Получаем getFakeList2")
    public void printFakeList() {
       fakePage.printFakeList("2");
    }
}
