import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class xmlReader {
	
	public static String typeDiagramme (String filePath){
		/*
         * Etape 1 : r�cup�ration d'une instance de la classe "DocumentBuilderFactory"
         */
	final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	try {
		 /*
         * Etape 2 : cr�ation d'un parseur
         */
		final DocumentBuilder builder = factory.newDocumentBuilder();
		/* 
		 * Etape 3 : cr�ation d'un document
		 * */
		final Document document= builder.parse(new File(filePath));
		
		/* 
		 * Etape 4 : recuperation de l'Element racine
		 * */
		final Element racine = document.getDocumentElement();
		    
		//naviguer dans le document xml
   		
        Node T= document.getElementsByTagName("type").item(0);
       
        //System.out.println(i);
               
        System.out.println(T.getNodeName()+"  "+T.getTextContent());
        return(T.getTextContent());
    
	
	}
	
	
	
	
        catch (final ParserConfigurationException e) {
    	    e.printStackTrace();
    	    return null;
    	}
    	catch (final SAXException e) {
    	    e.printStackTrace();
    	    return null;
    	}
    	catch (final IOException e) {
    	    e.printStackTrace();
    	    return null;
    	}
    	
    	
   

		
   
    }
   
		
	
	public static String recuperationJsonText (String filePath) {
		// TODO Auto-generated method stub
		/*
         * Etape 1 : r�cup�ration d'une instance de la classe "DocumentBuilderFactory"
         */
	final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
	try {
		 /*
         * Etape 2 : cr�ation d'un parseur
         */
		final DocumentBuilder builder = factory.newDocumentBuilder();
		/* 
		 * Etape 3 : cr�ation d'un document
		 * */
		final Document document= builder.parse(new File(filePath));
		
           //test1	
		//Affiche la version de XML
		System.out.println("1  "+document.getXmlVersion());
		//Affiche l'encodage
		System.out.println("2  "+document.getXmlEncoding());	
		//Affiche s'il s'agit d'un document standalone		
		System.out.println("3  "+document.getXmlStandalone());

		/* 
		 * Etape 4 : recuperation de l'Element racine
		 * */
		final Element racine = document.getDocumentElement();
		     //test2
		System.out.println("nom de la racine...  "+racine.getNodeName());
	
		//navigeur dans le document xml
   Node N = document.getElementsByTagName("json-representation").item(0);
   //int i = document.getElementsByTagName("json-representation").getLength();
   //System.out.println(i);
   System.out.println("nom du noeud stock� en N  "+N.getNodeName());
  //Pointer sur le noeud data 
   Node Data = N.getFirstChild();
   System.out.println("Data "+Data.getNodeName());
   String Json = Data.getNodeValue();
   System.out.println("Json  "+Json);
		
   
   return(Json);
 /*  JSONParser parser = new JSONParser();
  
   ContainerFactory containerFactory = new ContainerFactory(){
	    public List creatArrayContainer() {
	      return new LinkedList();
	    }

	    public Map createObjectContainer() {
	      return new LinkedHashMap();
	    }
	                        
	  };
	  
	  Map json = (Map)parser.parse(Json, containerFactory);
	    Iterator iter = json.entrySet().iterator();
	    System.out.println("==iterate result==");
	    while(iter.hasNext()){
	      Map.Entry entry = (Map.Entry)iter.next();
	      System.out.println(entry.getKey() + "=>" + entry.getValue());
	      System.out.println("==toJSONString()==");
	      System.out.println(JSONValue.toJSONString(json));
	  
	  
  
	}*/
	    
	}
	
	

	/*catch(ParseException pe){
	     System.out.println("position: " + pe.getPosition());
	     System.out.println(pe);
	   }
    */
	catch (final ParserConfigurationException e) {
	    e.printStackTrace();
	    return null;
	}
	catch (final SAXException e) {
	    e.printStackTrace();
	    return null;
	}
	catch (final IOException e) {
	    e.printStackTrace();
	    return null;
	}
	
	}

	
}
