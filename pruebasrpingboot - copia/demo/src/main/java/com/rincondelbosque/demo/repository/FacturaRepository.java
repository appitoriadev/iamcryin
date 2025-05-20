package com.rincondelbosque.demo.repository;

import com.rincondelbosque.demo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // Métodos personalizados si los necesitas
}
