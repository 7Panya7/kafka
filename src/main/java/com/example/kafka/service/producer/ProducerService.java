package com.example.kafka.service.producer;

import com.example.kafka.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@PropertySource(value = "classpath:kafka.properties")
@ConfigurationProperties(prefix = "kafka")
public class ProducerService {
    private final KafkaTemplate<String, Message> template;
    @Value("${kafka.topic}")
    private String topic;

    public void sendMessage(String key, Message message) {
        log.info("Отправляю сообщение в кафку: {}", message.getMessage());
        template.send(topic, 0, key, message);
        log.info("Сообщение отправлено в кафку: {}", message.getMessage());
    }

    public void sendMessageOne(String key, Message message) {
        log.info("Отправляю сообщение в кафку: {}", message.getMessage());
        template.send(topic, 1, key, message);
        log.info("Сообщение отправлено в кафку: {}", message.getMessage());
    }

    public void sendMessageTwo(String key, Message message) {
        log.info("Отправляю сообщение в кафку: {}", message.getMessage());
        template.send(topic, 2, key, message);
        log.info("Сообщение отправлено в кафку: {}", message.getMessage());
    }

}
