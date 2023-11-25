package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor {

	public void sendEmail(String recipient, String title, String contents) {
		// 실제 이메일 발송 부분
		log.info("send email, recipient:{}, title:{}, contents:{}", recipient, title, contents);
	}
}
