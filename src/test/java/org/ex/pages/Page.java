package org.ex.pages;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Page {
    // Общий метод для открытия страницы
    public <T extends Page> T openPage(String url, Class<T> pageClass) {
        open(url);
        return page(pageClass);
    }
}
