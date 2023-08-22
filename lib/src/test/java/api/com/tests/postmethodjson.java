package api.com.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.Test;

import api.com.core.BaseTest;
import api.com.pojo.citymodel;
import api.com.pojo.pojoTry;
import api.com.util.ExtentReport;
import io.restassured.response.Response;

public class postmethodjson extends BaseTest {
	@Test(description="Validate the status code for Post users endpoint",groups="RegressionSuit")
	public void validatestatusCodeGetUsers() throws IOException  
	{
		//File filepath=new File("C:\\Users\\chauh\\Java\\ApiAutomation\\lib\\Resources\\TestData\\postmethodrequest.json");	
	//	FileInputStream file=new FileInputStream(filepath);
		
		ExtentReport.extentlog = ExtentReport.extentreport.startTest("Execute post method",
				" validate post method");

		List<String> lst=new ArrayList<String>();
		lst.add("tester");
		lst.add("Devloper");
		lst.add("support");
		citymodel citybang=new citymodel();
		citybang.setName("banglore");
		citybang.setTemperature("30");

		citymodel citydelhi=new citymodel();
		citydelhi.setName("delhi");
		citydelhi.setTemperature("40");
		
		List<citymodel>city=new ArrayList<citymodel>();
		city.add(citybang);
		city.add(citydelhi);
		
		pojoTry pojobody = new pojoTry();
		//pojobody.setJob("Engineer");
		//pojobody.setName("Kumar");
		//pojobody.setJobs(lst);
		pojobody.setCitymodels(city);
		Response resp=given().header("Content-Type","application/json").body(pojobody).
					  when().post("https://reqres.in/api/users");
					 
				System.out.println(resp.getStatusCode());
				System.out.println(resp.body().asString());
				
		
	}
	
}	
 
