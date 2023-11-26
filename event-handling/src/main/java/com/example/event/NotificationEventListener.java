package com.example.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationEventListener {

	private final NotificationExecutor notificationExecutor;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//	@EventListener
	public void emailListener(SignUpEvent event) {
		// 이메일 발송 로직 호출
		notificationExecutor.sendEmail(event.getEmail(), "가입축하메일", "가입을 축하합니다.");
		log.info("sync >> email listener! thread_id: {}", Thread.currentThread().getId());
	}

	@EventListener
	@Async
	/* @EnableAsync 추가하고, @Async 사용가능 */
	public void emailListenerAsync(SignUpAsyncEvent event) {
		// 이메일 발송 로직 호출
		notificationExecutor.sendEmail(event.getEmail(), "가입축하메일-async", "가입을 축하합니다.");
		log.info("async >> email listener! thread_id: {}", Thread.currentThread().getId());
	}
}
