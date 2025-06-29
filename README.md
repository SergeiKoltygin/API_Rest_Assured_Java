# API_Rest_Assured_Java

## Описание проекта

Проект содержит набор автотестов, написанных на Java с использованием **RestAssured**, **TestNG** и **Allure**, направленных на тестирование открытых API, включая https://reqres.in/ и https://gateway.autodns.com/.

---

## Технологии

| Компонент         | Версия     |
|-------------------|------------|
| Java              | 21         |
| RestAssured       | 3.1.1      |
| TestNG            | 6.14.3     |
| Jackson Databind  | 2.9.7      |
| Allure            | 2.13.2     |
| Maven             | 4.0.0      |

---

## Задания и покрытие тестами

### Задание 2.1 — Получение списка пользователей

- **Цель:** Получить список пользователей на второй странице ресурса https://reqres.in/api/users?page=2
- **Проверка:** Все имена файлов аватаров должны быть уникальны

### Задание 2.2 — Авторизация пользователя

- **Цель:** Протестировать два сценария авторизации:
    - Успешный вход с валидными данными
    - Ошибка при отсутствии пароля
- **Источник данных:** `LoginDataProvider` из пакета `com.exemple.dataProvider`

```java
@DataProvider(name = "validLoginData")
public static Object[][] validLoginData() {
    return new Object[][]{
        {"eve.holt@reqres.in", "pistol"}
    };
}
java
Копировать
Редактировать
@DataProvider(name = "invalidLoginData")
public static Object[][] invalidLoginData() {
    return new Object[][]{
        {"sydney@fife", null}
    };
}
```

## Клонирование проекта
```bash
git clone https://github.com/SergeiKoltygin/API_Rest_Assured_Java.git
cd API_Rest_Assured_Java
```