package com.dockerapp.dockerapp.repositories;

import com.dockerapp.dockerapp.domain.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StoreRepository  extends CrudRepository<Store, Long>{
    Optional<Store> findById(Long id);
}
