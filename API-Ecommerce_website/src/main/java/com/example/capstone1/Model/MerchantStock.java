package com.example.capstone1.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "can not be null ")
    private Integer id;
    @NotNull(message = "can not be null ")
    private Integer productId;
    @NotNull(message = "can not be null ")
    private Integer merchantId;
    @NotNull(message = "can not be null ")
    @Min(value = 11,message = "should it less 11")
    private Integer stock;


}
