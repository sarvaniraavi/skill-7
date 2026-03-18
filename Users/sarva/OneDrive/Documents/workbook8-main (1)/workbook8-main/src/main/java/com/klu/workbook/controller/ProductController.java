package com.klu.workbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.workbook.model.Product;
import com.klu.workbook.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/view")
    public List<Product> getProducts()
    {
        return service.getProducts();
    }

    @GetMapping("/name/{name}")
    public List<Product> searchByName(@PathVariable String name)
    {
        return service.searchByName(name);
    }

    @GetMapping("/price/{price}")
    public List<Product> searchByPrice(@PathVariable double price)
    {
        return service.searchByPrice(price);
    }
}