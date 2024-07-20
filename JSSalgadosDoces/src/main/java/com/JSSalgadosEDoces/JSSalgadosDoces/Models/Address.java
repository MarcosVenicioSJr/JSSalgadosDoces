package com.JSSalgadosEDoces.JSSalgadosDoces.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    @Column(length = 50)
    private String street;
    @Column(length = 30)
    private String neighborhood;
    private Integer number;
    @Column(length = 10)
    private String zipCode;
}
