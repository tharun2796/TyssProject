package sms_practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonData {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// Parse the JSON file
		JSONParser jp= new JSONParser();
		Object obj = jp.parse(new FileReader("./src/test/resources/data/jsondata.json"));
		
		//Downcast the obj to JsonObject
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}

}
