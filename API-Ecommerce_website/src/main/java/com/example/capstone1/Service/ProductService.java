package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import com.example.capstone1.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product){
        products.add(product);
    }

    public Boolean updateProducts(Integer id ,Product product){
        for(int i=0; i<products.size();i++){
           if(products.get(i).getId()==id){
               products.set(i,product);
               return true;
           }
        }
        return false;
    }

    public Boolean delete(int index){
        if(index<0 || index> products.size()-1){
            return false;
        }else {
            products.remove(index);
            return true;
        }
    }
    public boolean checkId(Integer id){
        for (int i=0;i< products.size();i++){
            if (products.get(i).getId()==id){
                return true;
            }
        }return false;
    }

    public Integer price(Integer id){
        Integer price=0;
        for (int i=0;i< products.size();i++){
            if (products.get(i).getId()==id){
               price = products.get(i).getPrice();
               return price;
            }
        }return null;
    }





}
