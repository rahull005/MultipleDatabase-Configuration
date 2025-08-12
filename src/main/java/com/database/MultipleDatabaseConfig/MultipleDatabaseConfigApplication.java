package com.database.MultipleDatabaseConfig;

import com.database.MultipleDatabaseConfig.mysql.entity.User;
import com.database.MultipleDatabaseConfig.mysql.repository.UserRepo;
import com.database.MultipleDatabaseConfig.oracle.entity.College;
import com.database.MultipleDatabaseConfig.oracle.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabaseConfigApplication implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;

	@Autowired
	CollegeRepo collegeRepo;

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

		User usersave = userRepo.save(admin);
		System.out.println("User saved with username :"+admin.getUsername());


	//College
		College college = College.builder()
				.collegeName("MLRIT")
				.city("Hyderabad")
				.build();
		College collegesave = collegeRepo.save(college);
		System.out.println("The college is :"+collegesave.getCollegeName());
	}
}
