package infrastructure.http.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class TesteController {
    @GetMapping
    public String testeResponse() {
        return "hello";
    }
}