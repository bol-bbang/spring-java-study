package com.example.service;

import com.example.event.SignUpEvent;
import com.example.service.user.entity.User;
import com.example.service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final ApplicationEventPublisher publisher;
	private final UserRepository userRepository;

	public void signUp(String email, String name) {
		//1.유저저장
		createUser(email, name);
		//2.메일발송
		publisher.publishEvent(new SignUpEvent(email, name));
	}

	private void createUser(String email, String name) {
		User user = new User(email, name);
		userRepository.save(user);
		log.info("유저 저장, email: {}, name: {}", email, name);
	}
}
