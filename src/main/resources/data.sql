-- Datos de prueba para facturacion_db_spring

-- Schema: admin
INSERT INTO admin.usuario (id, usuario, clave, nombre, apellido) VALUES
(1, 'admin', 'admin123', 'Administrador', 'Sistema');

-- Schema: clientes
INSERT INTO clientes.condicion_iva (id, codigo_afip, denominacion, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 1, 'Responsable Inscripto', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 6, 'Monotributista', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, 5, 'Consumidor Final', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO clientes.contacto (id, email, telefono, celular) VALUES
(1, 'cliente1@email.com', '555-1001', '11-9999-1001'),
(2, 'cliente2@email.com', '555-1002', '11-9999-1002'),
(3, NULL, '555-1003', '11-9999-1003');

INSERT INTO clientes.domicilio (id, nombre_calle, numero_calle) VALUES
(1, 'Av. Corrientes', '1234'),
(2, 'Av. Libertador', '5678'),
(3, 'Calle Falsa', '123');

INSERT INTO clientes.cliente (id, cuit_cuil, denominacion, contacto_id, domicilio_id, condicion_iva_id, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, '20-12345678-9', 'Empresa S.A.', 1, 1, 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, '27-87654321-0', 'Comercio S.R.L.', 2, 2, 2, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, '20-11111111-1', 'Juan Perez', 3, 3, 3, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

-- Schema: ventas
INSERT INTO ventas.tipo_moneda (id, codigo_afip, denominacion, simbolo, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 'PES', 'Peso Argentino', '$', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 'DOL', 'Dólar Estadounidense', 'U$S', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO ventas.punto_venta (id, numero, descripcion, tipo_emision, domicilio_comercial, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 1, 'Sucursal Central', 'CAE', 'Av. Principal 100', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 2, 'Sucursal Norte', 'CAE', 'Av. Norte 200', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

-- Schema: catalogo
INSERT INTO catalogo.rubro (id, denominacion, codigo, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 'Electrónica', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 'Ropa', 2, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO catalogo.marca (id, denominacion, codigo, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 'Sony', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 'Samsung', 2, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, 'Nike', 3, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO catalogo.articulo (id, rubro_id, codigo, denominacion, marca_id, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 1, 'ART001', 'Televisor 55"', 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 1, 'ART002', 'Celular Galaxy', 2, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, 2, 'ART003', 'Zapatillas Running', 3, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO catalogo.lista_precio (id, codigo, denominacion, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 'LP001', 'Lista Precios Enero 2024', CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO catalogo.lista_precio_articulo (id, lista_precio_id, precio_venta, articulo_id, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 1, 150000.00, 1, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 1, 80000.00, 2, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, 1, 25000.00, 3, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

-- Schema: ventas - Facturas
INSERT INTO ventas.factura_venta (id, numero, fecha_emision, punto_venta_id, cliente_id, condicion_iva_id, tipo_moneda_id, importe_cobrado, importe_saldo, importe_total, cae, cae_fecha_vencimiento, resultado_afip, motivo_rechazo, estado, fecha_anulacion, observaciones, fecha_alta, fecha_baja, fecha_modificacion, usuario_carga_id, usuario_baja_id, usuario_modificacion_id) VALUES
(1, 1001, '2024-01-15', 1, 1, 1, 1, 150000.00, 0.00, 150000.00, NULL, NULL, NULL, NULL, 'PAGADO', NULL, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(2, 1002, '2024-02-20', 1, 2, 2, 1, 80000.00, 0.00, 80000.00, NULL, NULL, NULL, NULL, 'PAGADO', NULL, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(3, 1003, '2024-03-10', 2, 3, 3, 1, 0.00, 25000.00, 25000.00, NULL, NULL, NULL, NULL, 'PENDIENTE', NULL, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(4, 1004, '2024-04-05', 1, 1, 1, 1, 230000.00, 0.00, 230000.00, NULL, NULL, NULL, NULL, 'PAGADO', NULL, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1),
(5, 1005, '2024-05-12', 2, 2, 2, 1, 50000.00, 30000.00, 80000.00, NULL, NULL, NULL, NULL, 'PENDIENTE', NULL, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, 1, NULL, 1);

INSERT INTO ventas.factura_venta_detalle (id, factura_id, lista_precio_articulo_id, descripcion, cantidad, precio_unitario, porcentaje_bonificacion, importe_neto, importe_iva, importe_subtotal) VALUES
(1, 1, 1, 'Televisor 55"', 1, 150000.00, 0.00, 125000.00, 25000.00, 150000.00),
(2, 2, 2, 'Celular Galaxy', 1, 80000.00, 0.00, 66666.67, 13333.33, 80000.00),
(3, 3, 3, 'Zapatillas Running', 1, 25000.00, 0.00, 20833.33, 4166.67, 25000.00),
(4, 4, 1, 'Televisor 55"', 1, 150000.00, 0.00, 125000.00, 25000.00, 150000.00),
(5, 4, 2, 'Celular Galaxy', 1, 80000.00, 0.00, 66666.67, 13333.33, 80000.00),
(6, 5, 3, 'Zapatillas Running', 2, 25000.00, 0.00, 41666.67, 8333.33, 50000.00);
