import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.*;

import org.json.simple.JSONObject;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
//import com.github.jsonldjava.core.RDFDataset.IRI;


public class owlCreator {
	
	public static void main (ArrayList<JSONObject> A , String type) {
		  
		OWLDataFactory df = OWLManager.getOWLDataFactory();
        PrefixManager pm = new DefaultPrefixManager();
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        OWLOntology o;
      /*  for(int zeze=0;zeze<21;zeze++){
        System.out.println("testtttttttttttttttttttt : "+jsonAnalyseur.getTitle(zeze));
        }*/
      try{  
       IRI iri = IRI.create("http://example.com/BPaaS2");
       //File f=new File("src/bpmo/bpmo.owl");
       //o = m.loadOntologyFromOntologyDocument(f);
       //assertNotNull(o);
    
       
       pm.setPrefix("bpmo", "http://ip-super.org/ontologies/process/bpmo/v2.0.1#");
       o = m.createOntology(iri);
    	   
    		   int k = A.size();//nbre des JSONObject de la liste
    		   for(int i=0;i<k;i++){
    			   String S=(String)((JSONObject) A.get(i).get("stencil")).get("id");//S contiendra le stencil(type) du JSONObject courant
    			   System.out.println(i+","+S);
    			   int j =0;
    			   if(type.contains("EPC")) { //recherche d'equivalents bmpo des elements epc
    				   int map=Mapping.listeBpmoElement.size();
    				   boolean b=Mapping.listeBpmoElement.get(j).epcEquivalents.contains(S);
    				   while(!(b)&&(j<map))  {
    					  
    			    j++;
    			    b=Mapping.listeBpmoElement.get(j).epcEquivalents.contains(S);
    				   }
    				   
    				   String equivalent=Mapping.listeBpmoElement.get(j).type;//equivalent contiendra l'equivalent trouvé à j
					   boolean bool;
					   System.out.println(i+","+equivalent+", "+jsonAnalyseur.getTitle(i));// pour verifier le mapping
					    //boolean y=jsonAnalyseur.getTitle(i).equalsIgnoreCase("");
					    boolean t=jsonAnalyseur.getTitle(i)==null;
					   bool =  t; 
					    if(bool)
						   {//si l'element n'as pas de name comme les ControlFlowConnector
							   new Individual(""+equivalent+""+i,equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);//création d'un individual qu'on va par la suite créer
						       
						   }
						   else{ 
							   new Individual(jsonAnalyseur.getTitle(i),equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);
						   
						   }
    			   
    			   
    			   }
    			   else if (type.contains("BPMN")) {//recherche d'equivalents bmpo des elements bpmn
    				   while(!(Mapping.listeBpmoElement.get(j).bpmnEquivalents.contains(S))&&(j<Mapping.listeBpmoElement.size()-1))  {
    			    j++;
    				   }  
    		
    				   String equivalent=Mapping.listeBpmoElement.get(j).type;//equivalent contiendra l'equivalent trouvé à j
					   boolean bool;
					   System.out.println(i+","+equivalent+", "+jsonAnalyseur.getName(i));// pour verifier le mapping
					    bool = jsonAnalyseur.getName(i).equalsIgnoreCase("");
					    if(bool)
						   {//si l'element n'as pas de name comme les ControlFlowConnector
							   new Individual(""+equivalent+""+i,equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);//création d'un individual qu'on va par la suite créer
						       
						   }
						   else{ 
							   new Individual(jsonAnalyseur.getName(i),equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);
						   
						   }
    			   
    			   }
    			   
				/*	   String equivalent=Mapping.listeBpmoElement.get(j).type;//equivalent contiendra l'equivalent trouvé à j
					   boolean bool;
					   if(type.contains("EPC")){ System.out.println(i+","+equivalent+", "+jsonAnalyseur.getTitle(i));// pour verifier le mapping
					    bool = jsonAnalyseur.getTitle(i).equalsIgnoreCase(""); }
					  else {
					   System.out.println(i+","+equivalent+", "+jsonAnalyseur.getName(i));// pour verifier le mapping
					    bool = jsonAnalyseur.getName(i).equalsIgnoreCase("");}
					   if(bool)
					   {//si l'element n'as pas de name comme les ControlFlowConnector
						   new Individual(""+equivalent+""+i,equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);//création d'un individual qu'on va par la suite créer
					       
					   }
					   else{ 
						   new Individual(jsonAnalyseur.getName(i),equivalent,A.get(i),Mapping.listeBpmoElement.get(j).properties);
					   
					   }*/
				   
    		   
    	   }
    	     	               
    	     
    
       /******
        * ------------------------------------------------------------------------------------------------------
        * *******************************************************************************************************
        *** Start adding individuals into OWLOntology o (refers to example in OWL API)                          *
        * *******************************************************************************************************
        * -------------------------------------------------------------------------------------------------------
        */
    	  ArrayList<OWLIndividual> array=new ArrayList<OWLIndividual>();
       for(int i=0;i<Individual.individuals.size();i++){//création des individus de la listes individuals
    	   OWLIndividual indiv = df.getOWLNamedIndividual(
        		   IRI.create(iri + "#"+Individual.individuals.get(i).name.replaceAll("\\s", "_"))); 
    	   System.out.println("Syso  "+Individual.individuals.get(i).properties.size());
    	   array.add(indiv);//qui va servir pour les OWLObjectProperties
    	  for(int j=0;j<Individual.individuals.get(i).properties.size();j++){//parcours des propriétés de chaque individu
    		  OWLLiteral lit;//contiendra la valeure de la DataProperty 
    		  if(Individual.individuals.get(i).properties.get(j).getClass().toString().contains("StringProperty")){//Data Property
    			 if(Individual.individuals.get(i).properties.get(j).pname.equals("hasName")){//remplir la propriété hasName
    				  lit = df.getOWLLiteral(""+Individual.individuals.get(i).name);//valeur de la data property
    			 }  
    			 else { lit = df.getOWLLiteral("");}//les autres Data property literal=""
    			 
    		   OWLDataProperty has = df.getOWLDataProperty(IRI.create(iri+"#"+Individual.individuals.get(i).properties.get(j).pname.replaceAll("\\s", "_")));
    		   
    		   OWLDataPropertyAssertionAxiom ax = df.getOWLDataPropertyAssertionAxiom(has, indiv, lit);
    	       AddAxiom addAx = new AddAxiom(o, ax);
    	       m.applyChange(addAx);}
    	   }
       }
       
       
       
       int xz=jsonAnalyseur.Child.size();
       for(int i=0;i<xz;i++)
    	   { //OWLObject property not data property
    	  int xcv=Individual.individuals.get(i).properties.size();
    		   for(int j=0;j<xcv;j++){
    		     if(Individual.individuals.get(i).properties.get(j).getClass().toString().contains("BpmoProperty")){  
			        OWLObjectProperty has = df.getOWLObjectProperty(
	    		    IRI.create(iri + "#"+Individual.individuals.get(i).properties.get(j).pname.replaceAll("\\s", "_")));
			           if(Individual.individuals.get(i).properties.get(j).pname.equals("hasTarget")){
			        	  // jsonAnalyseur.extractIngoingId(jsonAnalyseur.Child.get(7));
			        	        int xc =(jsonAnalyseur.extractOutgoingId(jsonAnalyseur.Child.get(i))).size();
			        			   for(int z=0; z<xc;z++){
			        			    	 int x=jsonAnalyseur.getByResourceId(jsonAnalyseur.extractOutgoingId(A.get(i)).get(z).toString());
			        			    	// System.out.println(i+","+j.get("stencil")); verified
			        			    	 OWLAxiom assertion = df.getOWLObjectPropertyAssertionAxiom(
			        		    	    		  has,array.get(i),array.get(x));
			        			    	 AddAxiom addAxiomChange = new AddAxiom(o, assertion);
			           	    		     m.applyChange(addAxiomChange);
			        			     }//for z
 			              } //if hasTarget
			           else  if(Individual.individuals.get(i).properties.get(j).pname.equals("hasSource")){
				                int cv=jsonAnalyseur.extractIngoingId(jsonAnalyseur.Child.get(i)).size();
			        	         for(int z=0; z<cv;z++){
	        			    	       int x=jsonAnalyseur.getByResourceId(jsonAnalyseur.extractIngoingId(A.get(i)).get(z).toString());
	        			    	       // System.out.println(i+","+j.get("stencil")); verified
	        			    	       OWLAxiom assertion = df.getOWLObjectPropertyAssertionAxiom(
	        		    	    		  has,array.get(i),array.get(x));
	        			    	       AddAxiom addAxiomChange = new AddAxiom(o, assertion);
	           	    		           m.applyChange(addAxiomChange);
	        			     }//end for z parcours des outgoing's
 			             } //end else if hasSource
			           else  if(Individual.individuals.get(i).properties.get(j).pname.equals("hasOutgoingConnection")){
			           
			           }// end if hasOutgoingConnection
			           else if(Individual.individuals.get(i).properties.get(j).pname.equals("hasHomeProcess")){
			        	   
			           }// end if hasHomeProcess
			      }//end if bmpProperty
    		   }// end for j parcours des propriétés 
    		   OWLClass tClass = df.getOWLClass(IRI.create(iri+"#"+Individual.individuals.get(i).type));
    		   OWLClassAssertionAxiom classAssertion = df.getOWLClassAssertionAxiom(tClass, array.get(i));
    		   m.addAxiom(o, classAssertion);
    		   
    		   
             }  //end for i parcours des individus
      
   
    	 
    
      
       //** Finish adding individuals into OWLOntology o 
      

       
       File file = new File("BPaaS1.owl");//créer le fichier
       FileOutputStream fop;
		fop = new FileOutputStream(file);
		m.saveOntology(o,fop);
		fop.flush();
		fop.close();
	}
	
       
       
    catch(OWLOntologyCreationException e)
       {e.printStackTrace();}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 catch (OWLOntologyStorageException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
		
	}
	
	
}
