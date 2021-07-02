# qa_guru_5_24_final_project
# Автотесты на http://github.com :woman_technologist:

<a href="https://www.jetbrains.com/idea/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Intelij_IDEA.svg" width="40" height="40"  alt="IDEA"/>
</a>
<a href="https://www.java.com/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Java.svg" width="40" height="40"  alt="Java"/>
</a>
<a href="https://selenide.org/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Selenide.svg" width="40" height="40"  alt="Selenide"/>
</a>
<a href="https://aerokube.com/selenoid/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Selenoid.svg" width="40" height="40"  alt="Selenoid"/>
</a>
<a href="https://gradle.org/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Gradle.svg" width="40" height="40"  alt="Gradle"/>
</a>
<a href="https://junit.org/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/JUnit5.svg" width="40" height="40"  alt="JUnit 5"/>
</a>
<a href="http://allure.qatools.ru/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Allure_Report.svg" width="40" height="40"  alt="Allure SE"/>
</a>
<a href="https://qameta.io/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/AllureTestOps.svg" width="40" height="40"  alt="Allure EE"/>
</a>
<a href="https://github.com/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Github.svg" width="40" height="40"  alt="Github"/>
</a>
<a href="https://www.jenkins.io/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Jenkins.svg" width="40" height="40"  alt="Jenkins"/>
</a>
<a href="https://rest-assured.io/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Rest-Assured.svg" width="40" height="40"  alt="ResrAssured"/>
</a>
<a href="https://telegram.org/">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Telegram.svg" width="40" height="40"  alt="Telegram"/>
</a>
<a href="https://www.atlassian.com/ru/software/jira">
    <img src="https://github.com/nastiykr/qa_guru_5_24_final_project/tree/master/src/test/resources/files/icons/Jira.svg" width="40" height="40"  alt="Jira"/>
</a>

IntelliJ IDEA, Java, Selenide, Selenoid, Gradle, JUnit5, Allure SE, Allure TestOps, Github, Jenkins, Rest-Assured, Telegram (reports), Jira.

## Реализованы проверки:
В реализации использованы разные подходы проектирования, позволяющие достичь разного представления в отчетах
### UI
- [X] - Авторизация пользователя с неверным паролем
- [X] - Поиск репозитория через поисковую строку
- [X] - Поиск раздела Issue в репозитории
- [X] - Открытие вкладки team
- [X] - Открытие страницы shop
### API
- [X] - Создание репозитория
- [X] - Изменение названия репозитория
- [X] - Удаление репозитория
- [X] - Поиск репозитория до и после создания
- [X] - Создание Issue
- [X] - Редактирование Issue
- [X] - Блокировка Issue

### Команда для запуска из терминала
Локально должны быть заданы параметры в local.properies, app.properties
```
gradle clean
```
Для запуска в несколько потоков
```
gradle clean -Dthreads=5
```
### Видео о прохождении тестов
![Selenoid](src/test/resources/files/Selenoid.gif)

### Запуск в Jenkins
Статистика по запускам
![Jenkins](src/test/resources/files/Jenkins_1.png)
Указание параметров для запуска
![Jenkins](src/test/resources/files/Jenkins_2.png)

### Отчёт в Allure Report
![Allure](src/test/resources/files/AllureReport.png)

### Хранение тест-кейсов в Allure TestOps
Ручные и автотесты
![Allure](src/test/resources/files/AllureTestOps_3.png)
Дашборд
![Allure](src/test/resources/files/AllureTestOps_4.png)
Ланчи
![Allure](src/test/resources/files/AllureTestOps_5.png)
Результат запуска ланча
![Allure](src/test/resources/files/AllureTestOps_1.png)

### Интерграция с Jira
Отображение тест-кейсов и ланча
![Jira](src/test/resources/files/Jira.png)

### Уведомления в Telegram
![Telegram](src/test/resources/files/Telegram.png)