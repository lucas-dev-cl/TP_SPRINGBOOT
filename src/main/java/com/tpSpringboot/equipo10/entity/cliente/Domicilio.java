package com.tpSpringboot.equipo10.entity.cliente;

import com.tpSpringboot.equipo10.entity.base.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "domicilio", schema = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Domicilio extends EntityId {
    @Column(name = "nombre_calle")
    private String nombreCalle;

    @Column(name = "numero_calle")
    private String numeroCalle;
}
