package com.JSSalgadosEDoces.JSSalgadosDoces.Services;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTO.OrderingDTO;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Mapper.Ordering.OrderingMapper;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Responses.GetOrderingResponse;
import com.JSSalgadosEDoces.JSSalgadosDoces.Repository.IClientRepository;
import com.JSSalgadosEDoces.JSSalgadosDoces.Repository.IOrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderingService {
    
    @Autowired
    private IOrderingRepository orderingRepository;
    @Autowired
    private IClientRepository clientRepository;
    @Autowired
    private ProductServices productServices;
    
    public List<GetOrderingResponse> GetAll(){
        List<Ordering> orders = this.orderingRepository.findAll();
        return OrderingMapper.toOrderingResponse(orders);
    }
    
    public GetOrderingResponse GetById(Integer id){
        Optional<Ordering> order = this.orderingRepository.findById(id);

        if(!order.isEmpty())
            return OrderingMapper.toOrderingResponse(order.get());
        
        return null;
    }
    
    public List<Ordering> GetOrderingDeliveryAsc(){
        Sort sortBy = Sort.by(Sort.Direction.ASC, "deliveryDate");        
        return this.orderingRepository.findAll(sortBy);
    }
    
    @Transactional
    public Ordering Create(OrderingDTO dto){
        List<Product> products = ValidateProducts(dto.getProducts());
        
        Ordering entity = OrderingMapper.toOrdering(dto, products);
        
        entity.setOrderingId(null);
        entity.getClient().setClientId(null);
        
        this.clientRepository.save(entity.getClient());
        return this.orderingRepository.save(entity);
    }
    
    @Transactional
    public Ordering Update(Ordering entity){
        Optional<Ordering> updatable = this.orderingRepository.findById(entity.getOrderingId());
        
        updatable.get().setClient(entity.getClient());
        updatable.get().setDelivery(entity.isDelivery());
        updatable.get().setDeliveryDate(entity.getDeliveryDate());
        
        entity = this.orderingRepository.save(updatable.get());
        return entity;
    }
    
    private List<Product> ValidateProducts(List<Integer> productIds){
        List<Product> products = new ArrayList<Product>();
        
        for(Integer id : productIds){
            Product product = this.productServices.GetById(id);
            
            if(product == null) {
                new RuntimeException("Product not found");
            }
            
            products.add(product);
        }
        
        return products;
    }
}
