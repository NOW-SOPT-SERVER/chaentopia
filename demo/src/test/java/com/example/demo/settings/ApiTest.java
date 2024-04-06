package com.example.demo.settings;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort // 포트 번호는 이곳에 넣겠다!
    private int port;

    @BeforeEach // 모든 테스트 전에 실행하겠다는 뜻
    void setUp() {
        RestAssured.port = port;
    }
}
