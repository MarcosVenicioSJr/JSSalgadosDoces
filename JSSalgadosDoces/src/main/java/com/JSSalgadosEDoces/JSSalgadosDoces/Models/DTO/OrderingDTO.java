package com.JSSalgadosEDoces.JSSalgadosDoces.Models.DTO;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Client;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums.OrderingStatus;
import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class OrderingDTO {
    private Date requestDate;
    private Date deliveryDate;
    private OrderingStatus status;
    private boolean isDelivery;
    private List<Product> products = new ArrayList<>();
    private Client client;
}
