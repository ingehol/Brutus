package brutusBackend.springbootstarterdatamongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class PeopleManager {
	public static String ConnectionString = "mongodb://localhost:27017";
	public static MongoClient mongoClient = MongoClients.create(ConnectionString);
	public static MongoCollection<Document> people = mongoClient.getDatabase("brutus").getCollection("people");
	
	public static Document findBySeq(String seq) {
		var query = new Document("seq", seq);
		return people.find(query).first();
	}
	
	public static List<Document> findBySearch(String seq, String firstname, String lastname, String street, String state, String city, String age, String latitude, String longitude, String ccnumber) {
		List<Document> listBySearch = new ArrayList<>();
		var query = new Document();
		if(seq != null) {
			query.append("seq", seq);
		}
		if (firstname != null) {
			query.append("firstname", firstname);
		}
		if (lastname != null) {
			query.append("lastname", lastname);
		}
		if (street != null) {
			query.append("street", street);
		}
		if(state != null) {
			query.append("state", state);
		}
		if(city != null) {
			query.append("city", city);
		}
		if (age != null) {
			query.append("age", age);
		}
		if (latitude != null) {
			query.append("latitude", latitude);
		}
		if (longitude != null) {
			query.append("longitude", longitude);
		}
		if (ccnumber != null) {
			query.append("ccnumber", ccnumber);
		}
		people.find(query).into(listBySearch);
		return listBySearch;
	}
	
	public static void main(String[] args) {
		//getAllPeople();
		//findByState("CA");
		//findByCity("Zepobim");
		//findBySeq("2");
		//importOldData(mongoClient);
		//createDocuments(mongoClient);
		//printDatabases(mongoClient);
	
	}
	
	//Method for importing the old data from datasett.csv before I figured out
	//that mongoDB has an automatic implementation of CSV-files.
//		private static void importOldData(MongoClient mongoClient) {
//			String file = "./data/datasett.csv";
//	        List<Document> documents = new ArrayList<Document>();
	//
//	        try {
//			BufferedReader reader = new BufferedReader(new FileReader(file));
//	        reader.readLine (); // read each row of data represents
//			String line = null;
//			while((line = reader.readLine())!=null) {
//				String [] item = line.split ( ","); // csv file is "" separated
//				String seq = item [0]; // get the value in the csv assign keywords
//				String firstName = item[1];
//				String lastName = item[2];
//				String age = item[3];
//				String street = item[4];
//				String city = item[5];
//				String state = item[6];
//				String latitude = item[7];
//				String longitude = item[8];
//				String ccnumber = item[9];
//				
//				Document document = new Document (); // create a document
//				document.put ( "seq", seq); // data into the database
//				document.put("Firstname", firstName);
//				document.put("Lastname", lastName);
//				document.put("Age", age);
//				document.put("Street", street);
//				document.put("City", city);
//				document.put("State", state);
//				document.put("Latitude", latitude);
//				document.put("Longitude", longitude);
//				document.put("ccnumber", ccnumber);
//				System.out.println(document);
//				documents.add(document);
//			}
//			//System.out.println(documents);
//	        //collection.insertMany (documents); // set the document into the database
//	        } catch (Exception e){
//	        	e.printStackTrace();
//	        }
//
//		}
	
	
//	private static void addNewPerson(BsonInt32 seq, String firstName, String lastName, BsonInt32 age,
//			String street, String city, String state, Decimal128 latitude, Decimal128 longitude, String ccnumber) {
//		
//		Document document = new Document (); // create a document
//		document.put ( "seq", seq); // data into the database
//		document.put("name/first", firstName);
//		document.put("name/last", lastName);
//		document.put("age", age);
//		document.put("street", street);
//		document.put("city", city);
//		document.put("state", state);
//		document.put("latitude", latitude);
//		document.put("longitude", longitude);
//		document.put("ccnumber", ccnumber);
//		System.out.println(document);
//		
//		people.insertOne(document);
//		//documents.add(document);
//	//System.out.println(documents);
//    //collection.insertMany (documents); // set the document into the database
//	}
	
//	public static Object getAllDatabases() {
//		List<Document> dbDocument = mongoClient.listDatabases().into(new ArrayList<>());
//		dbDocument.forEach(document -> System.out.println(document.toJson()));
//		return dbDocument;
//	}
	
//	static List<Document> getAllPeople() {
//		List<Document> peopleList = new ArrayList<>();
//		people.find().forEach(person -> peopleList.add(new Document(person)));
//		return peopleList;
//	}
	
	
//	public static List<Document> findByState(String state) {
//		List<Document> listByState = new ArrayList<>();
//		var query = new Document("state", state);
//		people.find(query).into(listByState);
//		return listByState;
//	}
//	
//	public static List<Document> findByCity(String city) {
//		List<Document> listByCity = new ArrayList<>();
//		var query = new Document("city", city);
//		people.find(query).into(listByCity);
//		return listByCity;
//	}
	
//	public static List<Document> findByAge(String age) {
//		List<Document> listByAge = new ArrayList<>();
//		var query = new Document("age", age);
//		if(Integer.parseInt(age) > 20) {
//		people.find(query).into(listByAge);
//		}
//		return listByAge;
//	}
	
//	private static void createDocuments() {
//		//Document doc = new Document("name", "Test3");
//		//people.insertOne(doc);
//		
//		List<Document> peopleList = new ArrayList<>();
//		for(int i = 0; i < 5; i++) {
//			peopleList.add(new Document("id", i).append("name", "tester"));
//		}
//		people.insertMany(peopleList);
//		//people.forEach(person -> System.out.println(person.toJson()));
//	}
}
