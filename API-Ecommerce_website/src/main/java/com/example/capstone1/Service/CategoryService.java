package com.example.capstone1.Service;

import com.example.capstone1.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CategoryService {


    ArrayList<Category> categories = new ArrayList<>();


    public ArrayList<Category> get(){
        return categories;
    }

    public void add(Category category){
        categories.add(category);
    }

    public boolean update(Integer id, Category category){
        for (int i=0;i<categories.size();i++){
            if (categories.get(i).getId()==id){
                categories.set(i,category);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Integer id){
        for (int i=0;i<categories.size();i++){
            if (categories.get(i).getId()==id){
                categories.remove(i);
                return true;
            }
        }
        return false;
    }


}
