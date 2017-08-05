package com.dockerapp.dockerapp.converters;

import com.dockerapp.dockerapp.commands.StoreCommand;
import com.dockerapp.dockerapp.domain.Store;
import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class StoreToStoreCommand implements Converter<Store, StoreCommand> {

    public StoreToStoreCommand(ProductToProductCommand productToProductCommand) {
        this.productToProductCommand = productToProductCommand;
    }

    private ProductToProductCommand productToProductCommand;

    @Synchronized
    @Nullable
    @Override
    public StoreCommand convert(Store store) {
        if(store == null){
            return null;
        }

        final StoreCommand storeCommand = new StoreCommand();

        storeCommand.setProducts(StreamSupport.stream(store.getProducts()
                .spliterator(), false)
                .map(productToProductCommand::convert)
                .collect(Collectors.toSet()));
        storeCommand.setName(store.getName());
        storeCommand.setId(store.getId());

        return storeCommand;
    }
}
