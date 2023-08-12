package com.example.capstone1.Controller;

import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.User;
import com.example.capstone1.Service.MerchantService;
import com.example.capstone1.Service.MerchantStockService;
import com.example.capstone1.Service.ProductService;
import com.example.capstone1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

private final UserService userService;
private final ProductService productService;
private final MerchantService merchantService;
private final MerchantStockService merchantStockService;


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.add(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(userService.update(id,user)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }else return ResponseEntity.status(400).body(new ApiResponse("not found by the id !"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(userService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }else return ResponseEntity.status(400).body(new ApiResponse("not found by the id !"));
    }

    @GetMapping("/buy/{uid}/{pid}/{mid}")
    public ResponseEntity buy(@PathVariable Integer uid,@PathVariable Integer pid,@PathVariable Integer mid){
        if (userService.checkId(uid)&&productService.checkId(pid)&&merchantService.checkId(mid)){
            if (merchantStockService.hasStock(pid)){
                if (userService.balance(uid)>=productService.price(pid)){
                    merchantStockService.reduceStock(pid);
                    userService.deducted(uid,productService.price(pid));
                    return ResponseEntity.status(200).body(new ApiResponse("the Purchase completed"));
                }return ResponseEntity.status(400).body(new ApiResponse("you do not have enough money "));
            }return ResponseEntity.status(400).body(new ApiResponse("no stock"));
        }return ResponseEntity.status(400).body(new ApiResponse("not valid"));
    }



}
