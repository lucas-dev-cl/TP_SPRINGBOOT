package com.tpSpringboot.equipo10.entity.venta;

import com.tpSpringboot.equipo10.entity.base.EntityId;
import com.tpSpringboot.equipo10.entity.catalogo.ListaPrecioArticulo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura_venta_detalle", schema = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class FacturaVentaDetalle extends EntityId {

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private FacturaVenta factura;

    @ManyToOne
    @JoinColumn(name = "lista_precio_articulo_id", nullable = false)
    private ListaPrecioArticulo listaPrecioArticulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "porcentaje_bonificacion")
    private double porcentajeBonificacion;

    @Column(name = "importe_neto")
    private double importeNeto;

    @Column(name = "importe_iva")
    private double importeIva;

    @Column(name = "importe_subtotal", nullable = false)
    private double importeSubtotal;
}