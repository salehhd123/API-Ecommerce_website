package com.example.capstone1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotNull(message = "can not be null ")
    private Integer id;

    @NotEmpty(message = "not empty")
    @Size(min = 6,message = "can not be less then 6")
    private String name;

    @NotEmpty(message = "not empty")
    @Pattern(regexp = "^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[a-zA-Z]).{8,}$")
    private String password;


    @NotEmpty(message = "not empty")
    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "(admin|customer)",message ="must be admin or customer")
    private String role;

    @NotNull(message = "can not be null")
    @Positive(message = "must be positive")
    private Integer balance;
}
