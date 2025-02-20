package org.example.billingservice;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.example.billingservice.feign.CustomerRestClient;
import org.example.billingservice.feign.ProductRestClient;
import org.example.billingservice.model.Customer;
import org.example.billingservice.model.Product;
import org.example.billingservice.repository.BillRepository;
import org.example.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        System.out.println("Bill Repository: ");
        return args -> {
            Collection<Customer> customers = customerRestClient.findAllCustomers().getContent();
            Collection<Product> products = productRestClient.findAllProducts().getContent();

            customers.forEach(customer -> {
                Bill bill = new Bill();
                bill.setBillDate(new Date());
                bill.setCustomerId(customer.getId());
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setBill(bill);
                    productItem.setProductId(product.getId());
                    productItem.setQuantity(1 + new Random().nextInt(10));
                    productItem.setUnitPrice(product.getPrice());
                    productItemRepository.save(productItem);
                });
            });
        };

    }

}
