package org.ex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class BeforeLogPage extends Page{
    SelenideElement singInLink   = $("#signin2");
    SelenideElement signUsername = $("#sign-username");
    SelenideElement signPassword = $("#sign-password");
    SelenideElement signUpBTN    = $x("//button[text() = 'Sign up']");

    @Step("Sing up - Регистрация нового пользователя")
    public AfterLogPage singUp(String login, String password) {
        singInLink.click();
        signUsername.shouldBe(clickable).setValue(login);
        signPassword.shouldBe(clickable).setValue(password);
        signUpBTN.click();
        switchTo().alert().accept();

        return page(AfterLogPage.class);
    }
}
