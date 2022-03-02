insert into tipo_vivienda (nombre, costo_diario) values ('Tipo A', 200000);

insert into tipo_vivienda (nombre, costo_diario) values ('Tipo B', 100000);

insert into vivienda (tipo_vivienda_id, ciudad, departamento, aire_acondicionado, mascotas, calefaccion, numero_banios, numero_personas, numero_habitaciones) values (1, 'Villeta', 'Cundinamarca', 1, 1, 1, 3, 6, 3);

insert into vivienda (tipo_vivienda_id, ciudad, departamento, aire_acondicionado, mascotas, calefaccion, numero_banios, numero_personas, numero_habitaciones) values (2, 'Girardot', 'Cundinamarca', 1, 1, 1, 2, 4, 2);

insert into usuario (telefono_celular, nombres, apellidos, correo_electronico, tipo_documento, numero_documento)
    values ('32145', 'Juan', 'Pérez', 'test@test.com', 'CC', '1025639260');

insert into usuario (telefono_celular, nombres, apellidos, correo_electronico, tipo_documento, numero_documento)
    values ('3125259929', 'Williams', 'Gutiérrez', 'test@test.com', 'CC', '1025639260');

insert into reserva (usuario_id, vivienda_id, fecha_inicio, fecha_fin, valor_parcial, valor_total)
    values ('32145', 1, '2022-10-15', '2022-10-20', 200000, 1000000);

insert into reserva (usuario_id, vivienda_id, fecha_inicio, fecha_fin, valor_parcial, valor_total)
    values ('32145', 2, '2022-11-06', '2022-11-10', 100000, 500000);
