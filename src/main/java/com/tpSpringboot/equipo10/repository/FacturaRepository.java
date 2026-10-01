package com.tpSpringboot.equipo10.repository;

import com.tpSpringboot.equipo10.entity.venta.FacturaVenta;
import com.tpSpringboot.equipo10.repository.custom.FacturaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaVenta, Long>, FacturaRepositoryCustom {
}
