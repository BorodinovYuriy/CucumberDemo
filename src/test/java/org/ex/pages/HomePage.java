package org.ex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends Page{

SelenideElement welcomeLogin = $("#logout2");
SelenideElement nameOfUser = $("#nameofuser");
SelenideElement homeLink = $(".nav-link[href='index.html']");

    @Step("Проверка наличия имени пользователя в Welcome линке")
    public boolean isRegistered(String username) {
        welcomeLogin.shouldBe(visible);
        return nameOfUser.getText().contains(username);
    }
    @Step("Клик Home линк")
    public <T extends Page> T clickHome(Class<T> typeNextPage){
        homeLink.click();
        return typeNextPage.cast(page(typeNextPage));
    }

}
