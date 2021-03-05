package exemplos.palestra;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class LoginTest {
    @BeforeEach
    public void setup() {
        baseURI = "http://localhost";
        port = 3000;
    }

    @Test
    public void deveFazerLoginPassandoOBodyComoString() {
        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                "  \"email\": \"fulano@qa.com\",\n" +
                "  \"password\": \"teste\"\n" +
                "}")
            .when()
            .post("/login")
            .then()
            .statusCode(200);
    }

    @Test
    public void deveFazerLoginPassandoBodyComoArquivo() {
        given()
            .contentType(ContentType.JSON)
            .body(new File("src/test/resources/login.json"))
        .when()
            .post("/login")
        .then()
            .statusCode(200);
    }

    @Test
    public void deveFazerLoginUsandoPojoSemLombok() {
        LoginBodySemLombok body = new LoginBodySemLombok();
        body.setEmail("fulano@qa.com");
        body.setPassword("teste");

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/login")
        .then()
            .statusCode(200);
    }

    @Test
    public void deveFazerLoginUsandoPojoComLombok() {
        LoginBodyComLombok body = new LoginBodyComLombok();
        body.setEmail("fulano@qa.com");
        body.setPassword("teste");

        given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/login")
        .then()
            .statusCode(200);
    }
}
