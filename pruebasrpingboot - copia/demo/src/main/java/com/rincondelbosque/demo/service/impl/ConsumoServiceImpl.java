package com.rincondelbosque.demo.service.impl;

import com.rincondelbosque.demo.dto.response.ConsumoResponse;
import com.rincondelbosque.demo.model.Consumo;
import com.rincondelbosque.demo.repository.ConsumoRepository;
import com.rincondelbosque.demo.service.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumoServiceImpl implements ConsumoService {
    @Autowired
    private ConsumoRepository consumoRepository;

    @Override
    public List<ConsumoResponse> listarTodos() {
        return consumoRepository.findAll().stream()
                .map(ConsumoResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public ConsumoResponse obtenerPorId(Integer idConsumo) {
        return consumoRepository.findById(idConsumo)
                .map(ConsumoResponse::from)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));
    }

    @Override
    public ConsumoResponse crearConsumo(ConsumoResponse consumo) {
        Consumo entity = new Consumo();
        // Asignar campos desde el DTO
        // ...
        return ConsumoResponse.from(consumoRepository.save(entity));
    }

    @Override
    public ConsumoResponse actualizarConsumo(Integer idConsumo, ConsumoResponse consumo) {
        Consumo entity = consumoRepository.findById(idConsumo)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));
        // Actualizar campos desde el DTO
        // ...
        return ConsumoResponse.from(consumoRepository.save(entity));
    }
}
