package org.ex.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.ex.pages.FakeActionsPage;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class FakeActionSteps3 extends BaseSteps {
    HomePage homePage;
    FakeActionsPage fakePage;



    @When("Задаём setFakeList3")
    public void setFakeList() {
        fakePage = new FakeActionsPage().setFakeList();
    }

    @Then("Получаем getFakeList3")
    public void printFakeList() {
       fakePage.printFakeList("3");
    }
}
