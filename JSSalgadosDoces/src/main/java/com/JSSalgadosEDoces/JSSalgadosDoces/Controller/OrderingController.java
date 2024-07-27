package com.JSSalgadosEDoces.JSSalgadosDoces.Controller;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTO.OrderingDTO;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Responses.GetOrderingResponse;
import com.JSSalgadosEDoces.JSSalgadosDoces.Services.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/ordering")
public class OrderingController {
    @Autowired
    private OrderingService orderingServiceservice;
    
    @GetMapping
    public ResponseEntity<List<GetOrderingResponse>> GetAll(){
        return ResponseEntity.ok().body(this.orderingServiceservice.GetAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GetOrderingResponse> GetById(@PathVariable Integer id){
        return ResponseEntity.ok().body(this.orderingServiceservice.GetById(id));
    }
    
    @GetMapping("/asc")
    public ResponseEntity<List<Ordering>> GetOrderingDeliveryAsc(){
        return ResponseEntity.ok().body(this.orderingServiceservice.GetOrderingDeliveryAsc());
    }
    
    @PostMapping
    @Validated(Ordering.class)
    public ResponseEntity Create(@RequestBody OrderingDTO entity){
        Ordering order = this.orderingServiceservice.Create(entity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getOrderingId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }
    
    @PutMapping
    public ResponseEntity<Ordering> Update(@RequestBody Ordering entity){
        Ordering order = this.orderingServiceservice.Update(entity);
        return ResponseEntity.ok().body(entity);
    }
}