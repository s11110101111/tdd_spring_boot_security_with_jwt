package com.example.tdd_spring_sec_with_jwt_and_postgres;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Интеграционный тест приложения
 */
@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@DisplayName("Получение списка пользователей с аутентификацией ")
class TddSpringSecWithJwtAndPostgresApplicationTests {

    @LocalServerPort
    public static int port;
    private static final ObjectMapper om = new ObjectMapper();
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Прохождение аутентификации")
    void canGetListUsersIntegrationTest() {
        ResponseEntity<String> responseEntity = testRestTemplate
            .withBasicAuth("admin", "password")
            .getForEntity("/api/users", String.class);
        printJSON(responseEntity);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(APPLICATION_JSON);


    }

    @SneakyThrows
    private static void printJSON(Object obj) {

        log.info("Локальный порт сервера - : {}", port);
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(obj));

    }

}
