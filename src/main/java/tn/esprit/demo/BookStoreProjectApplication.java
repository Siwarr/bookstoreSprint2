package tn.esprit.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BookStoreProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreProjectApplication.class, args);
	}

}
