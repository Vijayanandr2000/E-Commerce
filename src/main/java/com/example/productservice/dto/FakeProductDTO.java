package com.example.productservice.dto;

import com.example.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeProductDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
