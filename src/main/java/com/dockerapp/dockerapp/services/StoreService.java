package com.dockerapp.dockerapp.services;

import com.dockerapp.dockerapp.commands.ProductCommand;
import com.dockerapp.dockerapp.commands.StoreCommand;

import java.util.Set;

public interface StoreService {

    Set<ProductCommand> getProductsOfStore(Long id);

    Set<StoreCommand> getAllStores();
}
