package br.com;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class Controller {
    @GetMapping
    @Operation(summary = "GET TESTE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Establishment",
                    useReturnTypeSchema = true,
                    content =
                            {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BodyTeste.class))}),

            @ApiResponse(responseCode = "400", description = "there was an error in validating the data"),
            @ApiResponse(responseCode = "500", description = "some unexpected error occurred"),
    })
    ResponseEntity<?> teste(@RequestBody BodyTeste in) {
        return ResponseEntity.ok("Teste");
    }

}
record BodyTeste(String in) {
};