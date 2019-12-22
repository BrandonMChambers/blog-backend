package com.blogger.blogcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogcastApplication.class, args);
	}
/*
	@Bean
	ApplicationRunner applicationRunner(UserRepository userRepository){
		return args -> {
			userRepository.save(new User("Brandon"));
		};
	}

 */

}
