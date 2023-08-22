package api.com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class ReadTestData {

	public static JSONObject getJsonData() throws IOException, ParseException
	{
		//pass the path of the testdata.json file
		File filename=new File("Resources/TestData/TestData.json");
		//convert json file into string
		String json = FileUtils.readFileToString(filename,"UTF-8");
		//parse the string into Object
		Object obj=new JSONParser().parse(json);
		//give jsonobject that I can return it to the function everytime it get called
		JSONObject jsonObject=(JSONObject)obj;
		return jsonObject;
		
	}
	public static String  getTestData(String keyname) throws IOException, ParseException
	{
		String testdata;
		return testdata = (String)getJsonData().get(keyname);
	}
}
