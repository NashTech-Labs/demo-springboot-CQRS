package com.AxonwithCQRS.AxonWithCQRS.aggregate;

import com.AxonwithCQRS.AxonWithCQRS.command.CreateProductCommand;
import com.AxonwithCQRS.AxonWithCQRS.event.ProductCreatedEvent;
import lombok.Builder;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,event);
        AggregateLifecycle.apply(event);
    }

    public ProductAggregate() {
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent createdEvent){
        this.id = createdEvent.getId();
        this.name = createdEvent.getName();
        this.price = createdEvent.getPrice();
        this.quantity = createdEvent.getQuantity();

    }
}
