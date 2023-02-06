package com.springbootstarterch0401springasyncrequesthandling.demo.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerUsingCompletableFuture {
	private final TaskExecutor taskExecutor;

	public HelloWorldControllerUsingCompletableFuture(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@GetMapping("/helloUsingCompletableFuture")
	public CompletableFuture<String> helloUsingCompletableFuture() {
		return CompletableFuture.supplyAsync(() -> {
			randomDelay();
			return "Hello World, from Spring Boot 2 Using CompletableFuture!";
		}, taskExecutor);
	}

	private void randomDelay() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
