package com.JSSalgadosEDoces.JSSalgadosDoces.Models.Mapper;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTO.OrderingDTO;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums.OrderingStatus;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;

import java.time.LocalDateTime;

public class OrderingMapper {

    public static Ordering toOrdering(OrderingDTO orderingDTO) {
        Ordering order = new Ordering();
        
        LocalDateTime now = LocalDateTime.now();
        order.setRequestDate(java.sql.Timestamp.valueOf(now));
        
        order.setDelivery(orderingDTO.isDelivery());
        order.setStatus(OrderingStatus.AwaitingAccept);
        order.setClient(orderingDTO.getClient());
        order.setDeliveryDate(orderingDTO.getDeliveryDate());
        order.setProducts(orderingDTO.getProducts());

        return order;
    }
}
