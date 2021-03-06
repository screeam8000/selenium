#Автоматизировать сценарий, при разработке использовать Selenium + Cucumber + Allure
#Перейти по ссылке - https://www.raiffeisen.ru
#Выбрать пункт меню Ипотека – Ипотечный калькулятор
#Проверить, что на странице есть заголовок Ипотечный калькулятор
#Заполнить форму:
#Город – Москва
#Отметить чекбокс – Знаю свою ипотечную программу
#Вид ипотечной программы – Квартира на вторичном рынке
#Я являюсь – Новый клиент
#Уровень дохода подтверждаю -  Справка п форме Банка
#В банке возьму – 3 000 000
#Первоначальный взнос – 3 500 000
#Срок кредита – 10 лет
#Нажать Рассчитать
#Проверить, что рассчитались поля:
#Ежемесячный платеж = 40 656.67 руб.
#Общая сумма выплат 4 836 824.71 руб
#Cумма выплат по процентам 1 836 824.71 руб.
#Процентная ставка 10.49 %


@web
Feature: MortgageTest

Scenario:  Mortgage check

    Given Выбран мой регион
    Then переход по ссылке Ипотека
    Then переход по ссылке Ипотечный калькулятор
    And проверить что есть заголовок Ипотечный калькулятор
    Then заполнить данные по ипотечной заявке

    |Город|Москва|
    |Вид ипотечной программы|Квартира на вторичном рынке|
    |Я являюсь|Новый клиент|
    |Уровень доходов подтверждаю|Справка по форме Банка|

    Then заполнить следующие данные

    |В банке возьму|3 000 000|
    |Первоначальный взнос|350 000|
    |Срок кредита|10|

    Then установить чек-бокс Знаю свою ипотечную программу
    Then нажать кнопку Рассчитать
    And проверить данные

    |Ежемесячный платеж|40 656.67 руб.|
    |Общая сумма выплат |4 836 817.23 руб.|
    |Cумма выплат по процентам|1 836 817.23 руб.|
    |Процентная ставка |10.49 %|
