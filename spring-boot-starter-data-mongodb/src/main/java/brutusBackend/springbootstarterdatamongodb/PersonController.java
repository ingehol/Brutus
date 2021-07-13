package brutusBackend.springbootstarterdatamongodb;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PersonController {

	public static String ConnectionString = "mongodb://localhost:27017";
	public static MongoClient mongoClient = MongoClients.create(ConnectionString);
	public static MongoCollection<Document> people = mongoClient.getDatabase("brutus").getCollection("people");
	
	 @Autowired
	  PersonRepository personRepository;

	 //NOT IN USE
	    @RequestMapping(method = RequestMethod.POST, value = "/people")
	    public Person save(@RequestBody Person person) {
	        personRepository.save(person);

	        return person;
	    }
	    
	    //Gets everyone if no parameters. Filters if parameters are given.
	    @RequestMapping(method = RequestMethod.GET, value = "/peopleSearch")
	    public List<Document> peopleSearch(@RequestParam(required = false) String seq, String firstname, String lastname, String street, String state, String city, String age, String latitude, String longitude, String ccnumber) {
	    	return PeopleManager.findBySearch(seq, firstname, lastname, street, state, city, age, latitude, longitude, ccnumber);
	    }
	    
	    //NOT IN USE
	    @RequestMapping(method = RequestMethod.PUT, value = "/people/{seq}")
	    public Person update(@PathVariable String seq, @RequestBody Person person) {
	        Document optperson = PeopleManager.findBySeq(seq);
	        Person p = new Person(optperson.getString("seq"), optperson.getString("firstName"), optperson.getString("lastName"), optperson.getString("age"),
	    			optperson.getString("street"), optperson.getString("city"), optperson.getString("state"), optperson.getString("latitude"), optperson.getString("longitude"), optperson.getString("ccnumber"));
	        personRepository.save(p);
	        return p;
	    }

	    //NOT IN USE, not working.
	    @RequestMapping(method = RequestMethod.DELETE, value = "/people/{seq}")
	    public String delete(@PathVariable String seq) {
	        Document optperson = PeopleManager.findBySeq(seq);
	        Person person = new Person(optperson.getString("seq"), optperson.getString("firstName"), optperson.getString("lastName"), optperson.getString("age"),
	    			optperson.getString("street"), optperson.getString("city"), optperson.getString("state"), optperson.getString("latitude"), optperson.getString("longitude"), optperson.getString("ccnumber"));
	        personRepository.delete(person);

	        return "";
	    }
//	    
//	    @RequestMapping(method = RequestMethod.GET, value = "/people/{seq}")
//	    public Document show(@PathVariable("seq") String seq) {
//	        return PeopleManager.findBySeq(seq);
//	    }
//	    
//		@RequestMapping(method = RequestMethod.GET, value = "/people/state/{state}")
//		public List<Document> findByState(@PathVariable("state") String state) {
//		  List<Document> listByState = new ArrayList<>();
//		  listByState = PeopleManager.findByState(state);
//		  return listByState;
//		}
//		  
//		@RequestMapping(method = RequestMethod.GET, value= "/people/city/{city}")
//		public List<Document> findByCity(@PathVariable("city") String city) {
//		  List<Document> listByCity = new ArrayList<>();
//		  listByCity = PeopleManager.findByCity(city);
//		  return listByCity;
//		}
	    
//		 @RequestMapping(method = RequestMethod.GET, value = "/people")
//	    public List<Document> person() {
//	        return PeopleManager.getAllPeople();
//	    }
	  
//	  @RequestMapping(method = RequestMethod.GET, value = "/allPeople")
//	  @ResponseBody
//	  public List<Document> listPeople() {
//		  List<Document> listPeople = new ArrayList<>();
//		  listPeople = PeopleManager.getAllPeople();
//		  return listPeople;
//	  }
	  
//	  @PostMapping("/addPerson")
//	  public ResponseEntity<Document> addPerson(@RequestBody Person person) {
//	    try {
//	    	Person _person = personRepository.save(new Person(person.seq, person.firstName, person.lastName, person.age, person.street, person.city, person.state, person.latitude, person.longitude, person.ccnumber));
//	    	return new ResponseEntity<>(_person, HttpStatus.CREATED);
//	    } catch (Exception e){
//	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
	  

	  
//	  @GetMapping("/addPerson")
//	  @ResponseBody
//	  public Person addPerson() {
//		  return PeopleManager.addNewPerson(null, null, null, null, null, null, null, null, null, null);
//		  
//	  }
//	  @PutMapping("/insert")
//	    public void insert(@RequestBody Document document) {
//
//	        PeopleManager.addNewPerson().insert(document);
//	    }
}
