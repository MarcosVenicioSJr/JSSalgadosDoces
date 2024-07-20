package com.JSSalgadosEDoces.JSSalgadosDoces.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter @Setter @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    
    @Column(length = 50)
    private String name;
    
    @Column(nullable = false)
    private BigDecimal value;
    
    @Lob
    @Column(nullable = false)
    private byte[] productImage;
}
