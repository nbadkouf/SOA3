package com.esipe.ms.repository;

import com.esipe.ms.domain.Basket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class BasketRepository {
    private Map<String, Basket> baskets = new HashMap<>();

    public void save(Basket basket){

        baskets.put(basket.getUser(), basket);
    }

    public void update(Basket basket){

        if(!ifExiste(basket.getUser())){
            throw new RuntimeException("basket not found");
        }

        baskets.put(basket.getUser(), basket);
    }

    public Basket getOne(String user){

        return baskets.get(user);
    }

    public void delete(String user){

        if(!ifExiste(user)){
            throw new RuntimeException("basket not found");
        }

        baskets.remove(user);
    }

    private boolean ifExiste(String user){
        return baskets.containsKey(user);
    }

    public List<Basket> getAll() {
        return new ArrayList<Basket>(baskets.values());
    }
}
