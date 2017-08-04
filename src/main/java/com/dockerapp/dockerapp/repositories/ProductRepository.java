package com.dockerapp.dockerapp.repositories;

import com.dockerapp.dockerapp.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
