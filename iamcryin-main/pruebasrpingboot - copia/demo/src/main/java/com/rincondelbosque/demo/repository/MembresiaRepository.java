package com.rincondelbosque.demo.repository;

import com.rincondelbosque.demo.model.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    // Métodos personalizados si los necesitas
}
