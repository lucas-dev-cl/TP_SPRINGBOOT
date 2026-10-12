package com.tpSpringboot.equipo10.controller;

import com.tpSpringboot.equipo10.service.FacturaService;
import com.tpSpringboot.equipo10.service.ReporteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/facturas")
public class FacturacionRestController {

    private final FacturaService facturaService;
    private final ReporteService reporteService;

    public FacturacionRestController(FacturaService facturaService, ReporteService reporteService) {
        this.facturaService = facturaService;
        this.reporteService = reporteService;
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

    @GetMapping("/exportar/pdf")
    public ResponseEntity<byte[]> exportarPdf(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) Double montoMinimo
    ) {
        byte[] pdfBytes = reporteService.generarReportePdf(fechaDesde, fechaHasta, estado, montoMinimo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("reporte_facturas.pdf").build());

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/exportar/excel")
    public ResponseEntity<byte[]> exportarExcel(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaDesde,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaHasta,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) Double montoMinimo
    ) {
        byte[] excelBytes = reporteService.generarReporteExcel(fechaDesde, fechaHasta, estado, montoMinimo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDisposition(ContentDisposition.attachment().filename("reporte_facturas.xlsx").build());

        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    }
}
