package com.gateway.autodns;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class TagCountTest {

    @Test
    public void XMLContains15tagsTest() {
        Response response = given()
                .when()
                .get("https://gateway.autodns.com")
                .then()
                .extract().response();

        String responseBody = response.getBody().asString();

        Pattern pattern = Pattern.compile("<([a-zA-Z0-9]+)[^>]*>");
        Matcher matcher = pattern.matcher(responseBody);

        int tagCount = 0;
        while (matcher.find()) {
            tagCount++;
        }

        Assert.assertEquals(tagCount, 15, "Ожидалось 15 XML-тегов, а получили " + tagCount);
    }
}

