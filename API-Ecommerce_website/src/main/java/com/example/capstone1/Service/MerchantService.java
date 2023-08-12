package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> merchants=new ArrayList<>();


    public ArrayList<Merchant> get(){
        return merchants;
    }

    public void  add(Merchant merchant){
        merchants.add(merchant);
    }

    public boolean update(Integer id,Merchant merchant){
        for (int i =0;i<merchants.size();i++){
            if (merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }

        }
        return false;
    }

    public boolean delete(Integer id){
        for (int i =0;i<merchants.size();i++){
            if (merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean checkId(Integer id){
        for (int i=0;i< merchants.size();i++){
            if (merchants.get(i).getId()==id){
                return true;
            }
        }return false;
    }
}
