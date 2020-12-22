package ProvaGetnet;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProvaGetnet extends BaseTest {

    @Test
    public void deveValidarInformacoesUsuario(){

        given()
                .log().all()
        .when()
                .get("/api/users/10")
        .then()
                .statusCode(200)
                .body("data.email",is("byron.fields@reqres.in"))
                .body("data.first_name",is("Byron"))
                .body("data.last_name",is("Fields"))
                .body("data.id",is(10));
    }

    @Test
    public void deveIncluirUsuario(){

        given()
                .body("{\"name\": \"Jonathan\", \"job\": \"doctor\"}")
                .log().all()
        .when()
                .post("/api/users")
        .then()
                .statusCode(201);
    }

    @Test
    public void deveAlterarUsuario(){

        given()
                .body("{\"name\": \"Jotaro\", \"job\": \"fighter\"}")
                .log().all()
        .when()
                .put("/api/users/10")
        .then()
                .statusCode(200);
    }


    @Test
    public void deveDeletarUsuario(){

        given()
                .log().all()
        .when()
                .delete("/api/users/2")
        .then()
                .statusCode(204);
    }


}
