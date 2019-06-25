DROP TABLE cliente CASCADE;
DROP TABLE tecnico CASCADE;
DROP TABLE status CASCADE;
DROP TABLE servico CASCADE;
DROP TABLE marca CASCADE;
DROP TABLE modelo CASCADE;
DROP TABLE dispositivo CASCADE;
DROP TABLE ordemdeservico CASCADE;
DROP TABLE itenservicoordem CASCADE;

CREATE TABLE cliente(
   cdCliente serial      NOT NULL,
   nome varchar(50) NOT NULL,
   cpf varchar(50) NOT NULL,
   telefone varchar(50) NOT NULL,
   CONSTRAINT pk_cliente
      PRIMARY KEY(cdCliente)
);

CREATE TABLE tecnico(
   cdTecnico serial      NOT NULL,
   nome varchar(50) NOT NULL,
   cpf varchar(50) NOT NULL,
   telefone varchar(50) NOT NULL,
   CONSTRAINT pk_tecnico
      PRIMARY KEY(cdTecnico)
);

CREATE TABLE status(
   cdStatus serial     NOT NULL,
   descricao  varchar(30) NOT NULL,
   CONSTRAINT pk_status
      PRIMARY KEY(cdStatus)
);

CREATE TABLE servico(
   cdServico serial     NOT NULL,
   descricao  varchar(30) NOT NULL,
   CONSTRAINT pk_servico
      PRIMARY KEY(cdServico)
);

CREATE TABLE marca(
   cdMarca serial     NOT NULL,
   nome  varchar(30) NOT NULL,
   CONSTRAINT pk_marca
      PRIMARY KEY(cdMarca)
);

CREATE TABLE modelo(
   cdModelo serial NOT NULL,
   nome  varchar(30) NOT NULL,
   cdMarca int,
   CONSTRAINT pk_modelo
      PRIMARY KEY(cdModelo),
   CONSTRAINT fk_modelo_marca
      FOREIGN KEY(cdMarca)
      REFERENCES marca(cdMarca)
);

CREATE TABLE dispositivo(
   cdDispositivo serial NOT NULL,
   numSerie  varchar(30) NOT NULL,
   descricao  varchar(30) NOT NULL,
   cdModelo int,
   cdMarca int,
   cdCliente int,
   CONSTRAINT pk_dispositivo
      PRIMARY KEY(cdDispositivo),
   CONSTRAINT fk_dispositivo_modelo
      FOREIGN KEY(cdModelo)
      REFERENCES modelo(cdModelo),
   CONSTRAINT fk_dispositivo_marca
      FOREIGN KEY(cdMarca)
      REFERENCES marca(cdMarca),
   CONSTRAINT fk_dispositivo_cliente
      FOREIGN KEY(cdCliente)
      REFERENCES cliente(cdCliente)
);

CREATE TABLE ordemdeservico(
   cdOrdemDeServico serial NOT NULL,
   dataEntrada date NOT NULL,
   dataSaida date,
   descricaoProblema  varchar(200) NOT NULL,
   valorTotal float NOT NULL,
   cdCliente int,
   cdTecnico int,
   cdDispositivo int,
   cdStatus int,
   CONSTRAINT pk_ordemdeservico
      PRIMARY KEY(cdOrdemDeServico),
   CONSTRAINT fk_ordemdeservico_cliente
      FOREIGN KEY(cdCliente)
      REFERENCES cliente(cdCliente),
   CONSTRAINT fk_ordemdeservico_tecnico
      FOREIGN KEY(cdTecnico)
      REFERENCES tecnico(cdTecnico),
   CONSTRAINT fk_ordemdeservico_dispositivo
      FOREIGN KEY(cdDispositivo)
      REFERENCES dispositivo(cdDispositivo),
   CONSTRAINT fk_ordemdeservico_status
      FOREIGN KEY(cdStatus)
      REFERENCES status(cdStatus)
);

CREATE TABLE itenservicoordem(
   cdItemServicoOrdem serial NOT NULL,
   valor float NOT NULL,
   cdOrdemDeServico int,
   cdServico int,
   CONSTRAINT pk_itenservicoordem
      PRIMARY KEY(cdItemServicoOrdem),
   CONSTRAINT fk_itenservicoordem_ordemdeservico
      FOREIGN KEY(cdOrdemDeServico)
      REFERENCES ordemdeservico(cdOrdemDeServico),
   CONSTRAINT fk_itenservicoordem_servico
      FOREIGN KEY(cdServico)
      REFERENCES servico(cdServico)
);

