package com.esipe.ms.resource;
import com.esipe.ms.domain.Product;
import com.esipe.ms.security.JWTTokenGenerator;
import com.esipe.ms.security.JWTTokenValidator;
import com.esipe.ms.service.ProductService;
import com.esipe.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping(value = "products", produces = {"application/json"})
public class ProductResource {
    private ProductService productService;
    @Autowired
    public ProductResource(ProductService us){
        productService = us;
    }

    @GetMapping("{gtin}")
    public Product getOne(@PathVariable("gtin") String gtin){

        return productService.getOne(gtin);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Product product){

        productService.add(product);
    }

    @PutMapping("{gtin}")
    public void update(@PathVariable("gtin") String gtin, @RequestBody Product product){

        if(!gtin.equals(product.getGtin())){
            throw new RuntimeException("update product exception");
        }

        productService.update(product);
    }

    @DeleteMapping("{gtin}")
    public void delete(@PathVariable("gtin") String label){

        productService.delete(label);
    }
}
