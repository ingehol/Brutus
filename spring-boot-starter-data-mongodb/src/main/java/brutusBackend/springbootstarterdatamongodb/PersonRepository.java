package brutusBackend.springbootstarterdatamongodb;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String>{
	@Override
	void delete(Person deleted);
//	List<Document> findByState(String state);
//	List<Document> findByCity(String city);
//	List<Document> findByAge(BsonInt32 age);
}
