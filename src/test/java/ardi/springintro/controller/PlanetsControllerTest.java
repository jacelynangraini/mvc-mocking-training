package ardi.springintro.controller;

import ardi.springintro.SpringIntroApplication;
import ardi.springintro.model.Person;
import ardi.springintro.model.Planet;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringIntroApplication.class)
@AutoConfigureWebTestClient
class PlanetsControllerTest {

  @Autowired
  WebTestClient client;

  static MockWebServer mockWebServer;

  @BeforeAll
  static void beforeAll() throws Exception{
    mockWebServer = new MockWebServer();
    mockWebServer.start(10001);

    mockWebServer.setDispatcher(new Dispatcher() {
      @Override
      public MockResponse dispatch(RecordedRequest recordedRequest) throws InterruptedException {
        MockResponse mockResponse = new MockResponse();
        mockResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        mockResponse.setResponseCode(200);
        String filePath="";
        System.out.println("===========" +recordedRequest.getRequestLine()+"=============");
        try {
          switch (recordedRequest.getPath()){
            case "/planets":
              filePath = "src/test/resources/jsonResponse/planetsResponse.json";
              break;
            case "/planets/1":
              filePath = "src/test/resources/jsonResponse/planetResponse.json";
              break;
          }
          System.out.println(filePath);
          FileInputStream fileInputStream = new FileInputStream(filePath);
          String content = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());
          mockResponse.setBody(content);
        } catch (Exception e) {
          System.out.println("ERRORRR" + e.getMessage());
        }

        return mockResponse;
      }
    });
  }

  @AfterAll
  public static void afterAll() throws Exception {
    mockWebServer.shutdown();
  }

  @Test
  public void getPlanetsTest(){
    List<Planet> response = client.get()
        .uri("/planets")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(new ParameterizedTypeReference<List<Planet>>() {})
        .returnResult()
        .getResponseBody();

    System.out.println(response);

    assertNotNull(response);
    assertTrue(response.size() > 0);
    assertEquals("Tatooine", response.get(0).getName());

  }

  @Test
  public void getPlanetTest() {
    Planet response = client.get()
        .uri("/planets/1")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(new ParameterizedTypeReference<Planet>() {})
        .returnResult()
        .getResponseBody();

    assertNotNull(response);
    assertEquals("Tatooine", response.getName());
    assertEquals("arid", response.getClimate());
    assertEquals("desert", response.getTerrain());
  }


}