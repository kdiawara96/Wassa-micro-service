package org.ml.customerservice.Repository;

import org.ml.customerservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
/* utiliser un web service nous pouvons utliser deux
Un rest controller ou nous utilisons spring data rest tu dois utiliser le RepositoryRestRessource*/

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
