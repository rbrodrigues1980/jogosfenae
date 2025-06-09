# Jogos

![Badge](https://img.shields.io/badge/license-MIT-green?style=for-the-badge)

## Sobre o projeto

Micro serviço para estudo de JPA, Spring Security, Autenticação JWT, Swagger, Bancos de dados.


```bash
# Clone este repositório
$ git clone https://github.com/rbrodrigues1980/jogosfenae.git

# Abra ou importe o projeto no IntelliJ IDEA (ou uma IDE de sua preferência)
# Execute VendasApplication
O servidor iniciará na porta:8080 usando o perfil **prod**, que conecta ao banco
de dados MySQL configurado em `application-prod.properties`.

Para acessar a documentação da API acesse <http://localhost:8080/swagger-ui.html>

# Execute os testes unitários

# Utilize o insomnia para acessar os endpoints. (Ou um client de sua preferência)
```

## Tecnologias utilizadas

- Java 11+
- Spring Boot
- Maven

## Dependências

- Spring JPA
- Spring Security
- Swagger2
- JWT
- H2
- MySQL
- Lombok
- Hibernate Validator


## Autor

### Rogerio Rodrigues

- email: rbrodrigues@gmail.com
- linkedin: https://www.linkedin.com/in/rbrodrigues/

# TODO

### 1. Cadastro de Apcefs
#### A condição de limite é para cada Apcef
#### Para cadastrar uma Apcef é preciso obrigatoriamente preencher os seguintes campos:
1. Nome da Apcef
2. Quantidade total de Participantes, exceto os Técnicos que não entram na contagem total
3. Quantidade de presidente
4. Quantidade de diretor de esporte
5. Quantidade de atleta
6. Quantidade de paratleta
7. Quantidade de técnico  

### Cadastrar Modalidades
### Cadastrar Submodalidades
### Cadastrar Participantes

    - O limite de participantes, só é para quem tem o tipo: 
    - Um Presidente por Apcef
    - Um Diretor de Esportes
    - Tecnicos podem incluir quantos quiserem, mas não faz parte do limite estabelecidos para o numero da comitiva
    - O número de atletas é contando com o numero de presidente e diretor de esporte

### Cadastrar Usuários de sistema
### Relatórios
