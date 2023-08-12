package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotNull(message = "can not be null ")
    private Integer id;

    @NotEmpty(message = "can not be null ")
    @Size(min = 4,message = "can not be less then 4")
    private String name;
}
