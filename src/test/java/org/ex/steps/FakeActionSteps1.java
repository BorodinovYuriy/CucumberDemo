package org.ex.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ex.pages.FakeActionsPage;

public class FakeActionSteps1 extends BaseSteps {
    FakeActionsPage fakePage;

    @When("Задаём setFakeList")
    public void setFakeList() {
        fakePage = new FakeActionsPage().setFakeList();
    }

    @Then("Получаем getFakeList")
    public void printFakeList() {
       fakePage.printFakeList("1");
    }
}
