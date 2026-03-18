package com.klu.workbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.workbook.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    List<Product> findByName(String name);

    List<Product> findByPrice(double price);
}