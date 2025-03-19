package org.ex.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class HomePage extends Page{

    private final SelenideElement welcomeLogin    = $("#logout2");
    private final SelenideElement nameOfUser      = $("#nameofuser");
    private final SelenideElement homeLink        = $(".nav-link[href='index.html']");
    private final ElementsCollection category     = $$("#itemc");
    private final ElementsCollection productLinks = $$x("//div[@id='tbodyid']//h4[@class='card-title']");


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
                .toList();
    }
    @Step("Добавление продуктов из каждой категории товаров в корзину")
    public void addProductsToCart(int productNumber) {
        category.asDynamicIterable().forEach(cat ->{
            cat.click();
            productLinks.get(productNumber).click();

            new ProductPage().clickAddToCart(HomePage.class);
            switchTo().alert().accept();
            goHome(HomePage.class);
        });
    }
}
