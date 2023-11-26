package com.example.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor {

	public void sendEmail(String recipient, String title, String contents) {
		// 실제 이메일 발송 부분
		if(recipient.equals("send-email@fail.com")) {
			throw new RuntimeException("이메일 발송 실패");
		}
		log.info("send email, recipient:{}, title:{}, contents:{}", recipient, title, contents);
		log.info("send email! thread_id: {}", Thread.currentThread().getId());
	}
}