INSERT INTO cliente(nome, cpf, telefone) VALUES('Rafael'   ,'111.111.111-11','(11) 1111-1111');
INSERT INTO cliente(nome, cpf, telefone) VALUES('João'     ,'222.222.222-22','(22) 2222-2222');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Maria'    ,'333.333.333-33','(33) 3333-4578');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Jose'     ,'785.333.454-78','(25) 4555-7845');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Fernando' ,'659.258.777-88','(45) 7884-1245');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Gerson'   ,'567.333.548-65','(55) 4122-4887');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Fabiana'  ,'455.387.658-88','(78) 4528-6879');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Lucas'    ,'478.333.652-85','(98) 4578-7885');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Ingrid'   ,'568.527.778-22','(44) 5467-1444');
INSERT INTO cliente(nome, cpf, telefone) VALUES('Fabiola'  ,'852.333.785-45','(55) 7851-1275');

INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Rafael'   ,'111.111.111-11','(11) 1111-1111');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec João'     ,'222.222.222-22','(22) 2222-2222');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Maria'    ,'333.333.333-33','(33) 3333-4578');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Jose'     ,'785.333.454-78','(25) 4555-7845');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Fernando' ,'659.258.777-88','(45) 7884-1245');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Gerson'   ,'567.333.548-65','(55) 4122-4887');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Fabiana'  ,'455.387.658-88','(78) 4528-6879');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Lucas'    ,'478.333.652-85','(98) 4578-7885');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Ingrid'   ,'568.527.778-22','(44) 5467-1444');
INSERT INTO tecnico(nome, cpf, telefone) VALUES('Tec Fabiola'  ,'852.333.785-45','(55) 7851-1275');

INSERT INTO status(descricao) VALUES('Aberta - Normal');
INSERT INTO status(descricao) VALUES('Aberta - Urgente');
INSERT INTO status(descricao) VALUES('Em Andamento');
INSERT INTO status(descricao) VALUES('Finalizada');

INSERT INTO servico(descricao) VALUES('Troca de Tela LCD');
INSERT INTO servico(descricao) VALUES('Troca de Tela Vidro');
INSERT INTO servico(descricao) VALUES('Troca de Bateria');
INSERT INTO servico(descricao) VALUES('Troca de Conector USB A');
INSERT INTO servico(descricao) VALUES('Troca de Conector USB C');
INSERT INTO servico(descricao) VALUES('Reinstalação do SO');
INSERT INTO servico(descricao) VALUES('Troca de Auto Falante');
INSERT INTO servico(descricao) VALUES('Aplicação de Pelicula');
INSERT INTO servico(descricao) VALUES('Manutencao na Câmera');
INSERT INTO servico(descricao) VALUES('Mão de Obra');

INSERT INTO marca(nome) VALUES('Motorola');
INSERT INTO marca(nome) VALUES('Samsung');
INSERT INTO marca(nome) VALUES('Lenovo');
INSERT INTO marca(nome) VALUES('Apple');
INSERT INTO marca(nome) VALUES('LG');

INSERT INTO modelo(nome, cdMarca) VALUES('Moto G1','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto X2','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto Z3','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto One','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto G5 Power','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto X Force','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Moto G6 Play','1');
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy S10','2');
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy S9','2');
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy Note 9','2');
INSERT INTO modelo(nome, cdMarca) VALUES('K8 Pro','3');
INSERT INTO modelo(nome, cdMarca) VALUES('Vibe Play','3');
INSERT INTO modelo(nome, cdMarca) VALUES('K6 Plus','3');
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone 7','4');
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone Xs','4');
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone 8 Plus','4');
INSERT INTO modelo(nome, cdMarca) VALUES('K10 Play','5');
INSERT INTO modelo(nome, cdMarca) VALUES('G6 Pro','5');
INSERT INTO modelo(nome, cdMarca) VALUES('G6 Plus','5');

INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('123487945','Azul Com Adesivos','1','1','1');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('456742148','Preto Arranhado','2','1','2');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('325487889','Cinza Manchado','3','1','3');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('289845578','Branco Amarelado','8','2','4');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('325487789','Azul Novo','9','2','5');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('456877984','Cinza Novo','10','2','6');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('326459798','Amarelo Novo','11','3','7');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('225487984','Branco Novo','12','3','8');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('116658794','Preto Novo Com Adesivos','13','3','9');