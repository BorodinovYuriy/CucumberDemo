package org.ex.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends Page{

    private SelenideElement welcomeLogin    = $("#logout2");
    private SelenideElement nameOfUser      = $("#nameofuser");
    private SelenideElement homeLink        = $(".nav-link[href='index.html']");
    private ElementsCollection category     = $$("#itemc");
    private ElementsCollection productLinks = $$x("//div[@id='tbodyid']//h4[@class='card-title']");
    private String xPathCat = "//a[@id='itemc' and text() = '"; //todo спросить GPT!!!


    @Step("Клик Home линк")
    public <T extends Page> T goHome(Class<T> typeNextPage){
        homeLink.click();
        return typeNextPage.cast(page(typeNextPage));
    }
    @Step("Проверка наличия имени пользователя в Welcome линке")
    public boolean isRegistered(String username) {
        welcomeLogin.shouldBe(visible);
        return nameOfUser.getText().contains(username);
    }

    @Step("Получение списка категорий товаров")
    public List<String> getCategoryElementCollection() {
        return category.stream()
                .map(SelenideElement::getText)
                .toList()
                .reversed();
    }
    @Step("Добавление продуктов из каждой категории товаров в корзину")
    public void addProductsToCart(int productNumber, List<String> categoryLinks) {
        categoryLinks.forEach(categoryLink -> {
            $x(xPathCat+categoryLink+"']").click();
           sleep(500);

            productLinks.get(productNumber).click();
            sleep(2000);
            goHome(HomePage.class);
        });

    }
}
