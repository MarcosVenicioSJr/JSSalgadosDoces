package com.JSSalgadosEDoces.JSSalgadosDoces.Repository;

import com.JSSalgadosEDoces.JSSalgadosDoces.Models.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderingRepository extends JpaRepository<Ordering, Integer> {
}
