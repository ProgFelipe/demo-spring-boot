package com.dockerapp.dockerapp.bootstrap;

import com.dockerapp.dockerapp.domain.Product;
import com.dockerapp.dockerapp.domain.Store;
import com.dockerapp.dockerapp.repositories.ProductRepository;
import com.dockerapp.dockerapp.repositories.StoreRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StoreBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public StoreBootstrap(StoreRepository storeRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        storeRepository.save(getAllStores());
    }

    public Set<Store> getAllStores(){
        Product product = new Product();
        product.setName("Nike Shoe");
        product.setPrice(50.0);
        product.setUrl("http://www.holabirdsports.com/blog/wp-content/uploads/2015/04/TennisMagazineShoes_11_Nike.jpg");

        Product product2 = new Product();
        product2.setName("Addidas Shoe");
        product2.setPrice(24.0);
        product2.setUrl("http://www.holabirdsports.com/blog/wp-content/uploads/2015/04/TennisMagazineShoes_11_Nike.jpg");

        Product product3 = new Product();
        product3.setName("Addidas Shoe");
        product3.setPrice(37.0);
        product3.setUrl("http://www.holabirdsports.com/blog/wp-content/uploads/2015/04/TennisMagazineShoes_11_Nike.jpg");

        Set<Product> products = new HashSet<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        Store storeOne = new Store();
        storeOne.setName("Target");
        storeOne.setProducts(products);


        Store storeTwo = new Store();
        storeTwo.setName("Wallmart");
        storeTwo.setProducts(products);

        Set<Store> stores = new HashSet<>();
        stores.add(storeOne);
        stores.add(storeTwo);

        storeRepository.save(stores);
        return stores;
    }
}
