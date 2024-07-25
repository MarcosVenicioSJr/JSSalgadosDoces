package com.JSSalgadosEDoces.JSSalgadosDoces.Services;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;
import com.JSSalgadosEDoces.JSSalgadosDoces.Repository.IOrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderingService {
    
    @Autowired
    private IOrderingRepository orderingRepository;
    
    public List<Ordering> GetAll(){
        return this.orderingRepository.findAll();
    }
    
    public Ordering GetById(Integer id){
        Optional<Ordering> order = this.orderingRepository.findById(id);
        return order.orElseThrow(() -> new RuntimeException("Not found"));
    }
    
    public List<Ordering> GetOrderingDeliveryAsc(){
        Sort sortBy = Sort.by(Sort.Direction.ASC, "deliveryDate");        
        return this.orderingRepository.findAll(sortBy);
    }
    
    @Transactional
    public void Create(Ordering entity){
        entity.setOrderingId(null);
        this.orderingRepository.save(entity);
    }
    
    @Transactional
    public Ordering Update(Ordering entity){
        Ordering updatable = GetById(entity.getOrderingId());
        
        updatable.setClient(entity.getClient());
        updatable.setDelivery(entity.isDelivery());
        updatable.setDeliveryDate(entity.getDeliveryDate());
        
        entity = this.orderingRepository.save(updatable);
        return entity;
    }
}
