package com.tpSpringboot.equipo10.entity.cliente;

import com.tpSpringboot.equipo10.entity.base.EntityId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contacto", schema = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Contacto extends EntityId {
    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;
}