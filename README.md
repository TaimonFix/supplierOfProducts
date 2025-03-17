# Тестовое задание на стажировку в Северсталь

## Задание №3.

**Кейс:** имеется 3 поставщика, каждый из поставщиков может поставлять 2 вида груш
и 2 вида яблок. Поставщики заранее сообщают свои цены на виды продукции на
определенный период поставок.
Задача:
1. Создать интерфейс приёмки поставок от поставщиков. В одной поставке от
   поставщика может быть несколько видов продукции.
2. Создать отчёт. За выбранный период показать поступление видов продукции по
   поставщикам с итогами по весу и стоимости.

* ## Стек технологий

     * Backend: Java
     * Frontend: HTML + Thymeleaf
     * DB: PostgreSQL
     * Frameworks: Spring boot + Hibernate + Lombok
     * Container: Docker

* ## Физическая модель
![Физ. модель.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/Физ.%20модель.png)
### Сущности
   **supplier** - таблица с поставщиками товаров.
   
   **product** - таблица с продуктами.
   
   **delivery** - таблица с поставками.
   
   **delivery_product** - таблица, объединяющая поля delivery_id, product_id из таблиц Delivery, Product.

## Инструкция по запуску приложения
1. Клонируйте репозиторий в свою IDE
2. Запустите Docker Desktop на своём компьютере
3. Запустите терминал в [корне](https://github.com/TaimonFix/supplierOfProducts/blob/master) приложения
4. В терминале введите команду: `docker-compose up -d --build`
5. Запустите [SupplierOfProductsApplication.java](src/main/java/com/bratyshevTD/supplierOfProducts/SupplierOfProductsApplication.java).

Приложение размещено по локальному адресу: [localhost://8883/app](http://localhost:8883/app)

## Работа приложения

После запуска приложения пользователь оказывается в главном меню, в котором есть 2 функции:
1. Прием товаров - предлагается заполнить форму, состоящей из следующих атрибутов:
    * ФИО поставщика
    * Дата поставки
    * Информация о товаре: название, количество и цена (можно заполнить от 1 до 4 товаров)
      
   Проведение приемки осуществляется нажатием кнопки 'Провести'.

![input_product.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/input_product.png)

2. Формирование отчета - предлагается ввести интервал, по которому будет сформирован отчет. 

   Создание отчета осуществляется нажатием кнопки 'Сформировать отчет'.

![input_report.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/input_report.png)

Сформированный отчет:

![report.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/report.png)

ВАЖНО:
1. При заполнении ФИО поставщика, данные брать из таблицы [Поставщики](http://localhost:8883/app/supplier) (при заполнении приемки товаров использовать ФИО поставщика)

![supplier.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/supplier.png)
2. При заполнении названия товара, данные брать из таблицы [Продукты](http://localhost:8883/app/product) (при заполнении приемки товаров использовать название продукции)

![product.png](https://github.com/TaimonFix/supplierOfProducts/blob/master/images/product.png)

   

