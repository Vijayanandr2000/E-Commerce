package com.example.productservice.productcontroller;

import com.example.productservice.exceptions.ProductNotFound;
import com.example.productservice.interfaceservice.ProductService;
import com.example.productservice.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFound {
           ResponseEntity<Product> response = new ResponseEntity<>(
                   productService.getProductById(id),
                   HttpStatus.OK
           );

           return response;
    }

    @GetMapping()
    List<Product> getProducts(){
        return  productService.getProducts();
    }

    @PutMapping("/{id}")
    Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return  productService.updateProduct(id, product);
    }
}
