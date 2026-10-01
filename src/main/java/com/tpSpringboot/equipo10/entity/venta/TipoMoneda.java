package com.tpSpringboot.equipo10.entity.venta;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_moneda", schema = "ventas")
@Getter
@Setter
@NoArgsConstructor
public class TipoMoneda extends AuditoriaApp {

    @Column(name = "codigo_afip", nullable = false)
    private String codigoAfip;

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @Column(name = "simbolo", nullable = false)
    private String simbolo;
}