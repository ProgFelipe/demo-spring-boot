package com.dockerapp.dockerapp.bootstrap;

import com.dockerapp.dockerapp.domain.Product;
import com.dockerapp.dockerapp.domain.Store;
import com.dockerapp.dockerapp.repositories.StoreRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StoreBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final StoreRepository storeRepository;

    public StoreBootstrap(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        storeRepository.save(getAllStores());
    }

    public Set<Store> getAllStores(){
        Product product = new Product();
        product.setName("Tennis Nike");
        product.setPrice(2.0);
        product.setUrl("http://www.holabirdsports.com/blog/wp-content/uploads/2015/04/TennisMagazineShoes_11_Nike.jpg");

        Set<Product> products = new HashSet<>();
        products.add(product);
        products.add(product);
        products.add(product);

        Store storeOne = new Store();
        storeOne.setName("Cadena");
        storeOne.setProducts(products);

        Set<Store> stores = new HashSet<>();
        stores.add(storeOne);

        storeRepository.save(stores);
        return stores;
    }
}
