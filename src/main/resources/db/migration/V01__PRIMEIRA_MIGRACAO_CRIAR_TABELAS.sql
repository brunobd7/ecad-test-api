-- create database ecad;

----------TABELAS----------

--CARTEIRAS
create table carteiras
(
    id BIGSERIAL
        constraint carteiras_pk primary key,
    nome_beneficiario varchar(255)
);

--BANCOS
create table bancos
(
    id BIGSERIAL
        constraint bancos_pk primary key,
    nome varchar(255)
);

--USUARIO
create table usuarios
(
    id BIGSERIAL
        constraint usuarios_pk primary key,
    nome varchar(255)
);

--ARQUIVOS
create table arquivos_bancarios
(
    id BIGSERIAL constraint arquivos_bancarios_pk primary key,
    nome_arquivo      varchar(255),
    quantidade_linhas integer,
    data_geracao      date,
    data_envio        date,
    valor             double precision,
    tipo_arquivo      varchar(7),
    id_banco          bigint
        constraint bancos_fk references bancos,
    id_usuario        bigint
        constraint usuarios_fk references usuarios,
    id_carteira       bigint
        constraint carteiras_fk references carteiras
);
