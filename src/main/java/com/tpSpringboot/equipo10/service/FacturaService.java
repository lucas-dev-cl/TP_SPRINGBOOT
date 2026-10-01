package com.tpSpringboot.equipo10.service;

import com.tpSpringboot.equipo10.entity.DTO.FacturaReporteDTO;
import com.tpSpringboot.equipo10.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaService {
    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    /**
     * Busca facturas filtradas por fecha, estado y monto.
     *
     * @param fechaDesde
     * @param fechaHasta
     * @param estado
     * @param montoMinimo
     * @return resumen de objetos de la lista de facturas filtradas
     */
    public List<FacturaReporteDTO> buscarFacturasFiltradas(Date fechaDesde, Date fechaHasta, String estado, Double montoMinimo) {
        if (montoMinimo != null && montoMinimo < 0) {
            throw new IllegalArgumentException("El monto mínimo no puede ser negativo");
        }

        return facturaRepository.buscarFacturasFiltradas(fechaDesde, fechaHasta, estado, montoMinimo);
    }
}
