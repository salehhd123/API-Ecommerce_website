package com.example.capstone1.Service;

import com.example.capstone1.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getUsers() {
        return users;
    }

    public void add(User user){
        users.add(user);
    }

    public boolean update(Integer id,User user){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }


    public boolean delete(Integer id){
        for(int i=0; i<users.size();i++){
            if(users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkId(Integer id){
        for (int i=0;i< users.size();i++){
            if (users.get(i).getId()==id){
                return true;
            }
        }return false;
    }

    public Integer balance(Integer id){
        Integer Balance=0;
        for (int i=0;i< users.size();i++){
            if (users.get(i).getId()==id){
                Balance = users.get(i).getBalance();
                return Balance;
            }
        }return null;
    }
    public Integer deducted(Integer id,Integer price){
        for (int i=0;i< users.size();i++){
            if (users.get(i).getId()==id){
                users.get(i).setBalance(users.get(i).getBalance()-price);
            }
        }return null;
    }

}
