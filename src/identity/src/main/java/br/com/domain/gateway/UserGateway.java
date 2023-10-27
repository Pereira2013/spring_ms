package br.com.domain.gateway;

import br.com.domain.entities.User;
import br.com.domain.interfaces.gateway.IuserGateway;
import br.com.infrastructure.persistence.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserGateway implements IuserGateway {
	private final UserRepository userRepository;

	public UserGateway(UserRepository userRepository) {this.userRepository = userRepository;}

	@Override
	public Long save(User user) {
		var result = userRepository.save(user);
		return result.getId();
	}

	@Override
	public Optional<User> findById(Long id) {
		 return userRepository.findById(id).map(e-> Optional.ofNullable(e)).orElse(Optional.empty());
	}
}
