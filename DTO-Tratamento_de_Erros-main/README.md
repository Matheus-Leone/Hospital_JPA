# 🏥 Sistema Hospitalar API

API REST desenvolvida com Spring Boot para gerenciamento de um sistema hospitalar, incluindo pacientes, médicos, consultas, receitas, prontuários e convênios.

---

## IMPLEMENTAÇÃO DE TRATAMENTO DE ERROS

 Atualizei o sistema hospitalar utilizando o @RestControllerAdvice, que serve para tratar erros de forma padronizada.



## 🚀 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Jakarta Validation
* Lombok
* Banco de Dados Relacional (H2/MySQL)
* Postman (testes)

---

## 🧱 Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas com uso de DTO:

**Controller → Service → Repository → Model → Banco de Dados**

### Responsabilidades das Camadas

* **Controller** → Recebe e responde requisições HTTP
* **Service** → Contém as regras de negócio
* **Repository** → Responsável pelo acesso ao banco de dados
* **DTO** → Transporte de dados entre cliente e API
* **Model (Entity)** → Representação das entidades e persistência
* **config** → Representaçã

---

## 🔄 Fluxo com DTO

**Cliente → RequestDTO → Controller → Service → Entity → Banco de Dados**

**Banco de Dados → Entity → Service → ResponseDTO → Cliente**

---

## 📦 Funcionalidades

O sistema permite operações completas de CRUD para:

* 👤 Paciente
* 👨‍⚕️ Médico
* 🏥 Consulta
* 💊 Receita
* 📄 Prontuário
* 🧾 Convênio

---

## 🧩 Implementação com DTO

Cada entidade possui:

* `RequestDTO` → Dados recebidos pela API
* `ResponseDTO` → Dados retornados pela API

Exemplo:

* `PacienteRequestDTO`
* `PacienteResponseDTO`

### Benefícios do uso de DTO

* Maior segurança dos dados
* Desacoplamento entre API e banco de dados
* Facilidade de manutenção
* Evolução simplificada da API
* Validação automática das entradas

---

## ✅ Validações Implementadas

Utilizando Jakarta Validation:

* `@NotBlank`
* `@Email` (quando aplicável)
* `@Valid`

As validações são executadas antes da camada de serviço.

---

## 🔗 Endpoints Principais

### 👤 Pacientes

* GET `/pacientes`
* GET `/pacientes/{id}`
* POST `/pacientes`
* PUT `/pacientes/{id}`
* DELETE `/pacientes/{id}`

### 👨‍⚕️ Médicos

* GET `/medicos`
* GET `/medicos/{id}`
* GET `/medicos/especialidade/{nome}`
* POST `/medicos`
* PUT `/medicos/{id}`
* DELETE `/medicos/{id}`

### 🏥 Consultas

* GET `/consultas`
* GET `/consultas/{id}`
* GET `/consultas/paciente/{id}`
* GET `/consultas/medico/{id}`
* GET `/consultas/convenio/{id}`
* POST `/consultas`
* PUT `/consultas/{id}`
* DELETE `/consultas/{id}`

### 💊 Receitas

* GET `/receitas`
* GET `/receitas/{id}`
* GET `/receitas/consulta/{id}`
* POST `/receitas`
* PUT `/receitas/{id}`
* DELETE `/receitas/{id}`

### 📄 Prontuários

* GET `/prontuarios`
* GET `/prontuarios/{id}`
* GET `/prontuarios/paciente/{id}`
* POST `/prontuarios`
* PUT `/prontuarios/{id}`
* DELETE `/prontuarios/{id}`

### 🧾 Convênios

* GET `/convenios`
* GET `/convenios/{id}`
* GET `/convenios/nome/{nome}`
* POST `/convenios`
* PUT `/convenios/{id}`
* DELETE `/convenios/{id}`

---

## ▶️ Como Executar o Projeto

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
./mvnw spring-boot:run
```

Ou execute a classe principal pela sua IDE.

---

## 🌐 URL Base

```bash
http://localhost:8080
```

---

## 🧪 Testes com Postman

Fluxo recomendado de testes:

1. Criar Paciente
2. Criar Médico
3. Criar Convênio
4. Criar Consulta
5. Criar Receita
6. Criar Prontuário

---

## 📌 Exemplo de Requisição com DTO

### Criar Paciente

```json
{
  "nome": "Matheus",
  "idade": 25
}
```

### Resposta

```json
{
  "id": 1,
  "nome": "Matheus",
  "idade": 25
}
```

---

## 📚 Conceitos Aplicados

* Arquitetura em camadas
* API REST
* CRUD completo
* DTO (Data Transfer Object)
* Validação de dados
* Injeção de dependência
* Relacionamentos com JPA/Hibernate
* Conversão Entity ↔ DTO
* Tratamento de Erros

---

## 👨‍💻 Autor

Desenvolvido por Matheus Leone.

---

## 📄 Licença

Este projeto é destinado exclusivamente para fins acadêmicos.
