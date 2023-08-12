package com.example.capstone1.Controller;

import com.example.capstone1.ApiResponse.ApiResponse;
import com.example.capstone1.Model.Category;
import com.example.capstone1.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(categoryService.get());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.add(category);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Category category,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        if (categoryService.update(id, category)){
            return ResponseEntity.status(200).body(new ApiResponse("updated"));
        }return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("not found "));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if (categoryService.delete(id)){
            return ResponseEntity.status(200).body(new ApiResponse("deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }



}
