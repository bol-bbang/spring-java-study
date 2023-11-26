package com.example.service.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;

	private String email;
	private String name;

	public User(String email, String name) {
		this.email = email;
		this.name = name;
	}
}
