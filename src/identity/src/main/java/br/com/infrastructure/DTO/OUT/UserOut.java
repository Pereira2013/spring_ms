package br.com.infrastructure.DTO.OUT;

import br.com.domain.entities.User;
import java.util.Optional;

public record UserOut(Long id, String name) {

	public static UserOut toOut(User user){
		return new UserOut(user.getId(), user.getName());
	}

	public static Optional<UserOut> toOutOptional(Optional<User> userOptional){
		if(userOptional.isEmpty()){
			return Optional.empty();
		}
		var result = userOptional.get();

		return Optional.of(new UserOut(result.getId(), result.getName()));
	}
}
