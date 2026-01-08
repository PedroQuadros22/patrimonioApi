# 📦 API de Controle de Patrimônio

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de equipamentos e ativos patrimoniais. O sistema permite cadastrar, listar, atualizar e excluir equipamentos, com validações de negócio para evitar duplicidade de números de série.

## 🚀 Tecnologias Utilizadas

* **Java 17** (ou versão superior)
* **Spring Boot 3**
* **Spring Data JPA** (Hibernate)
* **H2 Database** (Banco de dados em memória)
* **Maven** (Gerenciador de dependências)

## 🛠️ Como Executar o Projeto

### Pré-requisitos
Certifique-se de ter o **Java (JDK)** e o **Maven** instalados em sua máquina.

### Passo a Passo
1.  Clone este repositório:
    ```bash
    git clone [https://github.com/SEU-USUARIO/NOME-DO-REPO.git](https://github.com/SEU-USUARIO/NOME-DO-REPO.git)
    ```
2.  Entre na pasta do projeto e execute via terminal:
    ```bash
    mvn spring-boot:run
    ```
3.  Ou, se estiver usando o **IntelliJ IDEA**:
    * Abra o projeto.
    * Aguarde o Maven baixar as dependências.
    * Localize a classe `PatrimonioApiApplication` e clique no botão **Run** (Play verde).

O servidor iniciará na porta **8080**.

---

## 🔌 Endpoints da API

A URL base é: `http://localhost:8080/equipamento`

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/equipamento` | Lista todos os equipamentos cadastrados. |
| **GET** | `/equipamento/{id}` | Busca um equipamento específico pelo ID. |
| **POST** | `/equipamento` | Cadastra um novo equipamento. |
| **PUT** | `/equipamento/{id}` | Atualiza todos os dados de um equipamento existente. |
| **DELETE** | `/equipamento/{id}` | Remove um equipamento do banco de dados. |

### 📝 Exemplo de JSON (Corpo da Requisição)

Para cadastrar (**POST**) ou atualizar (**PUT**), utilize este formato:

```json
{
  "name": "Notebook Dell Latitude",
  "tipo": "Informática",
  "numeroSerie": "DELL-5544",
  "dataAquisicao": "08/01/2026",
  "status": "ativo"
}
