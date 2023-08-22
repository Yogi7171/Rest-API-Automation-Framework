package api.com.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import api.com.core.BaseTest;
import api.com.pojo.Car;
import api.com.pojo.pojoComplex;
import api.com.util.ExtentReport;
import io.restassured.response.Response;

public class TestingPostMethod extends BaseTest {
@Test(description="Chcecking complex pojo",groups="RegressionSuit")
public void complexpojo()
	{
	ExtentReport.extentreport.startTest("TC-001:GETHEADER","validate the status code");
	Car car=new Car();
	car.setModel("Civic Touring");
	car.setName("New Honda");
	
	Car car1=new Car();
	car1.setModel("Camry SE");
	car1.setName("Toyota");

	List<Car>carlist=new ArrayList<Car>();
	carlist.add(car);
	carlist.add(car1);
	
	pojoComplex x = new pojoComplex();
	x.setCar(carlist);
	Response resp=given().header("Content-Type","application/json").body(x).
			  when().post("https://reqres.in/api/users");
	System.out.println(resp.body().asString());
	}
}
