package br.com;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class Controller {
    ResponseEntity<?> teste(@RequestBody BodyTeste in) {
        return ResponseEntity.ok("Teste");
    }

}
record BodyTeste(String in) {
};