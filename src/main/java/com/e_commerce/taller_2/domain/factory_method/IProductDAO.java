package com.e_commerce.taller_2.domain.factory_method;
import java.util.List;

import com.e_commerce.taller_2.domain.models.Product;

public interface IProductDAO {
    void save(Product product);
    Product findById(String id);
    List<Product> findAll();
    void update(Product product);
    void delete(String id);
}
