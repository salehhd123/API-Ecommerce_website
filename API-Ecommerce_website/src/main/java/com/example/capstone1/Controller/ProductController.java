package com.example.capstone1.Controller;

import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.Product;
import com.example.capstone1.Service.MerchantService;
import com.example.capstone1.Service.MerchantStockService;
import com.example.capstone1.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;



    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }productService.addProducts(product);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id,@RequestBody @Valid Product product,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(productService.updateProducts(id,product)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }else return ResponseEntity.status(400).body(new ApiResponse("not found by the id !"));

    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity delete(@PathVariable int index){
        if (productService.delete(index)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }else return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }






}
