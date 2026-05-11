package com.deploycraft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> hello() {

        return Map.of(
                "message", "Hello from Spring Boot",
                "team", "Ihor Kaniuk / Bohdan Shvets / Oleksandr Zavoloka",
                "indexes", List.of(77372, 77364, 77427)
        );
    }
}