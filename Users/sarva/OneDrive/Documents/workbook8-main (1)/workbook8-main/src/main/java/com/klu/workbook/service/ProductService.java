package com.klu.workbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.workbook.model.Product;
import com.klu.workbook.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getProducts()
    {
        return repo.findAll();
    }

    public List<Product> searchByName(String name)
    {
        return repo.findByName(name);
    }

    public List<Product> searchByPrice(double price)
    {
        return repo.findByPrice(price);
    }
}