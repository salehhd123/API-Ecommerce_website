package com.example.capstone1.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    @NotNull(message = "can not be null ")
    private Integer id;

    @Size(min = 4,message = "can not be less then 4")
    private String name;

    @NotNull(message = "can not be null ")
    @Positive(message = "must be greater than 0")
    private Integer price;

    @NotNull(message = "can not be null ")
    private Integer categoryID;

}
