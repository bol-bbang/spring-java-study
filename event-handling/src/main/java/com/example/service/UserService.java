package com.example.service;

import com.example.event.SignUpAsyncEvent;
import com.example.event.SignUpEvent;
import com.example.service.user.entity.User;
import com.example.service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

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
		log.info("sync >> before publish event! thread_id: {}", Thread.currentThread().getId());
		publisher.publishEvent(new SignUpEvent(email, name));
		log.info("sync >> after publish event! thread_id: {}", Thread.currentThread().getId());
	}

	public void signUp_asyncSendEmail(String email, String name) {

		//1.유저저장
		createUser(email, name);
		//2.메일발송(async)
		log.info("async >> before publish event! thread_id: {}", Thread.currentThread().getId());
		publisher.publishEvent(new SignUpAsyncEvent(email, name));
		log.info("async >> after publish event! thread_id: {}", Thread.currentThread().getId());
	}

	public User createUser(String email, String name) {
		log.info("유저 저장, email: {}, name: {}", email, name);
		User user = new User(email, name);
		if(email.equals("user-save@fail.com")) {
			throw new RuntimeException("유저 저장 실패");
		}
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> all = userRepository.findAll();
		return all;
	}
}
