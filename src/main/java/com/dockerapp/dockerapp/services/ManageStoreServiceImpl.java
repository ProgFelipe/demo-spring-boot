package com.dockerapp.dockerapp.services;

import com.dockerapp.dockerapp.commands.ProductCommand;
import com.dockerapp.dockerapp.commands.StoreCommand;
import com.dockerapp.dockerapp.converters.ProductToProductCommand;
import com.dockerapp.dockerapp.converters.StoreToStoreCommand;
import com.dockerapp.dockerapp.repositories.ProductRepository;
import com.dockerapp.dockerapp.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import java.util.Set;

@Service
public class ManageStoreServiceImpl  implements StoreService{

    private StoreRepository storeRepository;
    private ProductRepository productRepository;

    public ManageStoreServiceImpl(StoreRepository storeRepository, ProductRepository productRepository, ProductToProductCommand productToProductCommand, StoreToStoreCommand storeToStoreCommand) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
        this.productToProductCommand = productToProductCommand;
        this.storeToStoreCommand = storeToStoreCommand;
    }

    private ProductToProductCommand productToProductCommand;
    private StoreToStoreCommand storeToStoreCommand;



    @Override
    public Set<ProductCommand> getProductsOfStore(Long id) {
        return StreamSupport.stream(storeRepository.findById(id).get().getProducts()
                .spliterator(), false)
                .map(productToProductCommand::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<StoreCommand> getAllStores() {
        return StreamSupport.stream(storeRepository.findAll()
                .spliterator(), false)
                .map(storeToStoreCommand::convert)
                .collect(Collectors.toSet());
    }
}
