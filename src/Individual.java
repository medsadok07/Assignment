import java.util.ArrayList;

import org.json.simple.JSONObject;


public class Individual {
String name;
String type;
JSONObject jsonObj;
ArrayList<Property> properties;
static ArrayList <Individual> individuals=new ArrayList<Individual>();

@Override
public String toString() {
	return "Individual [name=" + name + "]";
}




public Individual(String name, String type) {
	super();
	this.name = name;
	this.type = type;
	Individual.individuals.add(this);
}


public Individual(String name2, String equivalent, ArrayList<Property> properties2) {
	// TODO Auto-generated constructor stub
	super();
	this.name = name2;
	this.type = equivalent;
	this.properties= properties2;
	Individual.individuals.add(this);
}




public Individual(String name, String type, JSONObject jsonObj,
		ArrayList<Property> properties) {
	super();
	this.name = name;
	this.type = type;
	this.jsonObj = jsonObj;
	this.properties = properties;
	Individual.individuals.add(this);

}


}
