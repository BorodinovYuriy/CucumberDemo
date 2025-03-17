package org.ex.pages;

import java.util.ArrayList;
import java.util.List;

public class FakeActionsPage  extends Page{
    List<String> fakeList;

    public FakeActionsPage setFakeList(){
        fakeList = new ArrayList<>();

        fakeList.add("один");
        fakeList.add("два");
        fakeList.add("три");
        return this;
    }

    public void printFakeList() {
        System.out.println("FakeList test:  "+fakeList);
    }
}
