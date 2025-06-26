package in.reqres;

import com.exemple.dto.colors.ResourceListResponse;
import com.exemple.dto.colors.ColorResource;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static com.exemple.spec.Specification.*;

public class ResourceListSortedTest {

    @Test
    public void resourceListShouldBeSortedByYear() {
        installSpec(requestSpec(), responseSpec200());
        ResourceListResponse response = given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("/api/unknown")
                .then()
                .extract().as(ResourceListResponse.class);

        List<Integer> actualYears = response.getData()
                .stream()
                .map(ColorResource::getYear)
                .collect(Collectors.toList());

        List<Integer> sortedYears = actualYears.stream()
                .sorted()
                .collect(Collectors.toList());

        assertEquals(actualYears, sortedYears, "Список ресурсов не отсортирован по годам по возрастанию: " + actualYears);
    }
}
