package com.JSSalgadosEDoces.JSSalgadosDoces.Services;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import com.JSSalgadosEDoces.JSSalgadosDoces.Repository.IProductRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private IProductRepository productRepository;
    
    public List<Product> GetAll(){
        List<Product> products = this.productRepository.findAll();
        
        if(products.isEmpty())
            return null;
        
        return products;
    }
    
    public Product GetById(Integer id){
        Optional<Product> entity = this.productRepository.findById(id);
        return entity.orElseThrow(() -> new RuntimeException("Product not found"));
    }
    
    @Transactional
    public Product Create(Product entity){
        DecodedImage(entity);
        
        entity.setProductId(null);
        entity = this.productRepository.save(entity);  
        return entity;
    }
    
    private void DecodedImage(Product entity){
        try{
            byte[] decodeBase64 = Base64.decodeBase64(entity.getProductImage().toString());
            entity.setProductImage(decodeBase64);
        }catch(Exception e){
            //throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Error");
        }
    }
}
