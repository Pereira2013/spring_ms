package br.com.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity(name = "roles")
@Table(name = "roles")
public class Role {

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY)
	private List<User> userList;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
