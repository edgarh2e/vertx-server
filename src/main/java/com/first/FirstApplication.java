package com.first;

import com.first.service.HelloMicroservice;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FirstApplication {

	@Autowired
	Vertx vertx;

	@Autowired
	private HelloMicroservice helloMicroservice;

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@EventListener
	public void deployServerVerticle(ApplicationReadyEvent event) {
		vertx.deployVerticle(helloMicroservice);
	}
}
