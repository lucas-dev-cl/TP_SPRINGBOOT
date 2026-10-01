package com.tpSpringboot.equipo10.controller;

import com.tpSpringboot.equipo10.service.FacturaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/facturas")
public class FacturacionRestController {
    private final FacturaService facturaService;

    public FacturacionRestController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    // Ejemplo de uso:
    // /api/facturas/buscar?fechaDesde=2024-01-01&fechaHasta=2024-12-31&estado=PAGADO&montoMinimo=1000
    @GetMapping("/buscar")
    public Object buscarFacturas(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) Double montoMinimo
    ) {
        try {
            return facturaService.buscarFacturasFiltradas(fechaDesde, fechaHasta, estado, montoMinimo);
        } catch (IllegalArgumentException e) {
            return e.getMessage(); // Retorna el mensaje de error con status 400 Bad Request
        }
    }
}
