package br.com.infrastructure.DTO.IN;

import br.com.domain.entities.User;

public record UserIn(String name, String email,String password, String cpf) {

	public User toDomain(){
		return new User(name, email, password, cpf);
	}
}
