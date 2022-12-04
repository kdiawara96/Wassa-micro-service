package org.ml.customerservice.Repository;

import org.ml.customerservice.Entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Customer.class}, name = "fullCustomer")
public interface CustomerProjection {

    public Long getId();
    public String getName();

}
