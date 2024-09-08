CREATE TABLE skill (
	id BIGINT(20) AUTO_INCREMENT,
	nombre VARCHAR(128),
	PRIMARY KEY (id)
);

CREATE TABLE idioma (
	id BIGINT(20) AUTO_INCREMENT,
	nombre VARCHAR(128),
	PRIMARY KEY (id)
);

CREATE TABLE candidato (
	id BIGINT(20) AUTO_INCREMENT,
	nombre VARCHAR(128),
	apellidos VARCHAR(256),
	avatar VARCHAR(512),
	PRIMARY KEY (id)
);

CREATE TABLE candidato_skill (
	id_candidato BIGINT(20),
	id_skill BIGINT(20),
	nivel VARCHAR(128),
	PRIMARY KEY (id_candidato,id_skill)
);

CREATE TABLE candidato_idioma (
	id_candidato BIGINT(20),
	id_idioma BIGINT(20),
	nivel VARCHAR(128),
	PRIMARY KEY (id_candidato,id_idioma)
);

CREATE TABLE educacion (
	id BIGINT(20) AUTO_INCREMENT,
	id_candidato BIGINT(20),
	institucion VARCHAR(256),
	titulo VARCHAR(256),
	fecha_inicio DATE,
	descripcion TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY (id_candidato) REFERENCES candidato(id)
);

CREATE TABLE recomendacion (
	id BIGINT(20) AUTO_INCREMENT,
	id_candidato BIGINT(20),
	recomendador VARCHAR(256),
	relacion VARCHAR(256),
	fecha DATE,
	comentario TEXT,
	imagen VARCHAR(512),
	PRIMARY KEY (id),
	FOREIGN KEY (id_candidato) REFERENCES candidato(id)
);