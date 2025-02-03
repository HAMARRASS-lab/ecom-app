package org.example.cusomerservice;

import org.example.cusomerservice.entities.Customer;
import org.example.cusomerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setEmail("john@example.com");
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setFirstName("test");
            customer2.setEmail("john@examplsse.com");
            customerRepository.save(customer2);

            customerRepository.findAll().forEach(c -> {
                System.out.println("---------------");
                System.out.println(c.getId());
                System.out.println(c.getFirstName());
                System.out.println(c.getEmail());
            });
        };
    }
}