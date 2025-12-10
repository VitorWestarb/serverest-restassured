package com.example.tests;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthHelper {
    public static String getToken(String email, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        Response r = given()
            .contentType("application/json")
            .body(body)
        .when()
            .post("/login") // ajuste se endpoint for diferente
        .then()
            .statusCode(200)
            .extract().response();

        // Supondo que token venha em r.jsonPath().getString("token") — ajuste conforme resposta real
        return r.jsonPath().getString("token");
    }
}
