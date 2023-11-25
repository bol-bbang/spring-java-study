package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventHandlingApplicationTests {
	@Autowired
	UserService userService;

	@Test
	void 가입메일발송() {
		userService.signUp("test@test.com", "green");
	}

}
