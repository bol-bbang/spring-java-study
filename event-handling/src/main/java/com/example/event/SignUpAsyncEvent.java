package com.example.event;

import lombok.Getter;

@Getter
public class SignUpAsyncEvent {
	private String email;
	private String name;

	public SignUpAsyncEvent(String email, String name) {
		this.email = email;
		this.name = name;
	}
}
