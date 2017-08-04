package com.dockerapp.dockerapp.converters;

import com.dockerapp.dockerapp.commands.ProductCommand;
import com.dockerapp.dockerapp.domain.Product;
import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class ProductToProductCommand implements Converter<Product, ProductCommand>{

    @Synchronized
    @Nullable
    @Override
    public ProductCommand convert(Product source) {
        if (source == null) {
            return null;
        }

        final ProductCommand productCommand = new ProductCommand();

        productCommand.setId(source.getId());
        productCommand.setName(source.getName());
        productCommand.setPrice(source.getPrice());
        productCommand.setUrl(source.getUrl());

        return productCommand;
    }
}
