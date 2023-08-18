package net.javaguides.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        Thread.currentThread().setContextClassLoader(null);
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topicName, String message){
        LOGGER.info("Message sent :" + message);
        kafkaTemplate.send(topicName, message);
    }
}
