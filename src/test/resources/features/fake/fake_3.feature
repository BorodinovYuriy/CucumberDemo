Feature: Тестовая фича - заглушка (обманка)3
  Scenario: Fake - сценарий
    Given Пользователь авторизован на сайте
    When Задаём setFakeList3
    Then Получаем getFakeList3