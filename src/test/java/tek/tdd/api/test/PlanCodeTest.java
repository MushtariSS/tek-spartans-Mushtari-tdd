package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.EndPoints;
import tek.tdd.api.models.PlanCodeList;
import tek.tdd.api.models.PlanCodeResponse;
import tek.tdd.api.models.TokenRequest;
import tek.tdd.base.ApiTestsBase;

import java.util.List;

public class PlanCodeTest extends ApiTestsBase {
    @Test
    public void validatePlanCode(){
        TokenRequest tokenRequest = new TokenRequest("supervisor","tek_supervisor");
        String token = getDefaultRequest()
                .body(tokenRequest)
                .when()
                .post(EndPoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract()
                .response()
                .jsonPath().getString("token");


         Response response = getDefaultRequest()
                 .header("Authorization","Bearer " +  token)
                 .when()
                 .get(EndPoints.GET_ALL_PLAN_CODE.getValue())
                 .then().statusCode(200)
                 .extract()
                 .response();
         ExtentTestManager.getTest().info(response.prettyPrint());
         List<PlanCodeResponse> planCode = response.body().jsonPath().getList("", PlanCodeResponse.class);
          Assert.assertNotNull(planCode);
          Assert.assertTrue(planCode.size()==4);



    }
}
