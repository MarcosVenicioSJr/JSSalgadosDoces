package com.JSSalgadosEDoces.JSSalgadosDoces.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column(length = 50)
    private String name;
    @Column(length = 15)
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;
    @OneToMany(mappedBy = "orderingId")
    private List<Ordering> order = new ArrayList<Ordering>();
}
