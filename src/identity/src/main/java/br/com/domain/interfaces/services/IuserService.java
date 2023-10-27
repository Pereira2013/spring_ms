package br.com.domain.interfaces.services;

import br.com.domain.entities.User;
import java.util.Optional;

public interface IuserService {
	Long save(User user);
	Optional<User> findById(Long id);
}
