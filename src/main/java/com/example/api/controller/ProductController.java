package com.example.api.controller;

import com.example.api.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @param sku_id
     * @return Product Object
     * @throws IOException
     *
     * GET Request to search Solr instance via sku_id
     */
    @GetMapping("/product")
    public Product getProduct(@RequestParam Integer sku_id) throws IOException {
        return productService.getProduct(sku_id);
    }

    /**
     *
     * @param columnName
     * @param searchValue
     * @return List of Products
     * @throws IOException
     *
     * GET Request to search Solr instance via any columnName and keyword.
     * Will return empty list, if no matches are found.
     */
    @GetMapping("/select")
    public List<Product> select(@RequestParam String columnName, @RequestParam String searchValue) throws IOException {
        return productService.selectQuery(columnName, searchValue);
    }

}
