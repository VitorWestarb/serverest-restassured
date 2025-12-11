# 🧪 Testes Automatizados de API – REST Assured + JUnit

Projeto desenvolvido para automação dos endpoints **GET /produtos** e **POST /produtos** da API pública [Serverest](https://serverest.dev/).

O objetivo é validar o fluxo essencial de criação e consulta de produtos, garantindo o funcionamento básico das operações.

---

## 🚀 Tecnologias utilizadas
- Java 17+
- Maven
- JUnit 5
- REST Assured
- Hamcrest

---

## 📂 Arquivo principal
O teste está localizado em:

src/test/java/com/example/tests/ServerestE2ETest.java


---

## 📌 Cenários Automatizados

### ✔ Cenário Único – Fluxo Completo (E2E de API)
O teste realiza automaticamente:

1. **Cadastro de usuário administrador**
2. **Login e criação de token**
3. **Criação de um novo produto**
4. **Consulta do produto via GET /produtos/{id}**

Esse cenário garante que o fluxo essencial esteja funcionando e que o endpoint responda corretamente.

---

## 🛠️ Como rodar o projeto na sua máquina

1️⃣ Clonar o repositório  
```bash
git clone https://github.com/VitorWestarb/serverest-restassured.git
```

2️⃣ Acessar o projeto  
```bash
cd api-serverest-tests
```

3️⃣ Rodar o teste principal  
```bash
mvn test -Dtest=ServerestE2ETest
```

4️⃣ Rodar todos os testes  
```bash
mvn test
```
---

▶ Exemplo de Execução

```
Usuário admin criado com sucesso
Login realizado
Produto criado
Produto encontrado via GET
Teste finalizado com sucesso ✔
```
---


📄 Observações importantes

A API Serverest é pública. Os dados podem ser resetados a qualquer momento.

Para evitar erro de "produto já existente", os nomes, emails e IDs são gerados dinamicamente.

O cenário é totalmente independente e pode ser executado várias vezes sem impacto.
