package com.javaguides.producer;

import com.javaguides.producer.kafka.WikimediaChangeHandler;
import com.javaguides.producer.kafka.WikimediaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	private WikimediaProducer wikimediaProducer;

	@Autowired
	public void setWikimediaChangeHandler(WikimediaProducer wikimediaProducer) {
		this.wikimediaProducer = wikimediaProducer;
	}

	@Override
	public void run(String... args) throws Exception {
		wikimediaProducer.sendMessage();
	}
}
