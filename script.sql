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

