package org.ex.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class BeforeLogPage extends Page{

    @Step("Sing up - Регистрация нового пользователя")
    public AfterLogPage singUp(String login, String password) {
        $(new By.ById("signin2")).click();
        $(new By.ById("sign-username")).shouldBe(clickable).setValue(login);
        $(new By.ById("sign-password")).shouldBe(clickable).setValue(password);
        $x("//button[text() = 'Sign up']").click();
        switchTo().alert().accept();

        return page(AfterLogPage.class);
    }
}
