package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.EndPoints;
import tek.tdd.base.ApiTestsBase;

public class GetPrimaryAccountTest extends ApiTestsBase {
    @Test
    public void getAccountAndValidate() {
        RequestSpecification requestSpecification = getDefaultRequest();
        requestSpecification.queryParam("primaryPersonId", "10035");
        Response response = requestSpecification.when().get(EndPoints.GET_PRIMARY_ACCOUNT.getValue());
        response.then().statusCode(200);
        response.prettyPrint();

        //to validate email
        String actualEmail = response.jsonPath().getString("email");
        ExtentTestManager.getTest().info(response.asPrettyString());//use for reports
        Assert.assertEquals(actualEmail, "jawid776@gmail.com");
    }
    //Activity Sending request to get-primary-account with id does not exist. validate Error message
    @Test
    public void ValidateGetAccountNotExist(){
        String errorMessage = getDefaultRequest()
                .queryParam("primaryPersonId","252525")
                .when().get(EndPoints.GET_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(404)
                .extract()
                .response()
                .jsonPath().getString("errorMessage");
        Assert.assertEquals(errorMessage,"Account with id 252525 not exist");
    }


}

