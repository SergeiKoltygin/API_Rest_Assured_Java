package in.reqres;

import com.exemple.dto.people.ResourceDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static com.exemple.spec.Specification.requestSpec;
import static com.exemple.spec.Specification.*;

public class UserAvatarTest {

    @Test
    public void avatarsShouldBeUnique() {
        installSpec(requestSpec(), responseSpec200());
        ResourceDto resourceDto = given()
                .when()
                .header("x-api-key", "reqres-free-v1")
                .get("/api/users?page=2")
                .then()
                .extract().as(ResourceDto.class);

        List<String> avatarName = resourceDto.getData().stream()
                .map(user -> user.getAvatar().substring(user.getAvatar().lastIndexOf("/") + 1))
                .collect(Collectors.toList());

        long uniqueNameCount = avatarName.stream()
                .distinct().count();

        Assert.assertEquals(uniqueNameCount, avatarName.size(), "Имеются дубликаты имен аватаров в списке: " + avatarName);
    }
}

