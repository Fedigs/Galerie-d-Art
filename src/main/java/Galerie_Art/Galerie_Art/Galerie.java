package Galerie_Art.Galerie_Art;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class Galerie {
	private final int nbMaxOeuvre=100;
	private String nomOrg;
	private String adresse;
	private int nbOeuvre;
	public Galerie(String nomOrg, String adresse, int nbOeuvre) {
		super();
		this.nomOrg = nomOrg;
		this.adresse = adresse;
		this.nbOeuvre = nbOeuvre;
	}
	public String getNomOrg() {
		return nomOrg;
	}
	public void setNomOrg(String nomOrg) {
		this.nomOrg = nomOrg;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNbOeuvre() {
		return nbOeuvre;
	}
	public void setNbOeuvre(int nbOeuvre) {
		this.nbOeuvre = nbOeuvre;
	}
	public int getNbMaxOeuvre() {
		return nbMaxOeuvre;
	}
	void AjouterPeintre(Peinture p) {
	   
        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("Galerie");
        DBCollection collection = database.getCollection("peinture");
        BasicDBObject basic = new BasicDBObject();
        basic.put("nom", p.getNom());
        basic.put("date", p.getDate_création());
        basic.put("theme", p.getThème());
        basic.put("prix", p.getPrix());
        basic.put("vendue", p.isVendue());
        basic.put("createur", p.getCreateur());
    	basic.put("taille", p.getTaille());
        collection.insert(basic);
        this.nbOeuvre+=1;


}

	void RetournerPeintures() {
		MongoClient mongoClient = new MongoClient();
	    DB database = mongoClient.getDB("Galerie");
	    DBCollection collection = database.getCollection("peinture");
	    
	    DBCursor dBCursor = collection.find();
    	
   	 while(dBCursor.hasNext()) {
        	System.out.println( dBCursor.next() );
        }    
	    
	}
 void AjouterSculpture(Sculpture s) {
	 MongoClient mongoClient = new MongoClient();
     DB database = mongoClient.getDB("Galerie");
     DBCollection collection = database.getCollection("sculpture");
     BasicDBObject basic = new BasicDBObject();
     basic.put("nom", s.getNom());
     basic.put("date", s.getDate_création());
     basic.put("theme", s.getThème());
     basic.put("prix", s.getPrix());
     basic.put("vendue", s.isVendue());
     basic.put("createur", s.getCreateur());
     basic.put("volume", s.getVolume());
     basic.put("poids", s.getPoids());
     basic.put("matière", s.getMatière());
     collection.insert(basic);
     this.nbOeuvre+=1;
     
   		 
   	 }
 void RetournerSculptures() {
		MongoClient mongoClient = new MongoClient();
	    DB database = mongoClient.getDB("Galerie");
	    DBCollection collection = database.getCollection("sculpture");
	    
	    DBCursor dBCursor = collection.find();
 	
	 while(dBCursor.hasNext()) {
     	System.out.println( dBCursor.next() );
     }    
	    
	}
 
 void OeuvresEntrePrix(double p1,double p2) {
	  MongoClient mongoClient = new MongoClient();
	     DB database = mongoClient.getDB("Galerie");
	try{
		/********chercher tous les scluptures avec ces prix***********/
		DBCollection collection = database.getCollection("sclupture");
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("prix", new BasicDBObject("$gt", p1).append("$lt", p2));
		DBCursor cursorScluptures = collection.find(searchQuery);
		 
		while (cursorScluptures.hasNext()) {
		    System.out.println(cursorScluptures.next());
		}
		/*************chercher tous les peintures avec ces prix*********/
		DBCollection collection2 = database.getCollection("peinture");
		BasicDBObject searchQuery2 = new BasicDBObject();
		searchQuery2.put("prix", new BasicDBObject("$gt", p1).append("$lt", p2));
		DBCursor cursorPeinture = collection2.find(searchQuery2);
		 
		while (cursorPeinture.hasNext()) {
		    System.out.println(cursorPeinture.next());
		}
	}catch(Exception e) {
	        throw new RuntimeException("Aucun oeuvre avec ces prix " , e);

	}
	 
	 
 }
 
 
 void OeuvreAvecNom(String nom) {
		
		try {
		    MongoClient mongoClient = new MongoClient();
		    DB database = mongoClient.getDB("Galerie");
		    /********chercher tous les scluptures avec ce nom***********/
		
			DBCollection collection = database.getCollection("sclupture");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("nom", new BasicDBObject("$regex", nom));
			DBCursor cursor = collection.find(searchQuery);
			 
			while (cursor.hasNext()) {
			    System.out.println(cursor.next());
			}
			/*************chercher tous les peintures avec ce nom*********/
			DBCollection collection2 = database.getCollection("peinture");
			BasicDBObject searchQuery2 = new BasicDBObject();
			searchQuery2.put("nom",  new BasicDBObject("$regex", nom));
			DBCursor cursor2 = collection2.find(searchQuery2);
			 
			while (cursor2.hasNext()) {
			    System.out.println(cursor2.next());
			}
		}catch(Exception e) {
	        throw new RuntimeException("Aucun oeuvre avec ce nom " , e);
		}
		
}	    

	
	
	

}
