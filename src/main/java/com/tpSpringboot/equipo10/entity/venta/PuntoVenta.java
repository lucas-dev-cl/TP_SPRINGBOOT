package com.tpSpringboot.equipo10.entity.venta;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "punto_venta", schema = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class PuntoVenta extends AuditoriaApp {

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_emision")
    private String tipoEmision;

    @Column(name = "domicilio_comercial")
    private String domicilioComercial;
}
