package exemplos.posts;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

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
    public void deveFazerLoginUsandoPojo() {
        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setEmail("fulano@qa.com");
        loginRequestBody.setPassword("teste");

        given()
            .contentType(ContentType.JSON)
            .body(loginRequestBody)
        .when()
            .post("/login")
        .then()
            .statusCode(200);
    }
}
