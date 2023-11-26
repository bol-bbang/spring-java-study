package com.example;

import com.example.service.UserService;
import com.example.service.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EventHandlingApplicationTests {
	@Autowired
	UserService userService;

	@Test
	void 가입메일발송() {
		userService.signUp("test@test.com", "green");
	}

	@Test
	void 사용자_저장() {
		String email = "test@test.com";
		String name = "green";
		User user = userService.createUser(email, name);
		List<User> all = userService.getUsers();
		assertThat(all.size()).isEqualTo(1);
		assertThat(all.get(0).getEmail()).isEqualTo(user.getEmail());
	}
}
