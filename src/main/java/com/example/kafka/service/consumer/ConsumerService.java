package com.example.kafka.service.consumer;

import com.example.kafka.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(id = "messageListener", topicPartitions =
            { @TopicPartition(topic = "messages", partitions = "0")})
    public void getMessages(Message message) {
        log.info("Сообщение получено на партицию 0 : {}", message);
    }

    @KafkaListener(id = "messageListenerOne", topicPartitions =
            { @TopicPartition(topic = "messages", partitions = "1")})
    public void getMessagesOne(Message message) {
        log.info("Сообщение получено на партицию 1 : {}", message);
    }

    @KafkaListener(id = "messageListenerTwo", topicPartitions =
            { @TopicPartition(topic = "messages", partitions = "2")})
    public void getMessagesTwo(Message message) {
        log.info("Сообщение получено на партицию 2 : {}", message);
    }
}
