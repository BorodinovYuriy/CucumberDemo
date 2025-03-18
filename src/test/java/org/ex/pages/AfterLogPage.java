package org.ex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AfterLogPage extends Page{

    SelenideElement loginLink     = $("#login2");
    SelenideElement loginUsername = $("#loginusername");
    SelenideElement loginPassword = $("#loginpassword");
    SelenideElement loginBTN      = $x("//button[text() = 'Log in']");

    @Step("Log in - Авторизация нового пользователя")
    public <T extends Page> T logIn(String login, String password, Class<T> typeNextPage) {
        loginLink.click();
        loginUsername.shouldBe(clickable).setValue(login);
        loginPassword.shouldBe(clickable).shouldBe(visible).setValue(password);
        loginBTN.click();

        return typeNextPage.cast(page(typeNextPage));
    }
}
