package com.ayushranjan.demo;

import com.ayushranjan.demo.respository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);

		alien1.setId(111);
		alien1.setName("Ayush");
		alien1.setTech("Java");

		AlienRepository alienRepository = context.getBean(AlienRepository.class);
		alienRepository.save(alien1);

		System.out.println(alienRepository.findAll());
	}

}
