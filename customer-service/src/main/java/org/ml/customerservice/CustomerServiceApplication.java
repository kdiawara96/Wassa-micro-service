package org.ml.customerservice;

import org.ml.customerservice.Entities.Customer;
import org.ml.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
						   RepositoryRestConfiguration repositoryRestConfiguration){
		return args -> {
			// AVec spring data rest il n'expose pas les id du coup avec cette commande ils va nous afficher
			repositoryRestConfiguration.exposeIdsFor(Customer.class);
			
			customerRepository.saveAll(
					List.of(
							Customer.builder().name("Diawara").email("kaimdiawara96@gmail.com").build(),
							Customer.builder().name("Mariko").email("kaimdiawara996@gmail.com").build(),
							Customer.builder().name("Dembele").email("kaimdiawara1996@gmail.com").build()
							)
			);
			customerRepository.findAll().forEach(c->{
				System.err.println(c);
			});
		};
	}
}
