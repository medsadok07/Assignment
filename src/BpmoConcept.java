import java.util.ArrayList;


public class BpmoConcept {
 String name;
 String type;
 ArrayList <Property> properties ;
 ArrayList <String> epcEquivalents;
 ArrayList <String> bpmnEquivalents;
 
public BpmoConcept(String type, ArrayList<Property> properties,
		ArrayList<String> epcEquivalents, ArrayList<String> bpmnEquivalents) {
	super();
	this.name=null;
	this.type = type;
	this.properties = properties;
	this.epcEquivalents = epcEquivalents;
	this.bpmnEquivalents = bpmnEquivalents;
}

public BpmoConcept(String name, String type, ArrayList<Property> properties,
		ArrayList<String> epcEquivalents, ArrayList<String> bpmnEquivalents) {
	super();
	this.name = name;
	this.type = type;
	this.properties = properties;
	this.epcEquivalents = epcEquivalents;
	this.bpmnEquivalents = bpmnEquivalents;
}

public BpmoConcept(String type, ArrayList<Property> properties) {
	super();
	this.type = type;
	this.properties = properties;
}

@Override
public String toString() {
	return "BpmoConcept [name=" + name + ", type=" + type + ", properties="
			+ properties + ", epcEquivalents=" + epcEquivalents
			+ ", bpmnEquivalents=" + bpmnEquivalents + "]";
}

 
}
