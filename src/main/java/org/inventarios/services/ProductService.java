/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventarios.services;

import java.util.List;
import org.inventarios.models.Product;

/**
 *
 * @author anita
 */
public interface ProductService {
    void insert(Product product);
    boolean update(Product product);
    boolean delete(Long id);
    Product getById(Long id);
    List<Product> all();
}
