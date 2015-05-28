import java.util.ArrayList;

import org.json.simple.JSONObject;


public class Principale {
	
	static String filePath_BPaaS1="src/signavioFiles/BPaaS1.signavio.xml";
	static String filePath_BPaaS2="src/signavioFiles/BPaaS2.signavio.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String type =xmlReader.typeDiagramme(filePath_BPaaS2);
		System.out.println("type,"+type);
		String JsonText =xmlReader.recuperationJsonText(filePath_BPaaS2);
		ArrayList<JSONObject> Individuals=jsonAnalyseur.extractIndividuals(JsonText);
	    owlCreator.main(Individuals,type);
		
	}

}
