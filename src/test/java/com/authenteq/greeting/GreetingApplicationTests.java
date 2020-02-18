package com.authenteq.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.TEXT_HTML;

@SpringBootTest
@AutoConfigureWebTestClient
class GreetingApplicationTests {

    @SpyBean
    private GreetingProperties greetingProperties;

    @Test
    void helloWorld(@Autowired WebTestClient webClient) {
        webClient.get().uri("/").exchange()
                 .expectStatus().isOk()
                 .expectHeader().contentTypeCompatibleWith(TEXT_HTML)
                 .expectBody(String.class)
                 .value(containsString("Hello, World!"));
    }

    @Test
    void helloTest(@Autowired WebTestClient webClient) {
        given(greetingProperties.getName()).willReturn("Test");

        webClient.get().uri("/").exchange()
                 .expectStatus().isOk()
                 .expectHeader().contentTypeCompatibleWith(TEXT_HTML)
                 .expectBody(String.class)
                 .value(containsString("Hello, Test!"));
    }

}
