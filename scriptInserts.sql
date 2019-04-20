
INSERT INTO clientes(nome, cpf, telefone) VALUES('Rafael'   ,'111.111.111-11','(11) 1111-1111');
INSERT INTO clientes(nome, cpf, telefone) VALUES('João'     ,'222.222.222-22','(22) 2222-2222');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Maria'    ,'333.333.333-33','(33) 3333-4578');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Jose'     ,'785.333.454-78','(25) 4555-7845');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Fernando' ,'659.258.777-88','(45) 7884-1245');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Gerson'   ,'567.333.548-65','(55) 4122-4887');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Fabiana'  ,'455.387.658-88','(78) 4528-6879');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Lucas'    ,'478.333.652-85','(98) 4578-7885');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Ingrid'   ,'568.527.778-22','(44) 5467-1444');
INSERT INTO clientes(nome, cpf, telefone) VALUES('Fabiola'  ,'852.333.785-45','(55) 7851-1275');

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

INSERT INTO modelo(nome, cdMarca) VALUES('Moto G1',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto X2',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto Z3',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto One',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto G5 Power',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto X Force',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Moto G6 Play',"1");
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy S10',"2");
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy S9',"2");
INSERT INTO modelo(nome, cdMarca) VALUES('Galaxy Note 9',"2");
INSERT INTO modelo(nome, cdMarca) VALUES('K8 Pro',"3");
INSERT INTO modelo(nome, cdMarca) VALUES('Vibe Play',"3");
INSERT INTO modelo(nome, cdMarca) VALUES('K6 Plus',"3");
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone 7',"4");
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone Xs',"4");
INSERT INTO modelo(nome, cdMarca) VALUES('Iphone 8 Plus',"4");
INSERT INTO modelo(nome, cdMarca) VALUES('K10 Play',"5");
INSERT INTO modelo(nome, cdMarca) VALUES('G6 Pro',"5");
INSERT INTO modelo(nome, cdMarca) VALUES('G6 Plus',"5");

INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('123487945','Azul Com Adesivos','1','1','1');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('456742148','Preto Arranhado','2','1','2');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('325487889','Cinza Manchado','3','1','3');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('289845578','Branco Amarelado','8','2','4');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('325487789','Azul Novo','9','2','5');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('456877984','Cinza Novo','10','2','6');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('326459798','Amarelo Novo','11','3','7');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('225487984','Branco Novo','12','3','8');
INSERT INTO dispositivo(numSerie, descricao, cdModelo, cdMarca, cdCliente) VALUES('116658794','Preto Novo Com Adesivos','13','3','9');


-- Inserts Ordem de Servico Abertas/Em Anadamento - Sem data de Saida
INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('15/04/2019','Tela Quebrada','200.00','1','1','1','1');
INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('18/04/2019','Bateria Ruim','150.00','2','2','2','1');
INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('17/04/2019','Tela Quebrada/Falante Ruim','350.00','3','3','3','1');

INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('10/04/2019','Tela Quebrada/Bateria Ruim','450.00','4','4','4','2');
INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('11/04/2019','Auto Falante Ruim','100.00','5','5','5','2');
INSERT INTO ordemdeservico(dataEntrada, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('12/04/2019','Bateria Ruim/Tela Arranhada','230.00','6','6','6','2');

-- Inserts Ordem de Servico Finalizada - Com data de Saida
INSERT INTO ordemdeservico(dataEntrada, dataSaida, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('05/04/2019','10/04/2019','Tela Quebrada/Bateria Fraca','280.00','7','7','7','3');
INSERT INTO ordemdeservico(dataEntrada, dataSaida, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('04/02/2019','12/02/2019','Tela Quebrada/Bateria Ruim/Falante Ruim','500.00','8','8','8','3');
INSERT INTO ordemdeservico(dataEntrada, dataSaida, descricaoProblema, valorTotal, cdCliente, cdTecnico, cdDispositivo, cdStatus) VALUES('03/03/2019','11/03/2019','Tela Arranhada','120.00','9','9','9','3');


INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('200.00','1','1');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('150.00','2','3');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('150.00','3','3');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('200.00','3','1');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('450.00','4','1');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('100.00','5','3');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('230.00','6','1');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('280.00','7','2');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('500.00','8','1');
INSERT INTO itenservicoordem(valor, cdOrdemDeServico, cdServico) VALUES('120.00','9','2');
