package org.unit;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitTests {

    @Test
    public void testEnvConfig() {

        Dotenv dotenv = Dotenv.configure()
                .directory("src/test/resources")
                .filename(".env.test")
                .load();

        String envVar1 = dotenv.get("TEST_ENV_VAR_1");
        String envVar2 = dotenv.get("TEST_ENV_VAR_2");

        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties")); // Или "application.yml"
        } catch (Exception e) {
            e.printStackTrace();
        }

        String configVar1 = properties.getProperty("app.config.var1");
        String configVar2 = properties.getProperty("app.config.var2");

        assertNotNull(envVar1, "Переменная TEST_ENV_VAR_1 не должна быть null");
        assertEquals("test_value_1", envVar1, "Значение TEST_ENV_VAR_1 не совпадает");

        assertNotNull(envVar2, "Переменная TEST_ENV_VAR_2 не должна быть null");
        assertEquals("test_value_2", envVar2, "Значение TEST_ENV_VAR_2 не совпадает");

        System.out.println("Переменная из .env.test: TEST_ENV_VAR_1 = " + envVar1);
        System.out.println("Переменная из .env.test: TEST_ENV_VAR_2 = " + envVar2);

        assertNotNull(configVar1, "Переменная app.config.var1 из application.properties не должна быть null");
        assertEquals("config_value_1", configVar1, "Значение app.config.var1 не совпадает");

        assertNotNull(configVar2, "Переменная app.config.var2 из application.properties не должна быть null");
        assertEquals("config_value_2", configVar2, "Значение app.config.var2 не совпадает");

        System.out.println("Переменная из application.properties: app.config.var1 = " + configVar1);
        System.out.println("Переменная из application.properties: app.config.var2 = " + configVar2);
    }
    @Test
    public void testEnvConfigOverride() {

        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dotenv dotenv = Dotenv.configure()
                .directory("src/test/resources")
                .filename(".env.test")
                .load();

        dotenv.entries().forEach(entry -> {
            properties.setProperty(entry.getKey(), entry.getValue());
        });


        String overriddenVar = properties.getProperty("app.config.overridden");

        assertNotNull(overriddenVar, "Переменная app.config.overridden не должна быть null");
        assertEquals("env_value", overriddenVar, "Значение app.config.overridden должно быть перезаписано из .env");

        System.out.println("Переменная app.config.overridden после перезаписи: " + overriddenVar);
    }
}
