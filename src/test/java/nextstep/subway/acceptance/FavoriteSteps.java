package nextstep.subway.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.Map;

public class FavoriteSteps {

    public static ExtractableResponse<Response> 즐겨찾기_생성_요청(String accessToken, Long source, Long target) {
        Map<String, Long> params = Map.of("source", source, "target", target);

        return RestAssured
                .given().log().all()
                .auth().oauth2(accessToken)
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().post("/favorites")
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 즐겨찾기_조회_요청(String accessToken, Long id) {
        return RestAssured
                .given().log().all()
                .auth().oauth2(accessToken)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("/favorites/{id}", id)
                .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 즐겨찾기_삭제_요청(String accessToken, Long id) {
        return RestAssured.given().log().all()
                .auth().oauth2(accessToken)
                .when().delete("/favorites/{id}", id)
                .then().log().all().extract();

    }
}
