package com.JSSalgadosEDoces.JSSalgadosDoces.Models.Mapper.Ordering;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTO.OrderingDTO;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums.OrderingStatus;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Responses.GetOrderingResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderingMapper {

    public static Ordering toOrdering(OrderingDTO orderingDTO, List<Product> products) {
        Ordering order = new Ordering();
        
        LocalDateTime now = LocalDateTime.now();
        order.setRequestDate(java.sql.Timestamp.valueOf(now));
        
        order.setDelivery(orderingDTO.isDelivery());
        order.setStatus(OrderingStatus.AwaitingAccept);
        order.setClient(orderingDTO.getClient());
        order.setDeliveryDate(orderingDTO.getDeliveryDate());
        order.setProducts(products);
        
        return order;
    }
    
    public static List<GetOrderingResponse> toOrderingResponse(List<Ordering> entity){
        List<GetOrderingResponse> responses = new ArrayList<GetOrderingResponse>();

        
        for (Ordering ordering : entity) {
            GetOrderingResponse response = new GetOrderingResponse();
            
            toMappingResponse(response, ordering);

            responses.add(response);
        }
        
        return responses;
    }
    
    public static GetOrderingResponse toOrderingResponse(Ordering entity){
        GetOrderingResponse response = new GetOrderingResponse();

        toMappingResponse(response, entity);
        
        return response;
    }
    
    private static GetOrderingResponse toMappingResponse(GetOrderingResponse response, Ordering entity){
        response.setOrderingId(entity.getOrderingId());
        response.setName(entity.getClient().getName());
        response.setPhone(entity.getClient().getPhone());
        response.setProducts(entity.getProducts());
        response.setDeliveryDate(entity.getDeliveryDate());
        response.setRequestDate(entity.getRequestDate());
        response.setDelivery(entity.isDelivery());
        response.setStatus(entity.getStatus());
        
        return response;
    }
}
