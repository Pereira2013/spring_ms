package br.com.domain.entities;

import br.com.domain._share.NotificationPattern;
import br.com.domain.validator.UserValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity(name = "user")
@Table(name = "users")
public class User {

	public User(String name, String email, String password, String cpf) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
	}

	public User(long id, String name, String email, String password, String cpf, List<Role> roleList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.roleList = roleList;
	}

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	@Column(name = "cpf", nullable = false, unique = true, length = 14)
	private String cpf;

	@ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
	@JoinTable(name = "user_role",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	private List<Role> roleList;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCpf() {
		return cpf;
	}

	public void validate(NotificationPattern notificationPattern) {
		new UserValidator().validate(this, notificationPattern);
	}

	;
}
