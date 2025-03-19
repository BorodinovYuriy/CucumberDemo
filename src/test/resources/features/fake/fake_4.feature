Feature: Тестовая фича - заглушка (обманка)4
  Scenario: Fake - сценарий
    Given Пользователь авторизован на сайте
    When Задаём setFakeList4
    Then Получаем getFakeList4