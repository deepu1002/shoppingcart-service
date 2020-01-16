package com.mindtree;

import com.mindtree.dto.Apparal;
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
			Stream.of("john", "julie", "jennifer", "helen", "rachel", "test").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@mindtree.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Book("Book","Harry Potter Series", 1500.00f, "Fantasy", "J. K. Rowling", "General"));
			productService.save(new Book("Book","Benjamin Franklin", 2000.00f, "Biography", "Benjamin Franklin", "General"));
			productService.save(new Book("Book","The Hobbit", 3999.99f, "Action and Adventure", "J.R.R. Tolkien", "General"));
			productService.save(new Book("Book","The Poets", 2800.00f, "Anthology", "Elizabeth Hun Schmidt", "General"));
			productService.save(new Book("Book","Romeo and Juliet", 5000.00f, "Classic", "William Shakespeare", "General"));
			productService.save(new Book("Book","Saga", 22000.00f, "Comic", "Brian K Vaughan", "General"));
			productService.save(new Book("Book","Sherlock Holmes", 4300.00f, "Crime and Detective", "Conan Doyle", "General"));
			productService.save(new Book("Book","Waiting For Godot", 1000.00f, "Drama", "Samuel Beckett", "General"));
			productService.save(new Apparal("Apparal","Shirt", 1500.00f, "Polyester", "Polo", "Regular"));
			productService.save(new Apparal("Apparal","Jeans", 1999.99f, "Cotton", "Flying Machine", "Slim"));
			productService.save(new Apparal("Apparal","Shoe", 3200.99f, "Sports", "Nike", "Leather"));
			productService.save(new Apparal("Apparal","Belt", 2499.99f, "Leather", "Puma", "Round"));
		};
	}
}
