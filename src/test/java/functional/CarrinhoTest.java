package functional;

import io.restassured.http.ContentType;
import models.LoginRequestBody;
import models.LoginResponseBody;
import models.Produto;
import models.RequestCarrinhoBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class CarrinhoTest {

    String token;

    @BeforeEach
    public void setup() {
        baseURI = "http://localhost";
        port = 3000;

        LoginRequestBody loginRequestBody = new LoginRequestBody();
        loginRequestBody.setEmail("fulano@qa.com");
        loginRequestBody.setPassword("teste");

        LoginResponseBody resposta = given()
            .contentType(ContentType.JSON)
            .body(loginRequestBody)
            .when()
            .post("/login")
            .then()
            .statusCode(200)
            .extract().as(LoginResponseBody.class);

        token = resposta.getAuthorization();
    }

    @AfterEach
    public void teardown() {
        given()
            .contentType(ContentType.JSON)
            .header("Authorization", token)
        .when()
            .delete("/carrinhos/cancelar-compra")
        .then()
            .statusCode(200);
    }

    @Test
    public void deveCadastrarUmCarrinho() {
        Produto produto = new Produto();
        produto.setQuantidade(1);
        produto.setIdProduto("BeeJh5lz3k6kSIzA");

        List<Produto> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(produto);

        RequestCarrinhoBody requestCarrinhoBody = new RequestCarrinhoBody();
        requestCarrinhoBody.setProdutos(listaDeProdutos);

        given()
            .log().all()
            .header("Authorization", token)
            .contentType(ContentType.JSON)
            .body(requestCarrinhoBody)
        .when()
            .post("http://localhost:3000/carrinhos")
        .then()
            .assertThat()
            .statusCode(201);
    }

    @Test
    public void deveCadastrarUmCarrinhoComBuilder() {
//        RequestCarrinhoBody requestCarrinhoBody2 =
//            RequestCarrinhoBody.builder()
//                .produtos(Arrays.asList(
//                    Produto.builder()
//                    .idProduto("BeeJh5lz3k6kSIzA")
//                    .quantidade(1)
//                    .build()))
//                .build();

//      Cria o builder de produto
        Produto produto = Produto.builder().idProduto("BeeJh5lz3k6kSIzA").quantidade(1).build();
//      Cria o builder de produto
        Produto produto2 = Produto.builder().idProduto("idDoNovoProduto").quantidade(1).build();

//        Cria o builder de requestCarrinhoBody
        RequestCarrinhoBody requestCarrinhoBody = RequestCarrinhoBody.builder()
            .produto(produto)
            .produto(produto2)
        .build();

        given()
            .log().all()
            .header("Authorization", token)
            .contentType(ContentType.JSON)
            .body(requestCarrinhoBody)
        .when()
            .post("/carrinhos")
        .then()
            .log().all()
            .assertThat()
            .statusCode(201);
    }
}
