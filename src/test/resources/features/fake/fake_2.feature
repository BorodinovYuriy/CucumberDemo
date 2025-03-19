Feature: Тестовая фича - заглушка (обманка)2
  Scenario: Fake - сценарий
    Given Пользователь авторизован на сайте
    When Задаём setFakeList2
    Then Получаем getFakeList2