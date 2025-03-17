package org.ex.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AfterLogPage extends Page{

    public <T extends Page> T logIn(String login, String password, Class<T> typeNextPage) {
        $(new By.ById("login2")).click();
        $(new By.ById("loginusername")).shouldBe(clickable).setValue(login);
        $(new By.ById("loginpassword")).shouldBe(clickable).shouldBe(visible).setValue(password);
        $x("//button[text() = 'Log in']").click();

        return typeNextPage.cast(page(typeNextPage));
    }
}
