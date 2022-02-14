create table if not exists usuario (
    id int(11) not null auto_increment,
    telefono_celular varchar(13) not null,
    nombres varchar(20) not null,
    apellidos varchar(20) not null,
    correo_electronico varchar(50) not null,
    tipo_documento varchar(2) not null,
    numero_documento varchar(13) not null,
    primary key (id)
);

create table if not exists tipo_vivienda (
    id tinyint not null auto_increment,
    costo_diario decimal not null,
    nombre varchar(20) not null,
    primary key (id)
);

create table if not exists vivienda (
    id bigint(20) not null auto_increment,
	tipo_vivienda_id tinyint(1) not null,
	ciudad varchar(20) not null,
	departamento varchar(20) not null,
    aire_acondicionado tinyint(1) not null,
	mascotas tinyint(1) not null,
	calefaccion tinyint(1) not null,
	numero_banios int not null,
	numero_personas int not null,
	numero_habitaciones int not null,
    primary key (id),
	foreign key (tipo_vivienda_id) references tipo_vivienda(id)
);

create table if not exists reserva (
    id bigint not null auto_increment,
	usuario_id varchar(13) not null,
	vivienda_id bigint(20) not null,
    fecha_inicio date not null,
	fecha_fin date not null,
	valor_parcial decimal not null,
	valor_total decimal not null,
    primary key (id),
	foreign key (usuario_id) references usuario(telefono_celular),
	foreign key (vivienda_id) references vivienda(id)
);