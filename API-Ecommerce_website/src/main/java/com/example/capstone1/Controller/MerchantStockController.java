package com.example.capstone1.Controller;


import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Service.MerchantStockService;
import com.example.capstone1.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchantstock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(merchantStockService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.add(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(merchantStockService.update(id,merchantStock)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(merchantStockService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not found"));
    }

    @GetMapping("/more/{productId}/{merchaintId}/{amount}")
    public ResponseEntity more(@PathVariable Integer productId,@PathVariable Integer merchaintId,@PathVariable Integer amount){
       return ResponseEntity.status(200).body(merchantStockService.more(productId, merchaintId, amount));
    }











}
