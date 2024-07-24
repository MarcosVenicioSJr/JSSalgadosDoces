package com.JSSalgadosEDoces.JSSalgadosDoces.Controller;

import com.JSSalgadosEDoces.JSSalgadosDoces.HandleException.ApiException;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTOs.ProductDTO;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import com.JSSalgadosEDoces.JSSalgadosDoces.Services.ProductServices;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductServices productServices;
    
    @GetMapping
    public ResponseEntity<List<Product>> GetAll(){
        return ResponseEntity.ok().body(this.productServices.GetAll());
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> Get(@PathVariable Integer id){
        return ResponseEntity.ok().body(this.productServices.GetById(id));
    }

    @PostMapping
    public ResponseEntity Post(@RequestBody Product entity){
        this.productServices.Create(entity);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getProductId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
}
