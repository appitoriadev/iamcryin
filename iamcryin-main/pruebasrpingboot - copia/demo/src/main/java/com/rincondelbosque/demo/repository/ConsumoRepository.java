package com.rincondelbosque.demo.repository;

import com.rincondelbosque.demo.model.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {
    // Métodos personalizados si los necesitas
}
