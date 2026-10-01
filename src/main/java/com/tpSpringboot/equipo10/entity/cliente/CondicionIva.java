package com.tpSpringboot.equipo10.entity.cliente;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "condicion_iva", schema = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class CondicionIva extends AuditoriaApp {

    @Column(name = "codigo_afip", nullable = false)
    private int codigoAfip;

    @Column(name = "denominacion", nullable = false)
    private String denominacion;
}
