package com.database.MultipleDatabaseConfig;

import com.database.MultipleDatabaseConfig.mysql.entity.User;
import com.database.MultipleDatabaseConfig.mysql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabaseConfigApplication implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User admin = User.builder()
				.email("rahul@gmail.com")
				.username("rahul")
				.password("rahul")
				.build();

		User save = userRepo.save(admin);
		System.out.println("User saved with username :"+admin.getUsername());
	}
}
