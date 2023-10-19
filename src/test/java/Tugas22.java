
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class Tugas22 {
    private final String apiKey = "b0389f34292bf3b2b17fe0267559df45"; // Gantilah dengan kunci API yang valid.
    private final String apiToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMDM4OWYzNDI5MmJmM2IyYjE3ZmUwMjY3NTU5ZGY0NSIsInN1YiI6IjY1MmZhZGZjZWE4NGM3MDEyZDcxZmI4NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.h4z3YkHKEP1FMRuXzGspIAQe8MsKGMqsRNixp5Rcf4Q";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";
    }

    @Test
    public void testPlayingNow() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .when()
                .get("/movie/now_playing");

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test
    public void TestPopular() {
        Response response = RestAssured
                .given()
                .queryParam("api_key", apiKey)
                .when()
                .get("/movie/popular");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testPost() {
        JSONObject request = new JSONObject();
        request.put("value",85);
        System.out.println(request.toJSONString());
        Response response = RestAssured
        .given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/movie/ + movieId + /rating");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    }
