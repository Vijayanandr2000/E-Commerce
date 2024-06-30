package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;

}
