package oscilloscope.JSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JSONReader {
	
	public static List<Float> arrX = new ArrayList<Float>();
	public static List<Float> arrY = new ArrayList<Float>();
	public static List<String> arrObj = new ArrayList<String>();
	public static String path = "D:\\temp\\drawing.json";
	
	@SuppressWarnings("rawtypes")
	public static void init() {
		  JSONParser parser = new JSONParser();
		   try {		          FileReader fr=new FileReader(path);    
		          BufferedReader br=new BufferedReader(fr);    
				 JSONArray full = (JSONArray) parser.parse(br); 				 
 				 for(int i = 0; i < full.size(); i++) {
 					 for(int j = 0; j < ((ArrayList) full.get(i)).size(); j++) {
 						JSONArray currentLine = (JSONArray) full.get(i);
 						JSONObject currentPoint = (JSONObject) currentLine.get(j);
 						arrX.add(Float.parseFloat(currentPoint.get("x").toString()));
 						arrY.add(Float.parseFloat(currentPoint.get("y").toString()));
 						if(j==((ArrayList) full.get(i)).size()-1) {
 							arrObj.add("n");
 						}else{
 							arrObj.add("f");
 						}
 						
 					 }
 				 }
				 

				 
				 
				 
				 
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
