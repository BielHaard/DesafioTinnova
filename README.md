Aplicação SpringBoot - Gerenciamento de Veículos
Esta é uma aplicação SpringBoot que gerencia informações de veículos. Ela utiliza um banco de dados Postgres para armazenar os dados dos veículos. Além disso, existem também três endpoints adicionais para realizar desafios de programação.

Endpoints
Abaixo estão os endpoints disponíveis na aplicação.

GET /veiculos: Este endpoint retorna todos os veículos armazenados no banco de dados.
GET /veiculos?marca={marca}&ano={ano}&cor={cor}: Este endpoint retorna todos os veículos que atendem aos critérios de busca passados como parâmetros.
GET /veiculos/{id}: Este endpoint retorna os detalhes de um veículo específico, identificado pelo ID passado na URL.
POST /veiculos: Este endpoint adiciona um novo veículo ao banco de dados.
PUT /veiculos/{id}: Este endpoint atualiza as informações de um veículo específico, identificado pelo ID passado na URL.
PATCH /veiculos/{id}: Este endpoint atualiza apenas algumas informações de um veículo específico, identificado pelo ID passado na URL.
GET /fatorial/{numero}: Este endpoint realiza o cálculo do fatorial do número passado como parâmetro.
GET /bubbleSort: Este endpoint realiza a ordenação do vetor designado no desafio de programação.
GET /percentuais: Este endpoint retorna os dados das médias de votos designados no desafio de programação.

Tecnologias utilizadas
Java 11
SpringBoot
Postgres

Como instalar e utilizar
Clone o repositório
Configure o arquivo application.properties para apontar para o banco de dados Postgres correto
Execute o comando mvn install para instalar as dependências do projeto
Execute o comando mvn spring-boot:run para iniciar a aplicação
Como contribuir
Se desejar contribuir com a aplicação, siga os passos abaixo:

Faça um fork deste repositório
Crie uma nova branch com suas alterações (git checkout -b minha-branch)
Commit suas alterações (git commit -am 'Adicionando nova funcionalidade')
Push para a branch (git push origin minha-branch)
Abra um pull request
Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais informações.

Contato
Email: julio.garcia.profissional@gmail.com
GitHub: https://github.com/BielHaard
