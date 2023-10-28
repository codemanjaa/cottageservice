package cottageSemanticService;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;

public class SWDB {

	private String queryResult;
	
	/*
	
	public void searchForResult(String pathDB, String p1, String p2, String p3) {		

	   System.out.println("Do query...");
		
       Model model = RDFDataMgr.loadModel(pathDB) ;
       OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
       OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);

       String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
       		"PREFIX e: <http://example.org/ex>\n" + 
       		"PREFIX b: <http://example.org/ItemOntology>\n" + 
       		"SELECT ?itemId \n" + 
       		"WHERE {  ?item rdf:type b:Item.\n" + 
       		"         ?item b:hasParam01 \""+p1+"\".\n" + 
       		"         ?item b:hasParam02 \""+p2+"\".\n" + 
       		"         ?item b:hasParam03 \""+p3+"\".\n" + 
       		"         ?item b:itemID ?itemId.\n" + 
       		"}";
       
       String queryString_ = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
          		"PREFIX e: <http://example.org/ex>\n" + 
          		"PREFIX b: <http://example.org/ItemOntology>\n" + 
          		"SELECT ?itemId \n" + 
          		"WHERE {  ?item rdf:type b:Item.\n" + 
          		"         ?item b:hasParam01 \""+p1+"\".\n" + 
          		"         ?item b:itemID ?itemId.\n" + 
          		"}";
       
       Dataset dataset = DatasetFactory.create(ontModel);
       Query q = QueryFactory.create(queryString);

       QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
       ResultSet resultSet = qexec.execSelect();
       
       System.out.println("Results: ---");       
       while(resultSet.hasNext()) {
    	   QuerySolution row = (QuerySolution)resultSet.next();
    	   RDFNode nextItemId = row.get("itemId");
    	   System.out.print("ItemID is: "+nextItemId.toString()+".\n"); 
    
       }
       System.out.println("------------");
    	   
	} 	
	*/
	
	
	
	
	public void searchForCottageResult(String pathDB, String bookerName, int nPlaces, int nRooms, int lakeDistance, int cityDistance, int noOfDays) {		

		   System.out.println("We are working on your query with the data --- "+ bookerName+"   "+nPlaces+"   "+ nRooms);
	       Model model = RDFDataMgr.loadModel(pathDB) ;
	       OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
	       OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);
	      
	       
	       String queryString = "prefix : <http://localhost:8080/cottageService/CottageOntology#> \r\n"
	       		+ "prefix pto: <http://www.productontology.org/id/> \r\n"
	       		+ "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \r\n"
	       		+ "prefix xml: <http://www.w3.org/XML/1998/namespace> \r\n"
	       		+ "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \r\n"
	       		+ "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \r\n"
	       		+ "base <http://localhost:8080/cottageService/CottageOntology#> \r\n"
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "PREFIX b: <http://localhost:8080/cottageService/CottageOntology#>\r\n"
	       		+ "\r\n"
	       		+ "\r\n"
	       		+ "SELECT  ?name ?address ?nPlaces ?nRooms ?lake ?lakeDistance ?city ?cityDistance ?url \r\n"
	       		+ "WHERE {   \r\n"
	       		+ "	?item rdf:type pto:Cottage .\r\n"
	       		+ "    ?item :hasName ?name .\r\n"
	       		+ "    ?item :hasAddress ?address .\r\n"
	       		+ "    ?item :hasNPlaces ?nPlaces .\r\n"
	       		+ "    ?item :hasNRooms ?nRooms .\r\n"
	       		+ "    ?item :hasNearestLake ?lake .\r\n"
	       		+ "    ?item :hasLakeDistance ?lakeDistance .\r\n"
	       		+ "    ?item :hasNearestCity  ?city .\r\n"
	       		+ "    ?item :hasCityDistance ?cityDistance .\r\n"
	       		+ "    ?item :hasUrl ?url .\r\n"
	       		+ "    FILTER((xsd:integer(?nRooms) >= \"" + Integer.valueOf(nRooms) +"\"^^xsd:integer) && ((xsd:integer(?nPlaces) >= \"" + Integer.valueOf(nPlaces) + "\"^^xsd:integer)) && (xsd:integer(?lakeDistance) <=  \"" + Integer.valueOf(lakeDistance) + "\"^^xsd:integer) && (xsd:integer(?cityDistance) <= \"" + Integer.valueOf(cityDistance) + "\"^^xsd:integer)) .\r\n"
	       		+ "} ";
	       
	      /* 
	       String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
	       		"PREFIX e: <http://example.org/ex>\n" + 
	       		"PREFIX b: <http://example.org/CottageOntology>\n" + 
	       		"SELECT  ?cottageName ?cottageAddress ?hasPlaces ?hasRooms ?hasImage ?hasNearestCity \n" + 
	       		"WHERE {  ?item rdf:type b:Cottage.\n" + 
	       		"         ?item b:hasPlaces \""+nPlaces+"\".\n" + 
	       		"         ?item b:hasRooms \""+nRooms+"\".\n" + 
	       		"         ?item b:hasName ?cottageName .\n" + 
	       		"         ?item b:hasAddress ?cottageAddress .\n" + 
	       		"         ?item b:hasNearestCity ?hasNearestCity .\n" +
	       		"         ?item b:hasImageURL ?hasImage .\n" + 
	       		"}";
	       		*/
	       
	     /*  String queryString_ = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
	          		"PREFIX e: <http://example.org/ex>\n" + 
	          		"PREFIX b: <http://example.org/ItemOntology>\n" + 
	          		"SELECT ?itemId \n" + 
	          		"WHERE {  ?item rdf:type b:Item.\n" + 
	          		"         ?item b:hasParam01 \""+p1+"\".\n" + 
	          		"         ?item b:itemID ?itemId.\n" + 
	          		"}";*/
	       
	       System.out.println("OUR QUERYSTRING "+queryString);
	       
	       Dataset dataset = DatasetFactory.create(ontModel);
	       Query q = QueryFactory.create(queryString);

	       QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
	       ResultSet resultSet = qexec.execSelect();
	       
	       // write to a ByteArrayOutputStream
	       ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	       ResultSetFormatter.outputAsJSON(outputStream, resultSet);

	       // and turn that into a String
	       String json = new String(outputStream.toByteArray());
	       queryResult = json.toString();

	       System.out.println("This is our JSON  "+json);
	       
	       
	       
	       System.out.println("Results: ---"+resultSet);       
	     /*
	       while(resultSet.hasNext()) {
	    	   QuerySolution row = (QuerySolution)resultSet.next();
	    	   RDFNode nextItemId = row.get("cottageID");
	    	   RDFNode nextItemName = row.get("cottageName");
	    	   RDFNode nextAddress = row.get("cottageAddress");
	    	   System.out.print("CottageID is: "+nextItemId.toString()+".\n"); 
	    	   System.out.print("Cottage Name is: "+nextItemName.toString()+".\n"); 
	    	   System.out.print("Cottage Address is: "+nextAddress.toString()+".\n"); 
    
	       }*/
	       
	  
	       System.out.println("------------");	   
		} 	
		
	
	public String getResult(){
		//queryResult = "Done!";
		return queryResult;
	}
}
