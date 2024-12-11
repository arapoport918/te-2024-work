package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao dao) {
        this.productDao = dao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> list(@RequestParam(value = "sku", defaultValue = "") String sku,
                              @RequestParam(value = "name", defaultValue = "") String name) {
        try  {
            if (!sku.isEmpty() && !name.isEmpty()) {
                return productDao.searchProductBySkuAndName(sku, name);
            } else if (!sku.isEmpty()) {
                return productDao.searchProductBySku(sku);
            } else if (!name.isEmpty()) {
                return productDao.searchProductByName(name);
            } else {
                return productDao.getProducts();
            }
        } catch (RestClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product name(@PathVariable int id) {
        try {
            return productDao.getProductById(id);
        } catch (RestClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
