package com.rincondelbosque.service.impl;

import com.rincondelbosque.dto.response.MembresiaResponse;
import com.rincondelbosque.model.Membresia;
import com.rincondelbosque.repository.MembresiaRepository;
import com.rincondelbosque.service.MembresiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembresiaServiceImpl implements MembresiaService {
    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public List<MembresiaResponse> listarTodas() {
        return membresiaRepository.findAll().stream()
                .map(MembresiaResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public MembresiaResponse obtenerPorId(Integer idMembresia) {
        return membresiaRepository.findById(idMembresia)
                .map(MembresiaResponse::from)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
    }

    @Override
    public MembresiaResponse crearMembresia(MembresiaResponse membresia) {
        Membresia entity = new Membresia();
        entity.setCodigoMembresia(membresia.codigoMembresia());
        entity.setNombreMembresia(membresia.nombreMembresia());
        entity.setFondoBase(membresia.fondoBase());
        entity.setLimiteConsumo(membresia.limiteConsumo());
        entity.setFondoActual(membresia.fondoActual());
        entity.setEstado(membresia.estado());
        return MembresiaResponse.from(membresiaRepository.save(entity));
    }

    @Override
    public MembresiaResponse actualizarMembresia(Integer idMembresia, MembresiaResponse membresia) {
        Membresia entity = membresiaRepository.findById(idMembresia)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        entity.setCodigoMembresia(membresia.codigoMembresia());
        entity.setNombreMembresia(membresia.nombreMembresia());
        entity.setFondoBase(membresia.fondoBase());
        entity.setLimiteConsumo(membresia.limiteConsumo());
        entity.setFondoActual(membresia.fondoActual());
        entity.setEstado(membresia.estado());
        return MembresiaResponse.from(membresiaRepository.save(entity));
    }
}
