package com.study.localstack.service;

import com.study.localstack.pojo.Event;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.study.localstack.AWSConfigConstants.ORDER_CREATED_TOPIC;


@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleMessageProducer {

    private final NotificationMessagingTemplate notificationMessagingTemplate;

    public void publish(Event event) {
        notificationMessagingTemplate.convertAndSend(ORDER_CREATED_TOPIC, event);
    }
}