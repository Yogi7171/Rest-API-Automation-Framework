package api.com.mis;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import api.com.util.Helper;
import api.com.util.ReadTestData;

public class Uri {
	public static String getUri() throws IOException, ParseException
	{
		 String uri = Helper.propertyReader("Qaserver")+ReadTestData.getTestData("endpointGetuser");
		return uri;
	}
}
