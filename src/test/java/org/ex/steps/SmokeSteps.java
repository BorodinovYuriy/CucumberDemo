package org.ex.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

public class SmokeSteps {
    HomePage homePage = new HomePage();

    @And("Получен список категорий товаров")
    public void checkCategoryLinksList() {
        Assertions.assertNotNull(homePage.getCategoryElementCollection(),
                "Список категорий пуст!");
    }

    @When("Пользователь добавляет в корзину продукт {string} \\(по счёту) из каждой категории")
    public void addProductsToCart(String productNumber) {
        homePage.addProductsToCart(Integer.parseInt(productNumber));
    }
}
