package net.javaguides.springbootkafkatutorial.controller;

import net.javaguides.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=hello
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody String message, @RequestParam(value = "topic") String topicName ){

        kafkaProducer.sendMessage(topicName, message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
