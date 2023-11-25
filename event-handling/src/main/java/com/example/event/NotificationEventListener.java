package com.example.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {

	private final NotificationExecutor notificationExecutor;

	@EventListener
	public void emailListener(SignUpEvent event) {
		// 이메일 발송 로직 호출
		notificationExecutor.sendEmail(event.getEmail(), "가입축하메일", "가입을 축하합니다.");
	}
}
