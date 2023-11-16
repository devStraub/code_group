-- DROP SCHEMA code_group;

CREATE SCHEMA code_group;

-- DROP SEQUENCE code_group.cargo_id_seq;

CREATE SEQUENCE code_group.cargo_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.cargo_pessoa_id_seq;

CREATE SEQUENCE code_group.cargo_pessoa_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.membro_projeto_id_seq;

CREATE SEQUENCE code_group.membro_projeto_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.membros_idprojeto_seq;

CREATE SEQUENCE code_group.membros_idprojeto_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.pessoa_id_seq;

CREATE SEQUENCE code_group.pessoa_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.projeto_id_seq;

CREATE SEQUENCE code_group.projeto_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE code_group.projeto_idgerente_seq;

CREATE SEQUENCE code_group.projeto_idgerente_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- code_group.cargo definition

-- Drop table

-- DROP TABLE cargo;

CREATE TABLE code_group.cargo (
	id bigserial NOT NULL,
	nome varchar NOT NULL,
	CONSTRAINT cargo_pk PRIMARY KEY (id)
);


-- code_group.pessoa definition

-- Drop table

-- DROP TABLE pessoa;

CREATE TABLE code_group.pessoa (
	id bigserial NOT NULL,
	nome varchar(100) NOT NULL,
	datanascimento date NULL,
	cpf varchar(14) NULL,
	funcionario bool NULL,
	CONSTRAINT pk_pessoa PRIMARY KEY (id)
);


-- code_group.cargo_pessoa definition

-- Drop table

-- DROP TABLE cargo_pessoa;

CREATE TABLE code_group.cargo_pessoa (
	id bigserial NOT NULL,
	cargo int8 NOT NULL,
	pessoa int8 NOT NULL,
	CONSTRAINT cargo_pessoa_pk PRIMARY KEY (id),
	CONSTRAINT cargo_pessoa_un UNIQUE (pessoa),
	CONSTRAINT cape_cargo_fk FOREIGN KEY (cargo) REFERENCES cargo(id),
	CONSTRAINT cape_pessoa_fk FOREIGN KEY (pessoa) REFERENCES pessoa(id)
);


-- code_group.projeto definition

-- Drop table

-- DROP TABLE projeto;

CREATE TABLE code_group.projeto (
	id bigserial NOT NULL,
	nome varchar(200) NOT NULL,
	data_inicio date NULL,
	data_previsao_fim date NULL,
	data_fim date NULL,
	descricao varchar(5000) NULL,
	status varchar(45) NULL,
	orcamento float8 NULL,
	risco varchar(45) NULL,
	idgerente bigserial NOT NULL,
	CONSTRAINT pk_projeto PRIMARY KEY (id),
	CONSTRAINT fk_gerente FOREIGN KEY (idgerente) REFERENCES pessoa(id)
);


-- code_group.membro_projeto definition

-- Drop table

-- DROP TABLE membro_projeto;

CREATE TABLE code_group.membro_projeto (
	id bigserial NOT NULL,
	projeto int8 NOT NULL,
	pessoa int8 NOT NULL,
	CONSTRAINT membro_projeto_pk PRIMARY KEY (id),
	CONSTRAINT membro_projeto_un UNIQUE (projeto, pessoa),
	CONSTRAINT membro_projeto_pessoa_fk FOREIGN KEY (pessoa) REFERENCES pessoa(id) ON DELETE CASCADE,
	CONSTRAINT membro_projeto_projeto_fk FOREIGN KEY (projeto) REFERENCES projeto(id) ON DELETE CASCADE
);


-- code_group.membros definition

-- Drop table

-- DROP TABLE membros;

CREATE TABLE code_group.membros (
	idprojeto bigserial NOT NULL,
	idpessoa int8 NOT NULL,
	CONSTRAINT pk_membros_projeto PRIMARY KEY (idprojeto),
	CONSTRAINT fk_membros_pessoa FOREIGN KEY (idpessoa) REFERENCES projeto(id),
	CONSTRAINT fk_pessoa FOREIGN KEY (idpessoa) REFERENCES pessoa(id)
);
