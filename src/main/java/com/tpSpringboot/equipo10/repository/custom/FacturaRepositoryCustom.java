package com.tpSpringboot.equipo10.repository.custom;

import com.tpSpringboot.equipo10.entity.DTO.FacturaReporteDTO;

import java.util.Date;
import java.util.List;

// Interfaz de métodos personalizados para el repositorio de Factura
public interface FacturaRepositoryCustom {
    List<FacturaReporteDTO> buscarFacturasFiltradas(
            Date fechaDesde, Date fechaHasta, String estado, Double montoMinimo
    );
}
