# Trabalho prático de Gerência e Configuração de Software


![foto projeto gerencia e configuracao](https://github.com/Matheus-Belo/gerencia_pipeline_implantacao/assets/90854775/435290d9-b807-4482-b599-23a126f77383)

# Índice/Sumário

* [Sobre](#sobre-o-projeto)
* [Requisitos Funcionais](#requisitos-funcionais)
* [Tecnologias Usadas](#tecnologias-usadas)
* [Arquitetura](#arquitetura)
* [Instruções de uso](#instruções-de-uso)
* [Teste](#testes)
* [Código Fonte](#código-fonte)
* [Contribuição](#contribuição)
* [Autor](#autor)
* [Licença](#licença)
* [Agradecimentos](#agradecimentos)


# Sobre o Projeto

Neste projeto, será desenvolvida uma API para gerenciar pacientes de uma clínica médica. O setor de TI da clínica identificou a necessidade de uma solução que melhore o software existente, dada a crescente complexidade dos sistemas atuais e o aumento no volume de dados. A equipe de tecnologia reconheceu a importância de uma ferramenta mais integrada e eficiente para gerenciar as informações de saúde dos pacientes. Dessa forma, o desenvolvimento da API visa otimizar os processos internos, simplificar a gestão de dados e aprimorar a qualidade do atendimento prestado pela clínica, representando uma resposta estratégica às demandas atuais.


# Requisitos Funcionais 

- [x] Cadastrar Paciente
- [x] Calcular Peso Ideal
- [x] Obter CPF ofuscado
- [x] Obter situação do IMC
- [x] Calcular IMC
- [x] Calcular Idade
- [x] Validar CPF
- [x] Editar informações do Paciente
- [x] Excluir Paciente do sistema
- [x] Visualizar todos os pacientes disponíveis
- [x] Visualizar Informações do Paciente

# Tecnologias Usadas

- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Vscode](https://code.visualstudio.com/)
- [MySQL](https://www.mysql.com/)
- [Postman](https://www.postman.com/)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)
- [GitHub Actions](https://github.com/features/actions)
- [HeidiSQL](https://www.heidisql.com/)

# Arquitetura

O software de gerenciamento de pacientes foi desenvolvido utilizando a arquitetura Model, Repository, Service e Controller visando modularidade, facilidade de manutenção e clareza na separação de responsabilidades.

Model
A camada de Model é responsável por definir as entidades do sistema. No caso do gerenciamento de pacientes, a entidade principal é o Paciente. Esta classe contém atributos como nome, sobrenome, sexo, data de nascimento, altura, peso, CPF, e métodos para calcular o IMC, obter a situação do IMC, calcular a idade, entre outros.

Repository
A camada de Repository é responsável pela interação com o banco de dados. Utilizando o Spring Data JPA, o repositório do Paciente (PacienteRepository) fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) e consultas específicas de forma simples e eficiente.

Service
A camada de Service contém a lógica de negócios do sistema. O PacienteService gerencia as operações relacionadas aos pacientes, como cálculos de IMC, verificação de CPF, e outras regras de negócios. Essa camada garante que a lógica de negócio esteja separada da lógica de acesso aos dados e da apresentação.

Controller
A camada de Controller é responsável por lidar com as requisições HTTP e mapear essas requisições para os serviços correspondentes. Os controladores, como o PacienteController, processam as entradas do usuário, chamam os serviços apropriados e retornam as respostas adequadas. Esta camada garante a interação entre o usuário e a aplicação.

# Instruções de uso
1. Clonar o Repositório<br>
Primeiro, clone o repositório do projeto a partir do GitHub:<br>
git clone https://github.com/Matheus-Belo/gerencia_pipeline_implantacao.git<br>
cd gerencia_pipeline_implantacao

2. Configurar o Ambiente<br>
Certifique-se de ter o Java JDK 11 (ou superior) e Maven instalados no seu sistema.

3. Construir o Projeto<br>
Execute o seguinte comando para construir o projeto e baixar as dependências necessárias:<br>
mvn clean install

4. Executar a Aplicação<br>
Para iniciar a aplicação, utilize o comando Maven:<br>
mvn spring-boot:run

5. Uso da API<br>
A interação com a API do gerenciamento de pacientes funciona através da ferramenta Postman. A aplicação será iniciada no endereço http://localhost:8080.<br><br>
Adicionar um Paciente<br>
POST http://localhost:8080/pacientes<br><br>
Obter Lista de Pacientes<br>
GET http://localhost:8080/pacientes<br><br>
Obter Detalhes de um Paciente pelo ID<br>
GET http://localhost:8080/pacientes/{id}<br><br>
Atualizar um Paciente<br>
PUT http://localhost:8080/pacientes/{id} <br><br>
Excluir um Paciente<br>
DEL http://localhost:8080/pacientes/{id}<br>

# Testes

Foi desenvolvido testes unitários ( lógica de negócios e validações dos modelos), integração (verificam a interação entre diferentes componentes do sistema) e aceitação ( validam os requisitos funcionais da API)

# Código Fonte

O código fonte encontra-se clicando [aqui](https://github.com/Matheus-Belo/gerencia_pipeline_implantacao/tree/main/src)

# Contribuição

Leia o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para saber detalhes sobre o nosso código de conduta e o processo de envio de solicitações *pull* (*Pull Request*) para nós.

# Autor

[Matheus Belo Santos Mello](https://github.com/Matheus-Belo)

# Licença

Este projeto está licenciado sob a Licença MIT,  consulte o arquivo [LICENSE.md](LICENSE.md) para mais detalhes.

# Agradecimentos

Gostaria de expressar minha profunda gratidão a todos que, de alguma forma, contribuíram para a execução deste projeto.
