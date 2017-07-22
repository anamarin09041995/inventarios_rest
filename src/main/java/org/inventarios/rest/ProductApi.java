/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inventarios.rest;

import java.util.List;
import org.inventarios.models.PostResponse;
import org.inventarios.models.Product;
import org.inventarios.models.SimpleResponse;
import org.inventarios.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anita
 */
@RestController
public class ProductApi {

    private ProductServiceImp productServiceImp;
    
    @Autowired
    public ProductApi(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }
    
    @RequestMapping(path = "/products/{id}"
            , method = RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Product product = productServiceImp.getById(id);
        if(product == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);        
        return new ResponseEntity(product, HttpStatus.OK);
    }
    
    @RequestMapping(
            path = "/products"
            , method= RequestMethod.GET
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Product>> all(){
        List<Product> products = productServiceImp.all();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    
    @RequestMapping(
            path = "/products"
            , method = RequestMethod.PUT
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SimpleResponse> update(@RequestBody Product product){
        boolean success =  productServiceImp.update(product);
        return new ResponseEntity(new SimpleResponse(success), HttpStatus.OK);
    }

    @RequestMapping(path = "/products/{id}"
            , method = RequestMethod.DELETE
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SimpleResponse> delete(@PathVariable Long id){
        boolean success =  productServiceImp.delete(id);
        return new ResponseEntity(new SimpleResponse(success), HttpStatus.OK);
    }
    
    @RequestMapping(
            path="/products"
            , method= RequestMethod.POST
            , produces = MediaType.APPLICATION_JSON_VALUE
    )
    
    public ResponseEntity<PostResponse> insert(@RequestBody Product product){
        productServiceImp.insert(product);
        return new ResponseEntity(new PostResponse(true, product.getId()), HttpStatus.OK);
    }
}
