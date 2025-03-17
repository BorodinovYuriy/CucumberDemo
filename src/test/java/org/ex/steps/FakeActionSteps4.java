package org.ex.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.ex.pages.FakeActionsPage;
import org.ex.pages.HomePage;

@Slf4j
public class FakeActionSteps4 extends BaseStep {
    HomePage homePage;
    FakeActionsPage fakePage;

    @Given("Пользователь авторизован на сайте4")
    public void isUserLogIn() {
        homePage = new HomePage().clickHome();
        homePage.isRegistered(getLogin());
    }

    @When("Задаём setFakeList4")
    public void setFakeList() {
        fakePage = new FakeActionsPage().setFakeList();
    }

    @Then("Получаем getFakeList4")
    public void printFakeList() {
       fakePage.printFakeList();
    }
}
