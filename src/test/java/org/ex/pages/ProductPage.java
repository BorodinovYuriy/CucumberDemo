package org.ex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductPage extends Page{
    SelenideElement addToCartBTN = $("[onclick^='addToCart']");

    @Step("Нажать Add to cart кнопку")
    public <T extends Page> T clickAddToCart(Class<T> typeNextPage){
        addToCartBTN.click();
        return typeNextPage.cast(page(typeNextPage));
    }
}
