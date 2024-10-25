package com.e_commerce.taller_2.domain.factory_method.Implementatios;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.e_commerce.taller_2.domain.factory_method.IProductDAO;
import com.e_commerce.taller_2.domain.models.Product;

public class ProductDAOOracleImpl implements IProductDAO {
    private Map<String, Product> products = new HashMap<>();

    public ProductDAOOracleImpl() {
        products.put("1", new Product("1", "Producto Oracle 1", 20.0));
        products.put("2", new Product("2", "Producto Oracle 2", 25.0));
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> findAll() {
        return products.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void delete(String id) {
        products.remove(id);
    }
}
