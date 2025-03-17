package org.ex.pages;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends Page{

    List<String> fakeList;

    public boolean isRegistered(String username) {
        $("#logout2").shouldBe(visible);
        return $("#nameofuser").getText().contains(username);
    }
    public HomePage clickHome(){
        $(".nav-link[href='index.html']").click();
        return this;
    }
    public HomePage setFakeList(){
        fakeList = new ArrayList<>();

        fakeList.add("один");
        fakeList.add("два");
        fakeList.add("три");
        return this;
    }

    public HomePage getFakeList() {
        System.out.println(fakeList);
        return this;
    }
}
