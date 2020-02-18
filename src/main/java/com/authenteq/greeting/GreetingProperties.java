package com.authenteq.greeting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("authenteq.greeting")
@Data
@Validated
class GreetingProperties {

    @NotBlank
    private String name;

}
