package com.JSSalgadosEDoces.JSSalgadosDoces.Models.Responses;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums.OrderingStatus;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class GetOrderingResponse {
    private Integer orderingId;
    private Date requestDate;
    private Date deliveryDate;
    private OrderingStatus status;
    private boolean isDelivery;
    private String name;
    private String phone;
    private List<Product> products = new ArrayList<Product>();
}
