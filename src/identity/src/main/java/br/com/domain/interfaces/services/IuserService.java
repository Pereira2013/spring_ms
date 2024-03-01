package br.com.domain.interfaces.services;

import br.com.domain.entities.Role;
import br.com.domain.entities.User;
import java.util.List;
import java.util.Optional;

public interface IuserService {
	Long save(User user);
	Optional<User> findById(Long id);
	List<User> findAll();
	void delete(Long id);
	void update(User user);
}
