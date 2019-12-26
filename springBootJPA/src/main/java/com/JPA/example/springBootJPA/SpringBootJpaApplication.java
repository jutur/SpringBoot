package com.JPA.example.springBootJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJpaApplication {
/*
* @Configuration: Tags the class as a source of bean definitions for the application context.
ApplicationContext (or condition) provides configuration information to an application
* ApplicationContext provides standard bean life cycle capabilities
@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.*/
private static final Logger log = LoggerFactory.getLogger(SpringBootJpaApplication.class);
public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}


	/*
	* The AccessingDataJpaApplication class includes a main() method that puts the CustomerRepository through a few tests. First, it fetches the CustomerRepository from the Spring application context. Then it saves a handful of Customer objects, demonstrating the save() method and setting up some data to use. Next, it calls findAll() to fetch all Customer objects from the database. Then it calls findOne() to fetch a single Customer by its ID. Finally, it calls findByLastName() to find all customers whose last name is "Bauer".

By default, Spring Boot enables JPA repository support and looks in the package (and its subpackages) where @SpringBootApplication is located. If your configuration has JPA repository interface definitions located in a package that is not visible, you can point out alternate packages by using @EnableJpaRepositories and its type-safe basePackageClasses=MyRepository.class parameter.
	*
	*
	*
	*
	*
	* */

@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
	// implements run method
         return (args) -> {
         	// save few customers
             repository.save(new Customer("firstName1", "lastName1"));
			 repository.save(new Customer("firstName2", "lastName2"));
			 repository.save(new Customer("firstName3", "lastName3"));
			 repository.save(new Customer("firstName4", "lastName4"));
			 repository.save(new Customer("firstName5", "lastName5"));

		   // fetch few customers
           log.info("Customers found with findAll");
           log.info("---------------------------------");
           for (Customer cus: repository.findAll()) {
           	log.info(cus.toString());
		   }
           log.info("---------------------------------");


           // fetch an individual customer by Id
		   Customer cus = repository.findById(1);
            log.info("customer By Id ");
            log.info(cus.toString());

            log.info("Customer found by lastName");

            repository.findByLastName("lastName3").forEach(x -> log.info(x.toString()));


		 };
	}

}
