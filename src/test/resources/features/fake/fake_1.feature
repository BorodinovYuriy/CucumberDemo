Feature: Тестовая фича - заглушка (обманка)1
  Scenario: Fake - сценарий
    Given Пользователь авторизован на сайте
    When Задаём setFakeList
    Then Получаем getFakeList