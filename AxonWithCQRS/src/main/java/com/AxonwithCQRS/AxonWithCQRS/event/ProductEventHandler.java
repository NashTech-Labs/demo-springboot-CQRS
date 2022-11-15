package com.AxonwithCQRS.AxonWithCQRS.event;

import com.AxonwithCQRS.AxonWithCQRS.entity.ProductEntity;
import com.AxonwithCQRS.AxonWithCQRS.repositery.ProductRepositery;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {


    private ProductRepositery repositery;

    public ProductEventHandler(ProductRepositery repositery) {
        this.repositery = repositery;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent,entity);
        repositery.save(entity);

    }
}
