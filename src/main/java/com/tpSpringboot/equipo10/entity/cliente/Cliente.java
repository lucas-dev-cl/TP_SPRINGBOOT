package com.tpSpringboot.equipo10.entity.cliente;

import com.tpSpringboot.equipo10.entity.base.AuditoriaApp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente", schema = "clientes")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends AuditoriaApp {

    @Column(name = "cuit_cuil", nullable = false)
    private String cuitCuil;

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "domicilio_id", nullable = false)
    private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name = "condicion_iva_id", nullable = false)
    private CondicionIva condicionIva;
}
