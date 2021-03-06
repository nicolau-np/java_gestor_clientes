drop database gestao_clientes;

create database gestao_clientes default character set utf8;

use gestao_clientes;

-- Tabela de Pais --
create table pais(
idPais bigint(22) primary key auto_increment,
pais varchar(45) not null unique,
bandeira varchar(45) null,
capital varchar(45) not null unique,
indicativo varchar(6) not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

insert into pais(pais, bandeira, capital, indicativo, estado) 
values
("Angola", null, "Luanda", "+244", "on"),
("Portugal", null, "Lisboa", "+354", "on");
-- end --

-- Tabela de Provincia --
create table provincias(
idProvincia bigint(22) primary key auto_increment,
id_pais bigint(22)  not null,
provincia varchar(45) not null unique,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table provincias add constraint provincias_pais_id_pais 
foreign key(id_pais) references pais(idPais) on update cascade;

insert into provincias(id_pais, provincia, estado) 
values(1, "Namibe", "on"),
(1, "Luanda", "on"),
(1, "Benguela", "on"),
(1, "Huíla", "on"),
(1, "Cunene", "on"),
(1, "Moxico", "on"),
(1, "Lunda Sul", "on"),
(1, "Lunda Norte", "on"),
(1, "Cuanza Sul", "on"),
(1, "Cuanza Norte", "on"),
(1, "Bié", "on"),
(1, "Huambo", "on"),
(1, "Cuando Cubango", "on"),
(1, "Malanje", "on"),
(1, "Cabinda", "on"),
(1, "Zaire", "on"),
(1, "Uíge", "on"),
(1, "Bengo", "on")
;
-- end --

-- Tabela de Municipio --
create table municipios(
idMunicipio bigint(22) primary key auto_increment,
id_provincia bigint(22)  not null,
municipio varchar(45) not null unique,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table municipios add constraint municipio_provincia_id_provincia 
foreign key(id_provincia) references provincias(idProvincia) on update cascade; 

insert into municipios(id_provincia, municipio, estado) values 
-- namibe --
(1, "Moçamedes", "on"),
(1, "Tômbwa", "on"),
(1, "Virei", "on"),
(1, "Lucira", "on"),
(1, "Camucuio", "on"),
(1, "Bibala", "on"),
-- end --

-- luanda --
(2, "Luanda", "on"),
(2, "Cacuaco", "on"),
(2, "Cazenga", "on"),
(2, "Ingombota", "on"),
(2, "Kilamba Kiaxi", "on"),
(2, "Maianga", "on"),
(2, "Rangel", "on"),
(2, "Samba", "on"),
(2, "Sambizanga", "on"),
(2, "Viana", "on"),
-- end --

-- benguela --
(3, "Benguela", "on"),
(3, "Baía Farta", "on"),
(3, "Balombo", "on"),
(3, "Bocoio", "on"),
(3, "Caimbambo", "on"),
(3, "Chongoroi", "on"),
(3, "Cubal", "on"),
(3, "Ganda", "on"),
(3, "Lubito", "on")
-- end --


;
-- end --

-- Tabela de Pessoa --
create table pessoas(
idPessoa bigint(22) primary key auto_increment,
id_municipio bigint(22)  not null,
nome varchar(55) not null,
genero varchar(20) not null,
data_nascimento date not null,
telefone bigint(12) not null,
foto longblob null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table pessoas add constraint pessoa_municipio_id_municipio 
foreign key(id_municipio) references municipios(idMunicipio) on update cascade;

insert into pessoas (id_municipio, nome, genero, data_nascimento, telefone, foto, estado) 
values(1, "Nicolau Pungue", "Masculino", "2000-08-29", 946216795, null, "on");
-- end --

-- Tabela de Utilizadores --
create table utilizadores(
idUtilizador bigint(22) primary key auto_increment,
id_pessoa bigint(22)  not null,
utilizador varchar(45) not null unique,
palavra_passe text not null,
acesso varchar(20) not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table utilizadores add constraint utilizadores_pessoa_id_pessoa 
foreign key(id_pessoa) references pessoas(idPessoa);

insert into utilizadores (id_pessoa, utilizador, palavra_passe, acesso, estado) 
values(1, "nicolau-np", "babaca", "admin", "on");
-- end --

-- Tabela de Fornecedor--
create table fornecedores(
idFornecedor bigint(22) primary key auto_increment,
fornecedor varchar(45) not null unique,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);
-- end --

-- Tabela de NotaPedido --
create table nota_pedidos(
idNotaPedido bigint(22) primary key auto_increment,
id_fornecedor bigint(22)  null,
id_utilizador bigint(22)  not null,
tipo_nota varchar(45) not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table nota_pedidos add constraint nota_pedido_fornecedores_id_fornecedor 
foreign key(id_fornecedor) references fornecedores(idFornecedor) on update cascade;

alter table nota_pedidos add constraint nota_pedido_utilizadores_id_utilizador 
foreign key(id_utilizador) references utilizadores(idUtilizador) on update cascade;
-- end --

-- Tabela de Cliente--
create table clientes(
idCliente bigint(22) primary key auto_increment,
id_pessoa bigint(22)  not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table clientes add constraint clientes_pessoas_id_pessoa 
foreign key(id_pessoa) references pessoas(idPessoa) on update cascade;

-- end --

-- Tabela de Servico --
create table servicos(
idServico bigint(22) primary key auto_increment,
servico varchar(45) not null unique,
preco decimal(16,2) not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);
-- end --

-- Tabela de Pedidos --
create table pedidos(
idPedido bigint(22) primary key auto_increment,
id_cliente bigint(22)  null,
id_servico bigint(22)  null,
data_entrada date not null,
data_saida date null,
preco decimal(16,2) not null,
descriao text not null,
estado varchar(4) not null,
created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP
);

alter table pedidos add constraint pedidos_clientes_id_clientes 
foreign key(id_cliente) references clientes(idCliente) on update cascade;

alter table pedidos add constraint pedidos_servicos_id_servico 
foreign key(id_servico) references servicos(idServico) on update cascade;
-- end --


-- view Utilizador --
create view ulilizador_view as select pessoas.idPessoa, utilizadores.idUtilizador, 
pessoas.nome, pessoas.genero, pessoas.data_nascimento,pessoas.telefone, municipios.municipio, 
provincias.provincia, pais.pais, utilizadores.utilizador, utilizadores.palavra_passe, 
utilizadores.acesso, utilizadores.estado, utilizadores.created_at 
from pessoas inner join municipios on 
pessoas.id_municipio = municipios.idMunicipio 
inner join provincias on 
municipios.id_provincia = provincias.idProvincia 
inner join pais on 
provincias.id_pais = pais.idPais 
inner join utilizadores on 
pessoas.idPessoa = utilizadores.id_pessoa;
-- end --