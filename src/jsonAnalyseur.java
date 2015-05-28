//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.simple.JSONValue;
//import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class jsonAnalyseur {
	public static ArrayList <JSONObject> Child;//childshapes
	
	public static ArrayList <String> extractOutgoingId(JSONObject B) {
		
		JSONArray array = (JSONArray) B.get("outgoing");
		ArrayList <String> AL = new ArrayList<String>();
		 int n = array.size();
		  
		  for (int i = 0; i < n; i++) {
		      final JSONObject outgoing = (JSONObject)array.get(i);
		      AL.add((String) outgoing.get("resourceId"));
		    }
		return AL;
		
		
	}
	public static ArrayList <String> extractIngoingId(JSONObject B) {
		int n=Child.size();
		ArrayList <String> inter = new ArrayList<String>();
		ArrayList <String> resultat = new ArrayList<String>();
		
		for(int i=0;i<n;i++){
			inter.clear();
			inter=extractOutgoingId(Child.get(i));
			System.out.println("inter  "+inter);
			for(int j=0;j<inter.size();j++){
				
				if(inter.get(j).equals(B.get("resourceId"))){
					resultat.add(Child.get(i).get("resourceId").toString());
				}
			}
		}
		return resultat;
	}
	
	
	
	public static int getByResourceId (String id){
		
		int j=0;
		while(!Child.get(j).get("resourceId").toString().equalsIgnoreCase(id) && j<Child.size()-1 ){
			j++;
		}
			
		return j;//Child.get(j);
		
	}
	
	
	public static String getName(int i){
		JSONObject O1 = Child.get(i);
		JSONObject O2 =(JSONObject) O1.get("properties");
		return O2.get("name").toString();
	//methode vérifiée
	} 
	
	
public static String getResouceId(int i){
		return Child.get(i).get("resourceId").toString();
	} 
	
	
	
	
	
	public static ArrayList<JSONObject> extractIndividuals(String J){
		ArrayList <JSONObject> AL = new ArrayList<JSONObject>();
	try{
	  JSONParser parser = new JSONParser();
	  JSONObject obj = (JSONObject) parser.parse(J);
	  JSONArray array = (JSONArray)obj.get("childShapes");
	  
	  int n = array.size();
	  AL.add(obj);
	  
	  for (int i = 0; i < n; i++) {
	      final JSONObject individual = (JSONObject)array.get(i);
	      AL.add(individual);
	    }
	  
	  Child=AL;
	  Child.remove(0);
	  System.out.println("resourceId :     "+getResouceId(1));
      
	  return AL;	
	}
		
		   

		catch(ParseException pe){
	     System.out.println("position: " + pe.getPosition());
		     System.out.println(pe);
		     return AL;
	   }
	    
    //fin de main   
	}




//fin de la classe
}
