package com.tpSpringboot.equipo10.entity.catalogo;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rubro", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
public class Rubro extends AuditoriaApp {

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @Column(name = "codigo", nullable = false)
    private Integer codigo;
}
