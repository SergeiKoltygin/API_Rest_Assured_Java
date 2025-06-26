package com.exemple.spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.notNullValue;

public class Specification {

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void installSpec(RequestSpecification reqSpec, ResponseSpecification respSpec) {
        RestAssured.requestSpecification = reqSpec;
        RestAssured.responseSpecification = respSpec;
    }

    public static ResponseSpecification successSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("token", notNullValue())
                .build();
    }

    public static ResponseSpecification errorSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectBody("error", notNullValue())
                .build();
    }
}

