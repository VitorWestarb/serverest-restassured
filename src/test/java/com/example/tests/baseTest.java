package com.example.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class baseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.useRelaxedHTTPSValidation();
    }
}
