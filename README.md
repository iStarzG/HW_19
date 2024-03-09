# Проект по автоматизации тестовых сценариев для сайта компании Avito.ru
<p align="center">
<img width="70%" title="Avito logo" src="media/screens/logo/AvitoLogo.png">
</p>

## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid дистанционно](#-видео-примера-запуска-тестов-в-selenoid-дистанционно)

## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/screens/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/screens/logo/Java.svg">
<img width="6%" title="Selenide" src="media/screens/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/screens/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/screens/logo/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/screens/logo/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/screens/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/screens/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/screens/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/screens/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/screens/logo/Telegram.svg">
<img width="5%" title="Jira" src="media/screens/logo/Jira.svg">
</p>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализован билд в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean avito_test -Denvironment=${ENVIRONMENT} -Dbrowser.name=${BROWSER_NAME} -Dbrowser.version=${BROWSER_VERSION} -Dbrowser.size=${BROWSER_SIZE} -Dbrowser.remote.url=${REMOTE_BROWSER_URL} -Dbrowser.base.url=${BROWSER_BASE_URL} -Dpage.load.strategy=${PAGE_LOAD_STRATEGY}
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.

### Параметры сборки

* <code>ENVIRONMENT</code> - выбор среды тестирования между <code>prod</code> и <code>stage</code>.
* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По умолчанию – <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию – <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию – <code>1920x1080</code>.
* <code>REMOTE_BROWSER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты. По умолчанию – <code>https://user1:1234@selenoid.autotests.cloud/wd/hub</code>.
* <code>BROWSER_BASE_URL</code> - адрес проекта для создания автоматизированного тест-проекта. По умолчанию - <code>https://www.avito.ru/</code>.
* <code>PAGE_LOAD_STRATEGY</code> - выбор стратегии загрузки во время выполнения автотестов. По умолчанию - <code>eager</code>.
* <code>COMM</code> - комментарий, который отправляет бот в <code>Telegram</code> после прогона тестов.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/screens/logo/Jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел <code>Build with Parameters</code>, указать параметры и нажать кнопку <code>Build</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsScreen.png">
</p>
После выполнения сборки, в блоке <code>Build History</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/screens/logo/Allure_Report.svg"> Пример Allure-отчета
### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/AllureScreen.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/screens/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

На *Dashboards* в <code>Allure TestOps</code> видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы. Новые тесты, а так же результаты прогона приходят по интеграции при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/DashboardsScreen.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Test Results in Alure TestOps" src="media/screens/LaunchesScreen.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/screens/logo/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screens/JiraScreen.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/screens/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/NotificationsScreen.jpg">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/screens/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid дистанционно

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео после прохождения теста
<p align="center">
  <img title="Video after the Test with Selenoid" src="media/video/TestVideo.gif">
</p>
