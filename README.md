# Пример приложения (шаблон) example-app

## 1. Настройка
Перед созданием проекта создайте файл `.gradle/gradle.properties`
в ДОМАШНЕЙ директории.

В файле укажите следующие свойства:
```
mavenUser=<you login in Waves Enterprise Nexus>
mavenPassword=<you password in Waves Enterprise Nexus>
```

Затем войдите в Docker Registry:
```
docker login registry.wavesenterprise.com (затем реквизиты УЗ)
docker login registry.weintegrator.com (затем реквизиты УЗ)
```

(на *-nix Системых дайте нужные права скриптам инициализации БД)
```
chmod +x gradlew
chmod +x docker-compose/config/db/scripts/*.sh
chmod +x docker-compose/config/db-app/scripts/*.sh
```

## 2. Сборка (всех модулей)
Следующая команда соберет докер образы всех проектов в примере

`./gradlew clean dockerTag`

## 3. Импорт в IDE
В IDEA выберите File -> Open... Затем укажите путь к файлу build.gradle.kts в корне проекта.
На предложение импортировать как проект ответьте да.

## 4. Запуск из IDE

Запуск узлов блокчейн: 
```
docker-compose -f docker-compose.yml up -d
```

Запуск плаформы: 
```
docker-compose -f docker-compose-base.yml up -d
```

Запуск только БД:
```
docker run --name app-pg -d -e POSTGRES_PASSWORD=password -e POSTGRES_USER=postgres -e POSTGRES_DB=db_example_app -p 5432:5432 -d postgres:11.10
```

### Предсозданные пользователи
Предсозданный пользователь - реквизиты: `user/user`.
Дополнительные пользователи могут быть заведены в файле:
`docker-compose/config/vst-oauth2/user-companies.json`.