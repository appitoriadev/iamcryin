package com.rincondelbosque.repository;

import com.rincondelbosque.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    // Métodos personalizados si los necesitas
}
