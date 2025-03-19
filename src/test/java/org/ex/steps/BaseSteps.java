package org.ex.steps;

import com.github.javafaker.Faker;

public class BaseSteps {
    private static final String LOGIN;
    private static final String PASSWORD;
    private static final Faker faker;

    static {
        faker = new Faker();
        LOGIN = faker.name().firstName()
                + "_MyTestOnSelenideCucumber_"
                + faker.name().firstName();
        PASSWORD = faker.internet().password();
    }
    public static String getLogin() {
        return LOGIN;
    }
    public static String getPassword() {
        return PASSWORD;
    }


}
