drop table if exists t_cso_intervencao cascade;
drop table if exists t_cso_caso cascade;
drop table if exists t_cso_servidor cascade;
drop table if exists t_cso_psi cascade;

create table t_cso_psi (
    cpf 			varchar(11) primary key,
    nome			varchar(255),
    senha			varchar(255),
    lotacao 		varchar(6),
    acesso			int default 0
);
-- Acesso 0: nenhum, 1: admin, 2: gerente, 3: normal


-- SIMULA ACESSO AO SIGRH (mesmos dados da INTRANET)
create table t_cso_servidor (
	cpf 			varchar(11) primary key,
	nome 			varchar(255),
	cargo 			varchar(255),
	data_nascimento	date,
	matricula 		varchar(12),
	data_ingresso 	date,
	data_cargo 		date,
	email 			varchar(255),
	telefone 		varchar(14),
	celular 		varchar(15),
	unidade 		varchar(255)
);

create table t_cso_caso (
	id 				int auto_increment primary key,
	sgpe			varchar(20),
    tipo			varchar(255),
    cid				varchar(255),
    data_inicio		date,
    data_fim_prev	date,
    data_fim		date,
    cpfServidor		varchar(11),
    nomeServidor	varchar(255),
    cpfPsi			varchar(11),
    nomePsi			varchar(255)
);

alter table t_cso_caso add constraint fk_caso_psi foreign key (cpfPsi) references t_cso_psi(cpf);
alter table t_cso_caso add constraint fk_caso_servidor foreign key (cpfServidor) references t_cso_servidor(cpf);

create table t_cso_intervencao (
	id 				int auto_increment primary key,
    tipo 			varchar(255),
    data			date,
    hora			time,
    notas		 	varchar(1000),
    psi				varchar(13),
    nome_psi		varchar(255),
    caso			int
);

alter table t_cso_intervencao add constraint fk_intervencao_psi foreign key (psi) references t_cso_psi(cpf);
alter table t_cso_intervencao add constraint fk_intervencao_caso foreign key (caso) references t_cso_caso(id);

create table t_cso_tipo_caso (
	tipo 			varchar(255) primary key
);

create table t_cso_tipo_intervencao (
	tipo 			varchar(255) primary key
);

create table t_cso_cid (
	cid				varchar(255) primary key
);

/* NÃO SERÁ IMPLEMENTADO MULTIPLOS CIDs POR CASO NO PROTÓTIPO DO SISTEMA.

create table t_cso_caso_cid (
	id 				int auto_increment primary key,
	caso			int,
    cid				varchar(7)
);

alter table t_cso_caso_cid add constraint fk_caso_cid foreign key (caso) references t_cso_caso(id);
alter table t_cso_caso_cid add constraint fk_cid foreign key (cid) references t_cso_cid(cid);
*/