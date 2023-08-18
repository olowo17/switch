package com.interswitch.services.taskservice;

import com.interswitch.services.taskservice.model.Task;
import com.interswitch.services.taskservice.repository.TaskRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Task API", version = "1.0", description = "Documentation Task API v1.0")
)
public class TaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

	@Bean
	TaskRepository repository() {
		TaskRepository repository = new TaskRepository();
		repository.add(new Task("Cook", 1L));
		repository.add(new Task("Read", 2L));
		repository.add(new Task("Sleep", 1L));
		repository.add(new Task("Play", 2L));
		return repository;
	}

}
