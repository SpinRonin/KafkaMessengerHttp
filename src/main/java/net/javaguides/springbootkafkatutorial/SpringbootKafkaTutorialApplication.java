package net.javaguides.springbootkafkatutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringbootKafkaTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaTutorialApplication.class, args);
	}

	@KafkaListener(id = "myId", topics = "topic1")
	public void listen(String in) {
		System.out.println(in);
	}
}
