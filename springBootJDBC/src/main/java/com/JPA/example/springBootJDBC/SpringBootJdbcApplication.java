package com.JPA.example.springBootJDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Student.class);

    @Autowired
    StudentJDBCRepository jdbcRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("student id for 1234568 -> {}", jdbcRepository.findById(10002L));

		logger.info("Inserting -> {}", jdbcRepository.insert(new Student(10010L, "John", "A1234657")));

		logger.info("Update 10001 -> {}", jdbcRepository.update(new Student(10001L, "Name-Updated", "New-Passport")));

		jdbcRepository.deleteById(10002L);

		logger.info("All users 2 -> {}", jdbcRepository.findAll());
    }
}
