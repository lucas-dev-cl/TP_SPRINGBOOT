package com.tpSpringboot.equipo10.entity.venta;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import com.tpSpringboot.equipo10.entity.cliente.Cliente;
import com.tpSpringboot.equipo10.entity.cliente.CondicionIva;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

// Entidad FacturaVenta refactorizada con Lombok
@Entity
@Table(name = "factura_venta", schema = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {"detalles"})
@ToString(exclude = {"detalles"})
public class FacturaVenta extends AuditoriaApp {
    @Column(name = "numero")
    private Long numero;
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "punto_venta_id", nullable = false)
    private PuntoVenta puntoVenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condicion_iva_id", nullable = false)
    private CondicionIva condicionIva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_moneda_id", nullable = false)
    private TipoMoneda tipoMoneda;
    @Column(name = "importe_cobrado")
    private double importeCobrado;
    @Column(name = "importe_saldo")
    private double importeSaldo;
    @Column(name = "importe_total", nullable = false)
    private double importeTotal;
    @Column(name = "cae")
    private String cae;
    @Column(name = "cae_fecha_vencimiento")
    private Date caeFechaVencimiento;
    @Column(name = "resultado_afip")
    private String resultadoAfip;
    @Column(name = "motivo_rechazo")
    private String motivoRechazo;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "fecha_anulacion")
    private Date fechaAnulacion;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval =
            true)
    private List<FacturaVentaDetalle> detalles;
}
