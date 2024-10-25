package com.e_commerce.taller_2.controller;

import org.springframework.web.bind.annotation.*;

import com.e_commerce.taller_2.domain.DAOFactory;
import com.e_commerce.taller_2.domain.factory_method.IProductDAO;
import com.e_commerce.taller_2.domain.models.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductDAO productDAO;

    public ProductController() {
        this.productDAO = DAOFactory.getProductDAO();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productDAO.save(product);
    }

    @GetMapping("/search/{id}")
    public Product getProduct(@PathVariable String id) {
        return productDAO.findById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        productDAO.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id) {
        productDAO.delete(id);
    }
}
