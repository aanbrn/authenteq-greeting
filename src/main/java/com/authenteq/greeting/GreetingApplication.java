package com.authenteq.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;

@SpringBootApplication
@EnableConfigurationProperties(GreetingProperties.class)
@Controller
@RequiredArgsConstructor
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

    @NotNull
    private final GreetingProperties greetingProperties;

    @GetMapping
    String greeting(final Model model) {
        model.addAttribute("name", greetingProperties.getName());
        return "greeting";
    }

}
