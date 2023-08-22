package api.com.tests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import api.com.mis.Uri;
import api.com.util.ExtentReport;
import api.com.util.Helper;
import api.com.util.ReadTestData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import io.restassured.response.Response;

public class apiTestScript extends Uri{


@Test(description="Validate the status code for Post users endpoint",groups="RegressionSuit")
public void validatestatusCodeGetUsers() throws IOException, ParseException {
	//System.out.println("*********"+ReadTestData.getTestData("uriGetUsers"));
			//System.out.println(Helper.propertyReader("qaBaseUrl"));
			//System.out.println(Helper.propertyReader("qaBaseUrldev"));
	
	ExtentReport.extentlog=ExtentReport.extentreport.startTest("validatestatusCodeGetUsers",
			"Validate the status code for GET users endpoint");
	
	
	
	//Response resp=given().when().get(ReadTestData.getTestData("uriGetUsers"));
	System.out.println(getUri());

	Response resp=given().when().get(getUri());
	int actualstatuscode = resp.statusCode();

	assertEquals(actualstatuscode,200 );
	resp.body().asString();
	//String actualvalue01=resp.path("data[1].email");
	//System.out.println(actualvalue01);
	//assertEquals(actualvalue01,ReadTestData.getTestData("expectedEmail") );
//	System.out.println(ReadTestData.getTestData("expectedEmail"));
	int actualvalue = resp.path("total");
	System.out.println(actualvalue);
	assertEquals(actualvalue, 12);
	Object actualvalue1 = resp.path("support.url");
	assertEquals(actualvalue1, "https://reqres.in/#support-heading");
}


}
