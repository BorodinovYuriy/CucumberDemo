package org.ex.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.ex.pages.FakeActionsPage;
import org.ex.pages.HomePage;

@Slf4j
public class FakeActionSteps2 extends BaseStep {
    HomePage homePage;
    FakeActionsPage fakePage;

    @Given("Пользователь авторизован на сайте2")
    public void isUserLogIn() {
        homePage = new HomePage().clickHome();
        homePage.isRegistered(getLogin());
    }

    @When("Задаём setFakeList2")
    public void setFakeList() {
        fakePage = new FakeActionsPage().setFakeList();
    }

    @Then("Получаем getFakeList2")
    public void printFakeList() {
       fakePage.printFakeList();
    }
}
