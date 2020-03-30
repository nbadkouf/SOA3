package com.esipe.ms.resource;

import com.esipe.ms.domain.Basket;
import com.esipe.ms.domain.SimpleToken;
import com.esipe.ms.security.JWTTokenValidator;
import com.esipe.ms.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "baskets", produces = {"application/json"})
public class BasketResource {
    private BasketService basketService;
    private JWTTokenValidator tokenValidator;

    @Autowired
    public BasketResource(BasketService us,
                        JWTTokenValidator tokenValidator){
        basketService = us;
        this.tokenValidator = tokenValidator;
    }

    @PostMapping("verify")
    public List<String> verifyToken(@RequestBody SimpleToken token){
        return tokenValidator.verifyAndTransform(token.getToken());
    }

    //On vérifie que la partie sub du token correspond bien au login du user qui veut consulter son panier
    @GetMapping("{user}")
    public Basket getOne(@PathVariable("user") String user, @RequestHeader("Authorization") String token){
        String token_res = token.substring(7);
        if(tokenValidator.verifyAndGetUser(token_res).equals(user)){
            return basketService.getOne(user);
        }
        else {
            System.out.println("Not authorized");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER UNAUTHORIZED");
        }

    }

    //Seul l'ADMIN peut consulter la liste de tous les paniers
    @GetMapping
    public List<Basket> getAll(@RequestHeader("Authorization") String token){
        String token_res = token.substring(7);
        if(tokenValidator.verifyAndTransform(token_res).contains("ADMIN")){
            return basketService.getAll();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER UNAUTHORIZED");
        }
    }

    //On vérifie que la partie sub du token correspond bien au login du user qui veut ajouter un panier
    @PostMapping("{user}")
    public void add(@PathVariable("user") String user, @RequestBody Basket basket, @RequestHeader("Authorization") String token){
        String token_res = token.substring(7);
        if(tokenValidator.verifyAndGetUser(token_res).equals(user)){
            basketService.add(basket);
        }
        else {
            System.out.println("Not authorized");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER UNAUTHORIZED");
        }
    }

    //On vérifie que la partie sub du token correspond bien au login du user qui veut update son panier
    @PutMapping("{user}")
    public void update(@PathVariable("user") String user, @RequestBody Basket basket, @RequestHeader("Authorization") String token){
        String token_res = token.substring(7);
        if(tokenValidator.verifyAndGetUser(token_res).equals(user)){
            basketService.update(basket);
        }
        else {
            System.out.println("Not authorized");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER UNAUTHORIZED");
        }
        if(!user.equals(basket.getUser())){
            throw new RuntimeException("update basket exception");
        }
    }

    //On vérifie que la partie sub du token correspond bien au login du user qui veut supprimer son panier
    @DeleteMapping("{user}")
    public void delete(@PathVariable("user") String user, @RequestHeader("Authorization") String token){
        String token_res = token.substring(7);
        if(tokenValidator.verifyAndGetUser(token_res).equals(user)){
            basketService.delete(user);
        }
        else {
            System.out.println("Not authorized");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USER UNAUTHORIZED");
        }
    }
}
