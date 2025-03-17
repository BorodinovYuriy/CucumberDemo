package org.ex.steps;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class BaseStep {
    private static final Faker faker = new Faker();

    private static final ThreadLocal<String> loginThreadLocal = ThreadLocal.withInitial(() ->
            faker.name().firstName()
                    + "_MyTestOnSelenideCucumber_"
                    + faker.name().firstName());

    private static final ThreadLocal<String> passwordThreadLocal = ThreadLocal.withInitial(() ->
            faker.internet().password());

    public String getLogin() {
        return loginThreadLocal.get();
    }

    public String getPassword() {
        return passwordThreadLocal.get();
    }
}
