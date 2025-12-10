package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ServerestE2ETest {

    @Test
    public void deveListarProdutoCriado() {

        RestAssured.baseURI = "https://serverest.dev";
        System.out.println("=== INICIANDO TESTE E2E: CRIAR + LISTAR PRODUTO ===");

        // --- 1) Criar admin ---
        String email = "adminGetProduto" + System.currentTimeMillis() + "@test.com";

        given()
            .contentType(ContentType.JSON)
            .body("{\"nome\":\"Admin QA\",\"email\":\"" + email + "\",\"password\":\"1234\",\"administrador\":\"true\"}")
        .when()
            .post("/usuarios")
        .then()
            .statusCode(201);

        System.out.println("✔ Usuário admin criado: " + email);

        // --- 2) Login ---
        String token =
                given()
                    .contentType(ContentType.JSON)
                    .body("{\"email\":\"" + email + "\",\"password\":\"1234\"}")
                .when()
                    .post("/login")
                .then()
                    .statusCode(200)
                    .extract()
                    .path("authorization");

        if (!token.startsWith("Bearer ")) token = "Bearer " + token;

        System.out.println("✔ Token obtido: " + token);

        // --- 3) Criar produto ---
        String nomeProduto = "Produto GET QA " + System.currentTimeMillis();
        System.out.println("➡ Criando produto: " + nomeProduto);

        var responseProduto =
                given()
                    .log().all()
                    .header("Authorization", token)
                    .contentType(ContentType.JSON)
                    .body("{\"nome\":\"" + nomeProduto + "\",\"preco\":500," +
                            "\"descricao\":\"Teste GET\",\"quantidade\":10}")
                .when()
                    .post("/produtos")
                .then()
                    .log().all()
                    .extract()
                    .response();

        int status = responseProduto.statusCode();
        System.out.println("STATUS DO POST /produtos: " + status);

        if (status != 201) {
            System.out.println("❌ ERRO AO CRIAR PRODUTO:");
            System.out.println(responseProduto.asString());
            throw new AssertionError("Erro ao criar produto. Status: " + status);
        }

        String idProduto = responseProduto.path("_id");
        System.out.println("✔ Produto criado com sucesso! ID: " + idProduto);

        // --- 4) GET produtos ---
        given()
            .log().all()
        .when()
            .get("/produtos/" + idProduto)
        .then()
            .log().all()
            .statusCode(200)
            .body("_id", equalTo(idProduto))
            .body("nome", equalTo(nomeProduto));

        System.out.println("✔ Produto encontrado na listagem!");
    }
}
