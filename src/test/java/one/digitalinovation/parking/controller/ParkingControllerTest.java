package one.digitalinovation.parking.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {

  @LocalServerPort
  private int randomPort;

  @BeforeEach
  public void setUpTest(){
    RestAssured.port = randomPort;
  }

  @Test
  void whenFindAllThenCheckResult(){
    RestAssured.given()
      .when()
      .get("/parkings")
      .then()
      .statusCode(200)
      .body("license[0]", Matchers.equalTo("WAS-1234"));
  }
}
