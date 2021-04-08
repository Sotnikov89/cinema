# Цель проекта
Проект использовался для отработки работы с сервлетами, с JDBC, MVC паттерна и слоеной архитектуры.
# Описание проекта
Проект представляет собой упрощенную часть кинотеатра, а именно, зал с возможностью выбора мест. Занятые места загружаются из БД через Аjax и меняют кнопки на деактивированные, поэтому выбранные места купить нельзя. Также при наведении на кнопки появится "описание". На страницах используется валидация, при пустых поялх или не выбранных местах, перейти к оплате не получится и появится соотвествующее предупреждение.
![ScreenShot](images/1.png)
Проект имеет слоеную архитектуру, а также применяется внедрение зависимостей (вручную). Контроллеры это сервлеты, практически не содержат в себе бизнес логики, а лишь получают необходимые данные из БД при помощи сервисов (не напрямую) и передают их на View (jsp страницы в WebApp). Дао отвечает за доступ к БД и CRUD операции. Сервисы отвечают за "специальные" методы, несущие в себе конкретную бизнес логику необходимую для работы контроллеров. Модель содержит обычные Pojo.
![ScreenShot](images/2.PNG)
В проекте используется определение сервлета через аннотации, без использования Web.xml.,
![ScreenShot](images/3.PNG)
Если пользователи выберут одни и те же места, то тот кто первый произведет оплату, получит билет, а другой увидит сообщение о том, что места уже заняты и нужно выбрать другие.
![ScreenShot](images/4.PNG)
# Запуск проекта
Для запуска потребуется PostgreSQL. Необходимо указать в cinemaDB.properties корректные данные для подключения к БД. Путь к cinemaDB.properties указан в классе DbConnection. Создать таблицы в БД можно при помощи скрипта из папки db.script. Сконфигурировать Tomcat http://localhost:8080/cinema/
