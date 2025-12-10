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

🛠️ Como rodar o projeto na sua máquina
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/api-serverest-tests.git

2️⃣ Acessar o projeto
cd api-serverest-tests

3️⃣ Rodar o teste principal
mvn test -Dtest=ServerestE2ETest

4️⃣ Rodar todos os testes
mvn test

▶ Exemplo de Execução

Ao rodar os testes, você verá algo como:

Usuário admin criado com sucesso
Login realizado
Produto criado
Produto encontrado via GET
Teste finalizado com sucesso ✔