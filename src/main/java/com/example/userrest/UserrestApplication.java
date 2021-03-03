package com.example.userrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootApplication
public class UserrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserrestApplication.class, args);
	}

}

class User {
	private final String id;
	private String name;
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public User(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}
        public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

}

@RestController
@RequestMapping("/users")
class RestApiDemoController {
	private List<User> users = new ArrayList<>();

	public RestApiDemoController() {
		users.addAll(List.of(
			new User("Garry Glitter"),
			new User("Piers Morgan")
		));
	}
	@GetMapping
	Iterable<User> getUsers() {
		return coffees;
	}

	@GetMapping("/{id}")
	Optional<User> getUserById(@PathVariable String id) {
		for (User c: users) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

}

}
