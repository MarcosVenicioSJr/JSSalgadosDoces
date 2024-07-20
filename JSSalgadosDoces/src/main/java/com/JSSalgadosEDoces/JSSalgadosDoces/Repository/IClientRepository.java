package com.JSSalgadosEDoces.JSSalgadosDoces.Repository;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {
}
