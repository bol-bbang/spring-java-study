package com.example.event;

import lombok.Getter;

@Getter
public class SignUpEvent {
	private String email;
	private String name;

	public SignUpEvent(String email, String name) {
		this.email = email;
		this.name = name;
	}
}
