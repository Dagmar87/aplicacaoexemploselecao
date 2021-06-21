# Aplicação Exemplo Seleção  
Esse projeto Spring Boot foi desenvolvido, de forma FullStack, por José Dagmar Florentino da Silva Sobrinho para o ESIG GROUP como atividade técnica desenvolvimento JAVA. O projeto consiste na criação de um sistema de gerenciamento de cadastro e de consulta de tarefas, utilizando como serviços de APIs, as operações CRUD (Create, Read, Update e Delete) e de um site de cadastro e de consulta para funcionamento do sistema.

As tecnologias usadas nesse projeto foram:

- Linguagem Java (Versão 8)
- Banco de Dados MySQL
- HTML
- CSS
- Spring Boot
- Spring Data JPA
- Validation
- Thymeleaf
- Maven
- Hibernate
- Lombok
- RESTful
- Apache Tomcat
- IDE Eclipse
- Insomnia

### Estrutura do Projeto

O projeto do AplicacaoExemploSelecao possui a seguinte estrutura de pacotes e de classes:

AplicacaoExemploSelecao (Projeto)

- AplicacaoExemploSelecaoApplication (Classe)
- Controller (Pacote)
  - TarefaController (Classe)
  - ResponsavelController (Classe)
- Model (Pacote)
  - Tarefa(Classe)
  - Responsavel(Classe)
  - Prioridade(Enum)
- Repository (Pacote)
  - TarefaRepository (Interface)
  - ResponsavelRepository (Interface)

Esse projeto é dividido, como qualquer outro projeto SpringBoot, em 3 pacotes: Controller, Model e Repository. Nesses pacotes contém duas entidades para suas respectivas operações: Tarefa e Responsável.

### Banco de Dados

Para esse projeto, foram criados duas tabelas no banco de dados MySQL que foram as tabelas Tarefa, que é tabela primaria do projeto, e Responsável, que é tabela secundaria que é conectada com a tabela Tarefa.

A tabela Tarefa contém os seguintes atributos:

- Numero - LONG - PK (Chave Primaria da Tabela) - O numero da tarefa;
- Titulo - STRING - O nome da tarefa;
- Descricao - STRING - A descrição da tarefa;
- Responsavel - LONG - FK(Chave Estrangeira da Tabela) - O responsável que irá fica no cargo dessa tarefa e esse campo utilizar a id da tabela Responsável é chave estrangeira que conectar as duas tabelas.
- Prioridade - ENUM do tipo STRING - O nível de prioridade dessa tarefa que é definida como alto, médio ou baixo;
- Deadline - DATE - A data de entrega ou de encerramento dessa tarefa;

A tabela Responsável contém os seguintes atributos:

- Id - LONG - PK (Chave Primaria da Tabela) - O numero da id do responsável;
- Nome - STRING - O nome do responsável;

Esses atributos dessas duas tabelas serão espelhados nos atributos das classes do pacote Model do projeto.

### Operações CRUD do Projeto

Nesse projeto foram realizado duas operações CRUD, sendo a primeira as da Tarefa, que é considerada a operação primaria do sistema e que será no back-end e no front-end, e as do Responsável, que é considerada a operação secundaria e auxiliar,  já que ficam guardados os dados do responsável dessa tarefa que serão vitais para a operação primaria (Tarefa) e que será realizada apenas no back-end.

#### Tarefa

As operações CRUD da Tarefa são divididas em 5 operações que são:

- FindAll => Essa operação irá consultar uma lista de todas tarefas cadastradas.

URL deste método: http://localhost:8072/tarefa

- FindById => Essa operação irá consultar uma determinada tarefa cadastrada partir do numero deste.

URL deste método: http://localhost:8072/tarefa/{numero}

- Create => Essa operação irá criar um novo cadastro de uma tarefa.

URL deste método: http://localhost:8072/tarefa

- Update => Essa operação irá atualizar os dados de uma tarefa cadastrada.

URL deste método: http://localhost:8072/tarefa/{numero}

- Delete => Essa operação irá apagar os dados da tarefa cadastrada.

URL deste método: http://localhost:8072/tarefa/{numero}

#### Responsável

As operações CRUD da Responsável são divididas em 5 operações que são:

- FindAll => Essa operação irá consultar uma lista de todos responsáveis cadastrados.

URL deste método: http://localhost:8072/responsavel

- FindById => Essa operação irá consultar um determinado responsável cadastrado partir do id deste.

URL deste método: http://localhost:8072/responsavel/{id}

- Create => Essa operação irá criar um novo cadastro de um responsável .

URL deste método: http://localhost:8072/responsavel

- Update => Essa operação irá atualizar os dados de um responsável cadastrado.

URL deste método: http://localhost:8072/responsavel/{id}

- Delete => Essa operação irá apagar os dados do responsável cadastrado.

URL deste método: http://localhost:8072/responsavel/{id}

#### Resultados das Operações no MySQL

Após realização das operações CRUD, os dados serão enviados e guardados no banco de dados MySQL nas tabelas Tarefa e Responsável, como vemos nas duas imagens abaixo:

##### Tarefa

![image](https://user-images.githubusercontent.com/64164006/122772312-a2435a00-d27d-11eb-87e2-4c7069da89fd.png)

​											Resultado das Operações CRUD do campo Tarefa no MySQL

##### Responsável

![image](https://user-images.githubusercontent.com/64164006/122772440-c2731900-d27d-11eb-91f3-58b6a141c917.png)

​									Resultado das Operações CRUD do campo Responsável no MySQL

### Estrutura Front-End do Projeto

Para realização das operações do sistema no sentido Front-End, foram criadas três telas em HTML e CSS que foram: Tela Principal, Tela de Cadastro de Tarefas e Tela de Consulta de Tarefas.

#### Tela Principal

Essa é a tela inicial do site onde temos a mensagem de bem-vindo do projeto, a descrição sobre o projeto e os menu de acesso as telas de cadastro e de consulta, conforme a imagem abaixo:

![image](https://user-images.githubusercontent.com/64164006/122772529-dae33380-d27d-11eb-8640-7f44fb41d10e.png)

#### Tela de Cadastro de Tarefas

Essa é a tela onde será realizada a operação de cadastro das tarefas, tendo todos os parâmetros da entidade Tarefa que serão preenchidos nessa tela, conforme a imagem abaixo:

![image](https://user-images.githubusercontent.com/64164006/122772589-ea627c80-d27d-11eb-81bb-3789621aa0a1.png)

#### Tela de Consulta de Tarefas

Essa é a tela onde será realizada a listagem das tarefas através da consulta de um dos parâmetros da entidade Tarefa e através dessa listagem também serão realizados as operações de atualização e  de apagamento das tarefas, conforme a imagem abaixo:

![image](https://user-images.githubusercontent.com/64164006/122772678-ff3f1000-d27d-11eb-9475-f44b99e43fe3.png)

### Observações do Projeto

Algumas observações sobre o projeto:

- A parte de back-end está 100% funcional, apesar que ainda precisar criar algumas operações de consulta para entidade Tarefa, e já na parte no front-end, ainda precisa fazer a integração com a parte de back-end, incluindo validar os parâmetros de cadastro e de consulta; e fazer os botões das operações funcionais, já que essa parte não está 100% funcional e apenas sua estrutura das telas está montada.
- Em relação ao front-end, ainda precisa implementar alguns parâmetros estéticos do CSS na telas de cadastro e de consulta, além da criação da tela de atualização, que será similar a tela de cadastro.        



