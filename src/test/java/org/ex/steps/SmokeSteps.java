package org.ex.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.ex.pages.HomePage;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class SmokeSteps {
    HomePage homePage = new HomePage();
    List<String> categoryNameLinks;

    @And("Получен список категорий товаров")
    public void getCategoryLinksList() {
        categoryNameLinks = homePage.getCategoryElementCollection();
        Assertions.assertNotNull(categoryNameLinks,"Список категорий пуст!");
    }

    @When("Пользователь добавляет в корзину продукт {string} \\(по счёту) из каждой категории")
    public void addProductsToCart(String productNumber) {
        homePage.addProductsToCart(Integer.parseInt(productNumber),categoryNameLinks);
    }
}
