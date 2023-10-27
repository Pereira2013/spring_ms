package br.com.application.services;

import br.com.domain._share.ApiException;
import br.com.domain._share.NotificationPattern;
import br.com.domain.entities.User;
import br.com.domain.interfaces.gateway.IuserGateway;
import br.com.domain.interfaces.services.IuserService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IuserService {

	private final IuserGateway iuserGateway;

	public UserService(IuserGateway iuserGateway) {this.iuserGateway = iuserGateway;}

	@Override
	public Long save(User user) {
		validate(user);
		var result = iuserGateway.save(user);
		return result;
	}

	@Override
	public Optional<User> findById(Long id) {
		var result = iuserGateway.findById(id);
		return result;
	}

	private void validate(User user){
		var erros = new NotificationPattern();
		user.validate(erros);
		if(erros.hasErros()){
			throw new ApiException(HttpStatus.BAD_REQUEST, erros.getListErros());
		}
	}
}