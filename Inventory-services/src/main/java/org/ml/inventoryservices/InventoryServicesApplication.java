package org.ml.inventoryservices;

import org.ml.inventoryservices.Entities.Product;
import org.ml.inventoryservices.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServicesApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){


        return args -> {

            //Va nous permettre d'afficher aussi les id l'or de l'affichage
            repositoryRestConfiguration.exposeIdsFor(Product.class);

            productRepository.saveAll(
                    List.of(
                            Product.builder().name("Computer").quantity(12).price(1200).build(),
                            Product.builder().name("Phone").quantity(32).price(2992).build(),
                            Product.builder().name("TV").quantity(2).price(2652).build()
                    )
            );
        };
    }
}
