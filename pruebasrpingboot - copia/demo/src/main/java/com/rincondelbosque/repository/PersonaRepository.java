package com.rincondelbosque.repository;

import com.rincondelbosque.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    // Métodos personalizados si los necesitas
}
