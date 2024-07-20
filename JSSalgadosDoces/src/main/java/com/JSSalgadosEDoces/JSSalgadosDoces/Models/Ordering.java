package com.JSSalgadosEDoces.JSSalgadosDoces.Models;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Enums.OrderingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderingId;
    @Column(nullable = false)
    private Date requestDate;
    @Column(nullable = false)
    private Date deliveryDate;
    @Column(nullable = false)
    private OrderingStatus status;
    @Column(nullable = false)
    private boolean isDelivery;
    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;
    
}
