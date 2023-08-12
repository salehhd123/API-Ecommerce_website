package com.example.capstone1.Service;

import com.example.capstone1.Model.Merchant;
import com.example.capstone1.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;


@Service
public class MerchantStockService {

ArrayList<MerchantStock> merchantStocks = new ArrayList<>();


public ArrayList<MerchantStock> get(){
        return merchantStocks;
}

public void add(MerchantStock merchantStock){
    merchantStocks.add(merchantStock);
}

public boolean update(Integer id,MerchantStock merchantStock){
    for (int i=0;i<merchantStocks.size();i++){
        if (merchantStocks.get(i).getId()==id){
            merchantStocks.set(i,merchantStock);
            return true;
        }
    }
    return false;
}

public boolean delete(Integer id){
    for (int i=0;i<merchantStocks.size();i++){
        if (merchantStocks.get(i).getId()==id){
            merchantStocks.remove(i);
            return true;
        }
    }
    return false;
}

public boolean more(Integer productId, Integer merchaintId, Integer amount){
    for (int i=0;i<merchantStocks.size();i++){
        if (merchantStocks.get(i).getProductId()==productId&&merchantStocks.get(i).getMerchantId()==merchaintId){
           Integer n = merchantStocks.get(i).getStock()+amount;
           merchantStocks.get(i).setStock(n);
            return true;
        }
    }return false;
}

public boolean hasStock(Integer id){
    for (int i=0;i<merchantStocks.size();i++){
    if(merchantStocks.get(i).getProductId()==id){
        if (merchantStocks.get(i).getStock()>0){
            return true;
        }
    }
    }return false;
}

public void reduceStock(Integer id){
    for (int i=0;i<merchantStocks.size();i++){
        if(merchantStocks.get(i).getProductId()==id){
            merchantStocks.get(i).setStock(merchantStocks.get(i).getStock()-1);
        }
    }
}


}
