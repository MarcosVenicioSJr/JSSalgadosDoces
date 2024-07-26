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

    private void DecodedImage(Product entity) {
        try {
            String encodedImage = Base64.encodeBase64String(entity.getProductImage());
            byte[] decodedBytes = Base64.decodeBase64(encodedImage);
            entity.setProductImage(decodedBytes);
            
        } catch (Exception e) {
            // Loga a exceção e lança uma nova com a causa original
            System.err.println("Error decoding image for product: " + entity.getProductId());
            e.printStackTrace();
            throw new RuntimeException("Failed to decode image: " + e.getMessage(), e);
        }
    }
    
    @Transactional
    public void Delete(Integer id){
        this.productRepository.deleteById(id);
    }
    
    @Transactional
    public void Update(Product entity){
        Product entityUpdatable = GetById(entity.getProductId());
        
        entityUpdatable.setName(entity.getName());
        entityUpdatable.setValue(entity.getValue());

        DecodedImage(entity);
        entityUpdatable.setProductImage(entity.getProductImage());

        this.productRepository.save(entityUpdatable);
    }
}
