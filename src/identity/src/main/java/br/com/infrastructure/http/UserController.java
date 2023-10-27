package br.com.infrastructure.http;

import br.com.application.services.UserService;
import br.com.domain.entities.User;
import br.com.domain.interfaces.services.IuserService;
import br.com.infrastructure.DTO.IN.UserIn;
import br.com.infrastructure.DTO.OUT.UserOut;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/v1")
public class UserController {

	private final IuserService iuserService;

	public UserController(UserService userService, IuserService iuserService) {
		this.iuserService = iuserService;
	}
	@PostMapping
	public ResponseEntity<Long> save(@Valid @RequestBody UserIn request){
		var id = iuserService.save(request.toDomain());
		return ResponseEntity.created(URI.create("/" + id)).body(id);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Optional<UserOut>> findById(@PathVariable Long id){
		var result = iuserService.findById(id);
		var response = UserOut.toOutOptional(result);
		return ResponseEntity.ok().body(response);
	}

}


