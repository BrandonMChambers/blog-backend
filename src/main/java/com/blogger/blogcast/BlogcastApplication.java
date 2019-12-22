package com.blogger.blogcast;

import com.blogger.blogcast.model.User;
import com.blogger.blogcast.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogcastApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserRepository userRepository){
		return args -> {
			userRepository.save(new User("Brandon"));
		};
	}

}
