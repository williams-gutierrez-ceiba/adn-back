update usuario
set telefono_celular = :telefonoCelular,
	nombres = :nombres,
	apellidos = :apellidos,
	correo_electronico = :correoElectronico,
	tipo_documento = :tipoDocumento,
	numero_documento = :numeroDocumento
where id = :id