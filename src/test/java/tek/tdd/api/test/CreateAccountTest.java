package tek.tdd.api.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import org.testng.Assert;
import tek.tdd.api.models.AccountResponse;
import tek.tdd.api.models.AddAcountRequest;
import tek.tdd.api.models.EndPoints;
import tek.tdd.base.ApiTestsBase;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTest extends ApiTestsBase {
    //Create valid account/add/primary/account
    //verify status code is 201
    //use POJO to request body

    public void createNewAccountTest(){
        String randomEmail = DataGenerator.generateRandomEmail("instructor");
        AddAcountRequest request = AddAcountRequest.builder()
                .email(randomEmail)
                .firstName("Muhammad")
                .lastName("Shokriyan")
                .title("Mr.")
                .gender("MALE")
                .maritalStatus("single")
                .dateOfBirth("1990-12-01")
                .employmentStatus("QA")
                .build();
        Response response = getDefaultRequest()
                .body(request)
                .when()
                .post(EndPoints.GET_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(202)
                .extract()
                .response();
        response.prettyPrint();
        ExtentTestManager.getTest().info(response.asPrettyString());
        AccountResponse accountResponse= response.jsonPath().getObject("", AccountResponse.class);
        Assert.assertNotNull(accountResponse);
    }
   //send request to api-token with valid credentials

}
