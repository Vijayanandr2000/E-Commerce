package com.example.productservice.productservice;

import com.example.productservice.dto.FakeProductDTO;
import com.example.productservice.interfaceservice.ProductService;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeProductService implements ProductService {
    private RestTemplate restTemplete;

    FakeProductService(RestTemplate restTemplete){
        this.restTemplete = restTemplete;
    }
    @Override
    public Product getProductById(long id) {
        FakeProductDTO fakeProductDTO = restTemplete.getForObject(
            "https://fakestoreapi.com/products/" + id,
            FakeProductDTO.class
        );

        return convertFakeProductToProduct(fakeProductDTO);
    }

    @Override
    public List<Product> getProducts() {
        FakeProductDTO[] fakeProductDTOs = restTemplete.getForObject(
                "https://fakestoreapi.com/products/",
                FakeProductDTO[].class
        );
        List<Product> products = new ArrayList<>();
        for(FakeProductDTO fakeProductDTO : fakeProductDTOs){
            products.add(convertFakeProductToProduct(fakeProductDTO));
        }

        return products;
    }

    public Product convertFakeProductToProduct(FakeProductDTO fakeProductDTO){
        Product product = new Product();
        product.setTitle(fakeProductDTO.getTitle());
        product.setPrice(fakeProductDTO.getPrice());

        Category category = new Category();
        category.setName(fakeProductDTO.getCategory());
        category.setDescription(fakeProductDTO.getDescription());
        product.setCategory(category);

        return product;
    }
}
