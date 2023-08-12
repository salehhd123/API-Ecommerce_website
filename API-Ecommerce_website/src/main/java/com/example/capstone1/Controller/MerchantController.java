package com.example.capstone1.Controller;

import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import com.example.capstone1.Service.MerchantService;
import com.example.capstone1.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    private final MerchantService merchantService;
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(merchantService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.add(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Merchant merchant,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(merchantService.update(id,merchant)){
            ResponseEntity.status(200).body(new ApiResponse("updated"));
        }return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity update(@PathVariable Integer id){

        if(merchantService.delete(id)){
            ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/more/{productId}/{merchaintId}/{amount}")
    public ResponseEntity more(@PathVariable Integer productId,@PathVariable Integer merchaintId,@PathVariable Integer amount){
        if (merchantStockService.more(productId,merchaintId,amount)){
            return ResponseEntity.status(200).body(new ApiResponse("new amount added"));}
        return ResponseEntity.status(400).body(new ApiResponse("invalid input check id's"));
    }
}
