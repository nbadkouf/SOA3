package com.esipe.ms.service;

import com.esipe.ms.domain.Basket;
import com.esipe.ms.domain.Product;
import com.esipe.ms.repository.BasketRepository;
import com.esipe.ms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public void add(Basket basket){
        System.out.println("add basket : " + basket.getUser());

        basketRepository.save(basket);
    }

    public Basket getOne(String user){
        System.out.println("get basket by user : " + user);

        return basketRepository.getOne(user);
    }

    public List<Basket> getAll(){
        return basketRepository.getAll();
    }

    public void update(Basket basket){
        System.out.println("update basket with user : " + basket.getUser());

        basketRepository.update(basket);
    }

    public void delete(String user){
        System.out.println("delete basket with user : " + user);

        basketRepository.delete(user);
    }
}
