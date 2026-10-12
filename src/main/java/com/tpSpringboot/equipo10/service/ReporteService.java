package com.tpSpringboot.equipo10.service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tpSpringboot.equipo10.entity.DTO.FacturaReporteDTO;
import com.tpSpringboot.equipo10.repository.FacturaRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ReporteService {

    private final FacturaRepository facturaRepository;

    public ReporteService(FacturaRepository facturaRepository){
        this.facturaRepository = facturaRepository;
    }

    public byte[] generarReportePdf(Date fechaDesde, Date fechaHasta, String estado, Double montoMinimo) {
        List<FacturaReporteDTO> facturas = facturaRepository.buscarFacturasFiltradas(fechaDesde, fechaHasta, estado, montoMinimo);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4.rotate()); // Formato horizontal ideal para tablas con muchos campos

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Título del reporte
            document.add(new Paragraph("Reporte de Facturas"));
            document.add(new Paragraph(" ")); // Espacio en blanco

            // Tabla con las columnas del DTO (7 columnas)
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);

            // Cabeceras
            String[] headers = {"Nro. Factura", "Fecha Emisión", "Cliente", "Condición IVA", "Punto Venta", "Importe Total", "Items"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setBackgroundColor(java.awt.Color.LIGHT_GRAY);
                table.addCell(cell);
            }

            // Filas de datos mapeadas desde el DTO
            for (FacturaReporteDTO f : facturas) {
                table.addCell(String.valueOf(f.getNumeroFactura()));
                table.addCell(f.getFechaEmision() != null ? f.getFechaEmision().toString() : "");
                table.addCell(f.getClienteDenominacion() != null ? f.getClienteDenominacion() : "");
                table.addCell(f.getCondicionIva() != null ? f.getCondicionIva() : "");
                table.addCell(f.getPuntoVentaDescripcion() != null ? f.getPuntoVentaDescripcion() : "");
                table.addCell(String.format("%.2f", f.getImporteTotal()));
                table.addCell(String.valueOf(f.getCantidadItems()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            throw new RuntimeException("Error al generar el PDF: " + e.getMessage(), e);
        }

        return out.toByteArray();
    }

    public byte[] generarReporteExcel(Date fechaDesde, Date fechaHasta, String estado, Double montoMinimo) {
        List<FacturaReporteDTO> facturas = facturaRepository.buscarFacturasFiltradas(fechaDesde, fechaHasta, estado, montoMinimo);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Facturas");

            // Crear fila de encabezados
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Nro. Factura", "Fecha Emisión", "Cliente", "Condición IVA", "Punto Venta", "Importe Total", "Cantidad Items"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Llenar datos desde la lista del DTO
            int rowIdx = 1;
            for (FacturaReporteDTO f : facturas) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(f.getNumeroFactura() != null ? f.getNumeroFactura() : 0);
                row.createCell(1).setCellValue(f.getFechaEmision() != null ? f.getFechaEmision().toString() : "");
                row.createCell(2).setCellValue(f.getClienteDenominacion() != null ? f.getClienteDenominacion() : "");
                row.createCell(3).setCellValue(f.getCondicionIva() != null ? f.getCondicionIva() : "");
                row.createCell(4).setCellValue(f.getPuntoVentaDescripcion() != null ? f.getPuntoVentaDescripcion() : "");
                row.createCell(5).setCellValue(f.getImporteTotal());
                row.createCell(6).setCellValue(f.getCantidadItems());
            }

            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error al generar el Excel: " + e.getMessage(), e);
        }
    }
}
