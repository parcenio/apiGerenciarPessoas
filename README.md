
# API - Gerenciar Pessoas

Projeto básico de API para gerenciar pessoas, permitindo as seguintes funcionalidades abaixo.


### Funcionalidades

- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa  


## Requisitos

- Java 17
- Springboot Framework
    - Spring web
    - JPA
    - Lombok
    - H2 Database
## Documentação da API
Foi utilizado o POSTMAN para realizar dos testes de requisições da aplicação.

#### Retorna todas as pessoas

```http
  GET /pessoa
```

| Parâmetro   | Descrição                           |
| :---------- |:---------------------------------- |
| `Nenhum` | 
Basta executar que irá listar.

#### Adiciona uma Pessoa

```http
  POST /pessoa
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Request Body`      | `JSON` | **Obrigatório**. |

#### Modelo Padão RequestBody


    
   
    "nome":"Teste",
    "dataDeNascimento":"2023-01-12",
    "endereco":[{
        "logradouro":"MIT, Rua Dev",
        "cep":"48000-444",
        "numero":123,
        "cidade":"Alguma",
        "principal": true
    }


Você pode adicionar mais de um endereço.

#### Atualizar dados de uma Pessoa

```http
  PUT /pessoa/{id}
```

| Parâmetro   | Tipo | Descrição                           |
| :---------- |:----- |:---------------------------------- |
| `id` | `Long`|**Obrigatório**. |

Deve-se utilizar mesmo padrão do request body do POST.

#### Remover uma Pessoa

```http
  PUT /pessoa/{id}
```

| Parâmetro   | Tipo | Descrição                           |
| :---------- |:----- |:---------------------------------- |
| `id` | `Long`|**Obrigatório**. |

Basta passar o ID como Parâmetro e será removida esta pessoa.