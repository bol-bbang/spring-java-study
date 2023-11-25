package com.example.service;

import com.example.event.SignUpEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final ApplicationEventPublisher publisher;
	public void signUp() {
		//1.유저저장
		//repository.save(user);
		//2.메일발송
		publisher.publishEvent(new SignUpEvent("test@test.com", "green"));
	}
}
