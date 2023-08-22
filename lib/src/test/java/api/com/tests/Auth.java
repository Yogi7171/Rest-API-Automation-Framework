package api.com.tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import io.restassured.response.Response;
public class Auth {
	@Test(description="Validate the status code for Basic Authentication")
	
	public void BasicAuth() {
	Response resp = given()
    .auth()
    .basic("sid", "sid").when().get("https://reqres.in/api/users/2");
	}
	@Test
	public void Preemptive()
	{
		Response resp1 = given()
						.auth().preemptive().basic("sid", "sid")
						.when().get("https://reqres.in/api/users/2");
	}
	@Test
	public void digestAuth()
	{
		Response resp2 = given()
						 .auth()
						 .digest("sid", "sid").when().get("https://reqres.in/api/users/2");
     
	}
	@Test
	public void Oauth2()
	{
		 Response resp3 = given().
				 auth().oauth2("").when().get("https://reqres.in/api/users/2");
				 		  
	}
	@Test
	public void Oauth() 
	{
		 Response resp4 = given()
	                .auth()
	                .oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
	                .when().get("https://reqres.in/api/users/2");
		
		
	}
	@Test
	public void headerOauth2()
	{
		Response resp5=given().header("Authorization","accessToken")
				.when().get("https://reqres.in/api/users/2");
	}
	
}
