package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import groovyjarjarantlr4.runtime.Token;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.TokenRequest;
import tek.tdd.api.models.TokenResponse;
import tek.tdd.base.ApiTestsBase;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTests extends ApiTestsBase {
    public static final Logger LOGGER = LogManager.getLogger(TokenGenerationTests.class);

    //Create a test token with supervisor user
    @Test(dataProvider = "credentials")
    public void generateValidToken(String username, String password) {
        RequestSpecification requestSpecification = getDefaultRequest();
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        requestSpecification.body(body);

        //Send Request to api/token
        Response response = requestSpecification.when().post("/api/token");
        response.then().statusCode(200);

        //to access data in response body
        String actualUsername = response.body().jsonPath().getString("username");
        Assert.assertEquals(actualUsername, username, "Username should Match");
        String token = response.body().jsonPath().getString("token");
        Assert.assertNotNull(token);
        String accountType = response.body().jsonPath().getString("accountType");
        Assert.assertEquals(accountType, "CSR");
        LOGGER.info("response is {}", response.asPrettyString());
    }

    //Activity generate token with operator_user
    @DataProvider(name = "credentials")
    private String[][] credentials() {
        return new String[][]{
                {"supervisor", "tek_supervisor"},
                {"operator_readonly", "Tek4u2024"}

        };
    }

    //Activity Token generate with negative and validate error message and validate status code
    @Test(dataProvider = "negativeData")
    public void negativeTesting(String username, String password, int statusCode, String expectedErrorMessage) {
        RequestSpecification reques = getDefaultRequest();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);
        getDefaultRequest().body(requestBody);

        Response response = reques.when().post("/api/token");
        response.then().statusCode(statusCode);
        String actualErrorMessage = response.body().jsonPath().getString("Error Message");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @DataProvider(name = "negativeData")
    private Object[][] negativeData() {
        return new Object[][]{
                {"wrongUser", "tek_supervisor", 404, "User wrong not found"},
                {"supervisor", "wrongPassword", 400, "Password not matched"},
        };
    }
    @Test
    public void generateTokenUseObjAsBody(){
        RequestSpecification request = getDefaultRequest();
        TokenRequest requestBody =new TokenRequest("supervisor","tek_supervisor");
        request.body(requestBody);
        Response response = request.when().post(EndPoints.TOKEN.getValue());
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void convertResponseToPojo(){
        TokenRequest tokenRequest = new TokenRequest("supervisor","tek_supervisor");
        Response response = getDefaultRequest()
                .body(tokenRequest)
                .when().post(EndPoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract()
                .response();
        ExtentTestManager.getTest().info(response.asPrettyString());
        //Convert response body to POJO

        TokenResponse token = response.body().jsonPath().getObject("", TokenResponse.class);
        Assert.assertEquals(token.getUsername(),"supervisor");

    }
}

