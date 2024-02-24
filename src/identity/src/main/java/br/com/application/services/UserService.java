package br.com.application.services;

import br.com.domain._share.ApiException;
import br.com.domain._share.NotificationPattern;
import br.com.domain.entities.User;
import br.com.domain.interfaces.gateway.IuserGateway;
import br.com.domain.interfaces.services.IuserService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IuserService {


	private final IuserGateway iuserGateway;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserService(IuserGateway iuserGateway, BCryptPasswordEncoder passwordEncoder	) {


		this.iuserGateway = iuserGateway;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Long save(User user) {
		validate(user);
		existsByName(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		var result = iuserGateway.save(user);
		return result;
	}

	@Override
	public Optional<User> findById(Long id) {
		var result = iuserGateway.findById(id);
		return result;
	}

	@Override
	public List<User> findAll() {
		var result = iuserGateway.findAll();
		return result;
	}

	@Override
	public void delete(Long id) {
		iuserGateway.delete(id);
	}

	@Override
	public void update(User user) {
		validateId(user.getId());
		iuserGateway.update(user);
	}

	private void validate(User user) {
		var erros = new NotificationPattern();
		user.validate(erros);
		if (erros.hasErros()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, erros.getListErros());
		}
	}

	private void existsByName(User user) {
		var validate = iuserGateway.existsByName(user.getName());

		if (validate) {
			throw new ApiException(HttpStatus.CONFLICT, "This user already exists. ");
		}
	}

	private void validateId(Long id) {
		var exist = iuserGateway.existsById(id);
		if (!exist) {
			throw new ApiException(HttpStatus.NOT_FOUND, "Register not found");
		}
	}
}