package com.e_commerce.taller_2.domain.factory_method.Implementatios;
import java.util.ArrayList;
import java.util.List;

import com.e_commerce.taller_2.domain.factory_method.IProductDAO;
import com.e_commerce.taller_2.domain.models.Product;

public class ProductDAOMySQLImpl implements IProductDAO {
    private List<Product> products = new ArrayList<>();

    // Constructor que inicializa algunos productos
    public ProductDAOMySQLImpl() {
        products.add(new Product("1", "Producto MySQL 1", 10.0));
        products.add(new Product("2", "Producto MySQL 2", 15.0));
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void update(Product product) {
        delete(product.getId());
        save(product);
    }

    @Override
    public void delete(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
