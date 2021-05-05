# Голосование за ресторан

## Используемые технологии: Hibernate / Maven / SQL / Spring / Spring MVC / Spring Security / JPA(Hibernate) / Spring Boot
### Описание:
#### В проекте реализована система голосования за место обеда.

* В условной организации 2 типа пользователей: Администратор и обычный Пользователь.  
Администратор составляет список ресторанов и их меню на предстоящий день.  
[Изображение с примером](https://user-images.githubusercontent.com/71580397/117102556-02477500-ad92-11eb-89f0-1879b4399da5.png)  

* Пользователь голосует за один из ресторанов в котором он хотел бы пообедать.   
[Изображение с примером](https://user-images.githubusercontent.com/71580397/117102675-3e7ad580-ad92-11eb-83cb-5ccdac2f6a0b.png)  

* Изменить свой выбор пользователь может до 11:00.  
[Изображение с примером](https://user-images.githubusercontent.com/71580397/117102699-50f50f00-ad92-11eb-8ba7-d93edaa6f4fb.png) 

* Администратор может просматривать результат голосования и её историю  
[Изображение с примером](https://user-images.githubusercontent.com/71580397/117099649-205da700-ad8b-11eb-9955-6078feaf354d.png)  
[Изображение с примером](https://user-images.githubusercontent.com/71580397/117103142-3707fc00-ad93-11eb-8478-245b3b4fddfa.png) 
____
### Установка проекта:
* К проекту подключена встроенная база данных H2,использующая для временного хранения данных оперативную память.
* Данные учётных записей,для тестирования:

| Логин | Пороль | Должность |
|----------------|:---------:|----------------:|
| ivan | ivan | admin |
| mila | mila | user |
| rita | rita | user |
| egor | egor | user |
| adam | adam | user |
| oleg | ivan | user |
| eva | eva | user |
| elena | elena | user |
| vitaliy | vitaliy | user |
| isa | isa | user |
| alex | alex | user |
