package com.mindtree;

import com.mindtree.dto.Book;
import com.mindtree.dto.Product;
import com.mindtree.dto.User;
import com.mindtree.repository.UserRepository;
import com.mindtree.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ShoppingCartServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServicesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@mindtree.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product("Product","TV Set", 300.00f));
			productService.save(new Product("Product", "Game Console", 200.00f));
			productService.save(new Product("Product", "Sofa", 100.00f));
			productService.save(new Product("Product","Icecream", 5.00f));
			productService.save(new Product("Product","Beer", 3.00f));
			productService.save(new Product("Product","Phone", 500.00f));
			productService.save(new Product("Product","Watch", 30.00f));
			productService.save(new Book("Book","Something", 5.00f, "test", "test", "test"));
		};
	}
}
