package org.acme.quickstart;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
@QuarkusTestResource(H2DatabaseTestResource.class)
public class GreetingResourceTest {

    @Test
    public void testEmptyContador() {
        given()
          .when()
            .get()
          .then()
             .statusCode(200)
             .body(is("Listado:" + System.lineSeparator()));
    }

    @Test
    public void testContador1() {
        given().
            get( "/Edu" );

        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is("Listado:" + System.lineSeparator() + "Edu: 1" ));
    }

}