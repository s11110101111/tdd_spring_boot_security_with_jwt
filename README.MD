### План для TDD 
## Приложение пользователи
Организовать получение через REST списка пользователей с ролями.
Организовать доступ к REST с помощью авторизации по паролю с предоставлением токена JWT.
Хранить пользователей в БД.
Предоставить токен продления для автоматической регенерации истекшего токена
Токены предоставленные пользователю сохранять в БД 

##План работ TDD
1. Создать Spring Security project
2. SpringBootTest
    настроить MocMvc c WebApplicationContext и применить SpringSecurity
3. написать два теста на доступ к одному ресурсу без пароля к другому по паролю с наличием права админа
4. получить все зеленые тесты, описать фильтр для безопасности http и REST контроллер с двумя путями к ресурсам 
5. добавить в тест http-client
6. добавить сервисы dao из памяти и репозитория postgres
7. Подключить север аутентификации 
8. подключить JWT

### Настройки для hibernate.
брал от сюда [Building fast scalable persistent layer with Spring](https://youtu.be/smyFi4OCHDE?t=310)
### Видео о безопасности и рассказывают про сервер авторизации jwt и как добавить потом роли
[Доклад на утубе](https://youtu.be/xEnvAAhMGu4)
[Немного про север аутентификации](https://youtu.be/xEnvAAhMGu4)
[JWT токен](https://youtu.be/VVn9OG9nfH0)
[TDD test](https://youtu.be/z6gOPonp2t0)
[unit test](https://youtu.be/Geq60OVyBPg)
[Test Driven Development with Spring Boot - Sannidhi Jalukar, Madhura Bhave](https://youtu.be/s9vt6UJiHg4)
[Test-Driven Security](https://youtu.be/TytSz7u1xQ8)


