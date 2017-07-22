/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventarios.services;

import java.util.ArrayList;
import java.util.List;
import org.inventarios.models.Product;
import org.springframework.stereotype.Service;

/**
 *
 * @author anita
 */
@Service
public class ProductServiceImp implements ProductService{
    
    private static List<Product> data =  new ArrayList<>();

    @Override
    public void insert(Product product) {
        product.setId(System.currentTimeMillis());
        data.add(product);
    }

    @Override
    public boolean update(Product product) {
        boolean success = false;
        int index = 0;
        
        for(Product p : data){            
            if(p.getId().equals(product.getId())){
                data.set(index, product);
                success = true;
                break;
            }
            index++;
        }        
        return success;        
    }

    @Override
    public boolean delete(Long id) {
        boolean success = false;
        int index = 0;
        
        for(Product p : data){            
            if(p.getId().equals(id)){
                data.remove(index);
                success = true;
                break;
            }
            index++;
        }        
        return success;        
    }

    @Override
    public Product getById(Long id) {
        Product product = null;
        int index = 0;
        
        for(Product p : data){            
            if(p.getId().equals(id)){
                product = p;                
                break;
            }
            index++;
        }        
        return product;        
    }

    @Override
    public List<Product> all() {
        return data;
    }

    
}
