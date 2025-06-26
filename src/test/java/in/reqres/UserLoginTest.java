package in.reqres;

import com.exemple.dto.userAuthorization.ErrorResponse;
import com.exemple.dto.userAuthorization.LoginRequest;
import com.exemple.dto.userAuthorization.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertNotNull;
import static com.exemple.spec.Specification.*;

public class UserLoginTest {

    @Test(dataProvider = "validLoginData", dataProviderClass = com.exemple.dataProvider.LoginDataProvider.class)
    public void successfulLoginTest(String email, String password) {
        installSpec(requestSpec(), responseSpec200());
        LoginRequest request = new LoginRequest(email, password);

        LoginResponse response = given()
                .header("x-api-key", "reqres-free-v1")
                .body(request)
                .when()
                .post("/api/login")
                .then()
                .spec(successSpec())
                .extract()
                .as(LoginResponse.class);

        assertNotNull(response.getToken(), "Token должен быть не null");

    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = com.exemple.dataProvider.LoginDataProvider.class)
    public void failedLoginTest(String email, String password) {
        installSpec(requestSpec(), errorSpec());

        LoginRequest request = new LoginRequest(email, password);

        ErrorResponse response = given()
                .header("x-api-key", "reqres-free-v1")
                .body(request)
                .when()
                .post("/api/login")
                .then()
                .spec(errorSpec())
                .extract()
                .as(ErrorResponse.class);

        Assert.assertEquals("Missing password", response.getError(), "Ошибка не соответствует ожидаемой");
    }
}

