package com.tpSpringboot.equipo10.entity.catalogo;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulo", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
public class Articulo extends AuditoriaApp {

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}