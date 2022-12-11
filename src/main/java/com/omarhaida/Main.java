package com.omarhaida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse(
                "Greet",
                List.of("Java", "Golang", "JavaScript", "Ruby", "Carbon"),
                new Person(
                        "Omar Haida",
                        21,
                        "10 rue 3",
                        "0620208582"
                )
        );
    }
    record Person(String name, int age, String address, String phone){}
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ) {}

    @GetMapping("/")
    public HomeResponse home() {
        return new HomeResponse("Home");
    }
    record HomeResponse(String home) {}
}