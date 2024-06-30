package com.example.productservice.productcontroller;

import com.example.productservice.interfaceservice.ProductService;
import com.example.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") Long id){
       return productService.getProductById(id);
    }

    @GetMapping()
    List<Product> getProducts(){
        return  productService.getProducts();
    }


}
