package com.AxonwithCQRS.AxonWithCQRS.controller;

import com.AxonwithCQRS.AxonWithCQRS.command.CreateProductCommand;
import com.AxonwithCQRS.AxonWithCQRS.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {


    private CommandGateway commandGateway;

    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductModel productModel){
        CreateProductCommand command = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .build();
        return commandGateway.sendAndWait(command);
    }
}
