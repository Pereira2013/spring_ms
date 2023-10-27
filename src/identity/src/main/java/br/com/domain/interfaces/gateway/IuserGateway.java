package br.com.domain.interfaces.gateway;

import br.com.domain.entities.User;
import java.util.Optional;

public interface IuserGateway {
	Long save(User user);
	Optional<User> findById(Long id);
}
