package Galerie_Art.Galerie_Art;
import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
public class App 
{
    public static void main( String[] args )
    {
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB database = mongoClient.getDB("Galerie");
		DBCollection collection = database.getCollection("peinture");
    	Scanner sc=new Scanner(System.in);
    	String command=null;
    	while(true) {
    		System.out.println(" vous devez choisir une option ");
    		
    		command=sc.next();
    		if(command.equals("exit"))break;
    		else if (command.equals("Afficher")) afficher(collection);
    		else if (command.equals("inserer")) inserer(sc,collection);
    		else if (command.equals("rechercher")) rechercher(sc,collection);
 
    		
    	}
    	
    	
    }
    
    static void afficher(DBCollection collection) {
    	
    	
    }
    static void inserer(Scanner sc,DBCollection collection) {
    	
    }
    static void rechercher(Scanner sc,DBCollection collection) {
    	
    }
    
}
